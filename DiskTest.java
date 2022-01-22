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
 *          class to test disks
 *
 */
public class DiskTest extends TestCase {
    
    private Disk d;
    private Disk a;
    private Disk c;
    private Disk b;
    
    /**
     * setUp to be run before each test
     */
    public void setUp() {
        d = new Disk(4);
        a = new Disk(5);
        b = new Disk(5);
    }
    
    /**
     * tests compare to method
     */
    public void testCompareTo() {
        assertEquals(-1, d.compareTo(a));
        assertEquals(1, a.compareTo(d));
        Exception thrown = null;

        try
        {
            d.compareTo(c);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("5", a.toString());
    }
    
    /**
     * tests the equals method
     */
    public void testEquals() {
        Object obj = "hi";
        assertFalse(a.equals(d));
        assertTrue(a.equals(a));
        assertTrue(a.equals(b));
        assertFalse(a.equals(obj));
    }

}
