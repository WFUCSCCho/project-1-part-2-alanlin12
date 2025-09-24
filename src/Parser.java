import java.io.*;
import java.util.*;

public class Parser {
    //Create a BST tree of Integer type
    private BST<World> mybst = new BST<>();

    //Load in the CSV data
    private Map<Integer, World> worldData = new HashMap<>();

    public Parser(String filename, String csvFile) throws FileNotFoundException {
        processCSV(new File(csvFile));
        process(new File(filename));
    }

    // Implement the csvFile processing
    public void processCSV(File input) throws FileNotFoundException{
        Scanner sc = new Scanner(input);
        if(sc.hasNextLine()) sc.nextLine();
        while (sc.hasNextLine()) {
            String[] cols = sc.nextLine().split(",");

            int year = Integer.parseInt(cols[0].trim());
            long population = Long.parseLong(cols[1].trim());
            

            World w = new World(year, population);
            worldData.put(year, w);
        }
        sc.close();
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input) throws FileNotFoundException {
        //call operate_BST method;
        Scanner sc = new Scanner(input);
        while(sc.hasNextLine()){
            String line = sc.nextLine().replaceAll("\\s+", " ").trim();
            line = line.strip();
            if(line.length() == 0) {continue;}
            String[] command = line.split(" ");
            operate_BST(command);
        }

        sc.close();
    }
    
    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST
    public void operate_BST(String[] command) {
        switch (command[0]) {
            case "insert": {
                if(command[1] == null || !worldData.containsKey(Integer.parseInt(command[1]))){
                    writeToFile("Insert failed", "./result.txt");
                }
                else {
                    World world = worldData.get(Integer.parseInt(command[1]));
                    mybst.insert(world);
                    writeToFile("Inserted year " + Integer.parseInt(command[1]), "./result.txt");
                }
                break;
            }
            case "search": {
                World world = worldData.get(Integer.parseInt(command[1]));
                Node<World> found = mybst.search(world);
                if(found != null){writeToFile("Found year " + Integer.parseInt(command[1]), "./result.txt");}
                else writeToFile("Search failed", "./result.txt");
                break;
            }

            case "remove": {
                if(!worldData.containsKey(Integer.parseInt(command[1]))){writeToFile("Remove failed", "./result.txt");}
                else{
                    World world = worldData.get(Integer.parseInt(command[1]));
                    Node<World> remove = mybst.remove(world);
                    if(remove != null) {writeToFile("Removed year " + Integer.parseInt(command[1]), "./result.txt");}
                    else writeToFile("Remove failed", "./result.txt");
                }
                break;
            }
                
            case "print": {
                writeToFile(mybst.preOrder(), "./result.txt");
                break;
            }
            default:
                writeToFile("Invalid Command: " + command[0], "./result.txt");
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try(FileWriter f = new FileWriter(filePath, true)) {
            PrintWriter writer = new PrintWriter(f);
            writer.println(content);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}