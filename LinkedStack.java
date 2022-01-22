/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          class for linked stacks with generic
 * @param <T> a generic
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;

    /**
     * constructor
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    @Override
    /**
     * clears the stack
     */
    public void clear() {
        Node<T> curr = topNode;
        topNode = null;
        while (curr.getNextNode() != null) {
            curr.setNextNode(null);
            curr = curr.getNextNode();
        }
        size = 0;
    }


    @Override
    /**
     * returns true if the stack is empty false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * gets the size
     * @return the size
     */
    public int size() {
        return size;
    }


    /**
     * makes a toString of values in the stack
     * @return the toString
     */
    public String toString() {
        Node<T> curr = topNode;
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        if (curr == null) {
            builder.append(']');
            return builder.toString();
        }
        builder.append(String.valueOf(curr.getData()));
        while (curr.getNextNode() != null) {
            builder.append(", ");
            curr = curr.getNextNode();
            builder.append(String.valueOf(curr.getData()));
        }
        builder.append(']');
        return builder.toString();
    }


    @Override
    /**
     * sees which disk is at the top and returns its data
     */
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return topNode.getData();

    }


    @Override
    /**
     * removes the top node and returns its data
     */
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        else {
            Node<T> toReturn = topNode;
            topNode = toReturn.getNextNode();
            size--;
            return toReturn.getData();
        }
    }


    @Override
    /**
     * pushes object to the top of stack
     * 
     * @param item
     *            to be pushed to the top
     */
    public void push(T item) {
        Node<T> newNode = new Node<T>(item, topNode);
        topNode = newNode;
        size++;
    }
}
