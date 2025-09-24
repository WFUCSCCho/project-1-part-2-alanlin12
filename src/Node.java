////∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
//∗ @file: Node.java
//∗ @description: This program implements a comparable Node object that can take in and set values as well as check if
//* the node is a leaf Node.
//∗ @author: Alan Lin
//∗ @date: September 18, 2025
///∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗
class Node<T extends Comparable<? super T>> {
    //Creates a comparable data type, along with a left/right node
    T data;
    Node<T> left, right;
    
    //There are three cases, if the node implemented is empty, given a value, or a value and child values
    Node() { left = right = null;}
    Node(T val) {left = right = null; data = val;}
    Node(T val, Node<T> l, Node<T> r) {
        data = val;
        left = l;
        right = r;
    }

    //Method that returns the value of the node.
    public T value() {return data;}

    //Sets the value of the current node
    public void setValue(T val) {data = val;}

    //Returns the left child node
    public Node<T> left() {return left;}

    //Sets the value of the left child node
    public void setLeft(Node<T> val) {left = val;}

    //Returns the right child node
    public Node<T> right() {return right;}

    //Sets the value of the right child node
    public void setRight(Node<T> val) {right = val;}

    //Checks if there are child nodes present in the current node, if no child node its considered a leaf node.
    public boolean isLeaf() {return (left == null) && (right == null);}
}
