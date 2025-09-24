////∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
//∗ @file: BST.java
//∗ @description: This program implements a Binary Search Tree with functions such as Insert, Remove, Search, and a
//* Pre-Order iterative traversal, along with a size module
//∗ @author: Alan Lin
//∗ @date: September 18, 2025
///∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗
class BST<T extends Comparable<T>>{
	private Node<T> root;
    private int nodecount;
    
    //Constructs the Binary Search Tree
    BST(){
        root = null;
        nodecount = 0;
    }

    //Implements the clear method, clearing the tree
    public void clear() {
        root = null;
        nodecount = 0;
    }

    //Implements the size method
    public int size(){ return nodecount; }

    //Implements the insert method, checks for duplicates (BST is a set)
    public void insert(T command){
        Node<T> temp = root;
        root = insertHelp(root, command);
        if(root != temp || root != null && !root.value().equals(command)) nodecount++;
    }

    //Helper method for the Insert method
    private Node<T> insertHelp(Node<T> rt, T key){
        if(rt == null) {return new Node<T>(key);}
        if(rt.value().compareTo(key) > 0){
            rt.setLeft(insertHelp(rt.left(), key));
        }
        else if(rt.value().compareTo(key) < 0){
            rt.setRight(insertHelp(rt.right(), key));
        }
        return rt;
    }

    //Implements searching for a node
    public Node<T> search(T val){
        return searchHelp(root, val);
    }

    //Helper method for the Search method
    private Node<T> searchHelp(Node<T> rt, T key){
        if(rt == null) {return null;}
        if(rt.value().compareTo(key) > 0){
            return(searchHelp(rt.left(), key));
        }
        else if(rt.value().compareTo(key) == 0){return rt;}
        else {return(searchHelp(rt.right(), key));}
    }

    //Implements a remove node method, if possible
    public Node<T> remove(T val){
        Node<T> temp = searchHelp(root, val);
        if(temp != null){
            T val1 = temp.value();
            root = removeHelp(root, val);
            nodecount--;

            return new Node<T>(val1);
        }
        return null;
    }

    //Gets the highest value node
    private Node<T> getMax(Node<T> rt){
        if(rt.right() == null){ return rt; }
        return(getMax(rt.right()));
    }

    //Gets rid of the highest value node
    private Node<T> deleteMax(Node<T> rt){
        if(rt.right() == null){return rt.left();}
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }

    //Helper method for the Remove method
    private Node<T> removeHelp(Node<T> rt, T key){
        if(rt == null) {return null;}
        if(rt.value().compareTo(key) > 0){
            rt.setLeft(removeHelp(rt.left(), key));
            return rt;
        }
        else if(rt.value().compareTo(key) < 0){
            rt.setRight(removeHelp(rt.right(), key));
            return rt;
        }
        else{
            if(rt.left() == null) {return(rt.right());}
            else if(rt.right() == null) {return(rt.left());}
            else{
                Node<T> temp = getMax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    //Implements an iterative method, traversing through the tree in a pre-order method
    public String preOrder(){
        return preOrderHelper(root).trim();
    }

    //Helper method for the pre-order traversal
    private String preOrderHelper(Node<T> rt){
        if(rt == null) return "";
        return(rt.value() + " " + preOrderHelper(rt.left()) + preOrderHelper(rt.right()));
    }
}
