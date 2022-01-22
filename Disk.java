/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Random;
import cs2.Shape;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          class to make disks
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * constructor for disks
     * @param x is to be the width
     */
    public Disk(int x) {
        super(0, 0, x, PuzzleWindow.DISK_HEIGHT);
        Random ran = new Random();
        Color color = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(
            255));
        this.setBackgroundColor(color);
    }


    @Override
    /**
     * determines relative size of disks
     * 
     * @param o
     *            disk to be compared
     * @return number based on how they are compared
     */
    public int compareTo(Disk o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (this == o || this.getWidth() == o.getWidth()) {
            return 0;
        }
        if (this.getWidth() < o.getWidth()) {
            return -1;
        }
        return 1;
    }


    /**
     * to make string
     * 
     * @return string of what's supposed to be in the toString
     */
    public String toString() {
        String st = Integer.toString(this.getWidth());
        return st;

    }


    /**
     * determines equality
     * 
     * @param obj
     *            is to be tested
     * @return true is equals false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() == this.getClass()) {
            Disk d = (Disk)obj;
            if (this.getWidth() == d.getWidth()) {
                return true;
            }
        }
        return false;
    }

}
