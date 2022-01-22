/**
 * 
 */
package towerofhanoi;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          class to test towers
 *
 */
public class TowerTest extends TestCase {
    
    private Tower tow;
    private Disk d1;
    private Disk d2;
    private Disk d3;
    
    /**
     * to be run before each method
     */
    public void setUp() {
        tow = new Tower(Position.RIGHT);
        d1 = new Disk(5);
        d2 = new Disk(10);
    }
    
    /**
     * tests the position method
     */
    public void testPosition() {
        assertEquals(Position.RIGHT, tow.position());
    }
    
    /**
     * tests the push method
     */
    public void testPush() {
        tow.push(d2);
        assertEquals(1, tow.size());
        tow.push(d1);
        assertEquals(2, tow.size());
        
        Exception exception = null;
        try {
            tow.push(d3);
            fail("push(d3) is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push(d3) is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
        
        Boolean test = false;
        try {
            tow.push(d2);
        }
        catch (Exception e) {
            test = true;
        }
        assertTrue(test);
        
    }

}
