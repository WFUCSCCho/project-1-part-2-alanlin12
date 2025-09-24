/*∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: World.java
∗ @description: This program takes in the information from my World Population Growth.csv file
∗ @author: Alan Lin
∗ @date: September 26, 2025
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*/

public class World implements Comparable<World>{
    private int year;
    private long population;

    public World(int yr, long pop){
        year = yr;
        population = pop;
    }

    //Implement the toString method
    public String toString(){
        return String.valueOf(population);
    }

    //Implement the equal method
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        World temp = (World) obj;

        return(year == temp.year && 
        population == temp.population);
    }

    //Implements the compareTo method
    @Override
    public int compareTo(World obj){
        return(Long.compare(population, obj.population));
    }

}
