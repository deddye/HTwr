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
 *          class to test linked stacks with generic
 *
 */
public class LinkedStackTest extends TestCase {
    
    private LinkedStack<String> bag;
    
    /**
     * setup to be run before each method
     */
    public void setUp() {
        bag = new LinkedStack<String>();
        bag.push("hi");
    }
    
    /**
     * tests push method
     */
    public void testPush() {
        assertEquals(1, bag.size());
        bag.push("hi");
        assertEquals(2, bag.size());
    }
    
    /**
     * tests the pop method
     */
    public void testPop() {
        assertEquals("hi", bag.pop());
        assertEquals(0, bag.size());
        Exception thrown = null;

        try
        {
            bag.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * tests the size method
     */
    public void testSize() {
        assertEquals(1, bag.size());
    }
    
    /**
     * tests the clear method
     */
    public void testClear() {
        bag.clear();
        assertEquals(0, bag.size());
        assertEquals("[]", bag.toString());
    }
    
    /**
     * tests the is empty method
     */
    public void testIsEmpty() {
        assertFalse(bag.isEmpty());
        bag.clear();
        assertTrue(bag.isEmpty());
    }
    
    /**
     * tests peek method
     */
    public void testPeek() {
        Object obj = bag.peek();
        assertEquals("hi", obj);
        bag.clear();
        Exception thrown = null;

        try
        {
            bag.peek();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * tests to string method
     */
    public void testToString() {
        assertEquals("[hi]", bag.toString());
        bag.push("ye");
        assertEquals("[ye, hi]", bag.toString());
    }

}
