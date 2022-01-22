/**
 * 
 */
package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          private node class
 * @param <T> a generic
 */
public class Node<T> {

    private Node<T> next;
    private T data;

    /**
     * constructor for Node
     * 
     * @param gener
     *            generic to be made
     */
    public Node(T gener) {
        next = null;
        data = gener;
    }


    /**
     * advanced constructor
     * 
     * @param gener
     *            the generic data to be given to the node
     * @param next
     *            is the node to be put after this node
     */
    public Node(T gener, Node<T> next) {
        data = gener;
        this.next = next;
    }


    /**
     * gets the next node
     * 
     * @return the next node
     */
    public Node<T> getNextNode() {
        return next;
    }


    /**
     * gets the data
     * 
     * @return data
     */
    public T getData() {
        return data;
    }


    /**
     * sets the next node
     * 
     * @param nextNode
     *            node to be put next
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }
}
