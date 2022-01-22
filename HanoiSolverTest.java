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
 * @version 10/17/2020
 *          tests for hanoi solver
 *
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver solver;
    private int disks;

    /**
     * setup to be run before each method
     */
    public void setUp() {
        disks = 5;
        solver = new HanoiSolver(disks);

    }


    /**
     * tests the disks method
     */
    public void testDisks() {
        assertEquals(5, solver.disks());
    }


    /**
     * tests the getTower method
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.RIGHT, solver.getTower(Position.RIGHT)
            .position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.DEFAULT)
            .position());
    }


    /**
     * tests the tostring method
     */
    public void testToString() {
        solver.getTower(Position.LEFT).push(new Disk(10));
        solver.getTower(Position.MIDDLE).push(new Disk(20));
        solver.getTower(Position.RIGHT).push(new Disk(30));
        System.out.println(solver.toString());
        assertEquals("[10][20][30]", solver.toString());
    }


    /**
     * tests the solve
     */
    public void testSolve() {
        solver = new HanoiSolver(disks);
        assertEquals(0, solver.getTower(Position.RIGHT).size());
    }
}
