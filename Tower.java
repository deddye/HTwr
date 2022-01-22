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
 * @version 10/10/2020
 *          class for the towers
 *
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * constructor for tower
     * 
     * @param pos
     *            the position the tower is in
     */
    public Tower(Position pos) {
        super();
        position = pos;
    }


    /**
     * @return the position
     */
    public Position position() {
        return position;

    }


    /**
     * puts a disk on the tower
     * 
     * @param disk
     *            the disk to be pushed
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.size() == 0 || this.peek().compareTo(disk) == 1) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }

}
