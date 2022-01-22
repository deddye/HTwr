/**
 * 
 */
package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

/**
 * @author David Dye davidd01
 * @version 10/17/2020
 *          class to run the project
 *
 */
public class ProjectRunner {

    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(hanoi);

    }

}
