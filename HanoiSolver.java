/**
 * 
 */
package towerofhanoi;

import java.util.Observable;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

/**
 * @author David Dye davidd01
 * @version 10/17/2020
 *          class for the hanoi solver
 *
 */

public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * constructor for the solver
     * 
     * @param numDisks
     *            amount of disks to use
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * gets the amount of disks
     * 
     * @return numDisks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * gets the position of the tower
     * 
     * @param position
     *            is the position of the tower being called
     * @return the tower which was got
     */
    public Tower getTower(Position position) {
        switch (position) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;

        }
    }


    /**
     * to string for hanoi solver
     * 
     * @return a string which is the toString
     */
    public String toString() {
        StringBuilder string = new StringBuilder("");
        string.append(this.left);
        string.append(this.middle);
        string.append(this.right);
        return string.toString();
    }


    /**
     * method which moves the disk
     * 
     * @param from
     *            tower to move from
     * @param to
     *            the destination tower
     */
    private void move(Tower from, Tower to) {
        Disk disk = from.pop();
        to.push(disk);
        this.setChanged();
        this.notifyObservers(to.position());
    }


    /**
     * method with algorithm to solve the disks
     * 
     * @param currentDisks
     *            amount of starting disks on the first tower
     * @param startPole
     *            pole where they all start at
     * @param tempPole
     *            middle pole
     * @param endPole
     *            pole to get them all to
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            System.out.println(this.toString());
            move(startPole, endPole);
        }
        else if (currentDisks > 1) {
            System.out.println(this.toString());
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * method to start the solve
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }

}
