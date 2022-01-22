/**
 * 
 */
package towerofhanoi;

import student.TestCase;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          private node test class
 *
 */
public class NodeTest extends TestCase {

    private Node<String> second;
    private Node<String> top;
    private Node<String> third;

    /**
     * setup to be run before each test
     */
    public void setUp() {
        second = new Node<String>("hello");
        top = new Node<String>("hi", second);
        third = new Node<String>("hey");

    }


    /**
     * tests the get next node method
     */
    public void testGetNextNode() {
        assertEquals("hello", top.getNextNode().getData());
    }


    /**
     * tests get data
     */
    public void testGetData() {
        assertEquals("hi", top.getData());
    }


    /**
     * tests set next node
     */
    public void testSetNextNode() {
        second.setNextNode(third);
        assertEquals("hey", second.getNextNode().getData());
    }

}
