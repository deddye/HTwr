/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

/**
 * @author David Dye davidd01
 * @version 10/10/2020
 *          class to make the puzzle window
 *
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    static final int WIDTH_FACTOR = 1;
    static final int DISK_GAP = 0;
    static final int DISK_HEIGHT = 10;

    /**
     * constructor
     * 
     * @param solver
     *            so the puzzle window has a hasnoi solver with it to move the
     *            front end
     */
    public PuzzleWindow(HanoiSolver solver) {
        game = solver;
        game.addObserver((Observer)this);

        window = new Window("Tower of Hanoi");

        this.left = new Shape(200, 100, 5, 100, new Color(0, 0, 0));
        this.middle = new Shape(300, 100, 5, 100, new Color(0, 0, 0));
        this.right = new Shape(400, 100, 5, 100, new Color(0, 0, 0));

        for (int i = 0; i < game.disks(); i++) {
            game.getTower(Position.RIGHT).push(new Disk(20 * (game.disks()
                - i)));
            window.addShape(game.getTower(Position.RIGHT).peek());
            moveDisk(Position.RIGHT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.SOUTH);
    }


    /**
     * pauses to see algorithm at work
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * when you click the solve button
     * 
     * @param button
     *            the button pressed
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * move disk to update front end
     * 
     * @param position
     *            makes sure youre working with the right tower
     */
    private void moveDisk(Position position) {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = this.left;
                break;
            case MIDDLE:
                currentPole = this.middle;
                break;
            case RIGHT:
                currentPole = this.right;
                break;
            default:
                currentPole = this.left;
                break;
        }
        int x = currentPole.getX();
        int y = currentPole.getY() + 100 - (this.game.getTower(position).size()
            * (DISK_HEIGHT + DISK_GAP));

        currentDisk.moveTo(x - (currentDisk.getWidth() - 5) / 2, y
            - (DISK_GAP));
    }


    @Override
    /**
     * @param o
     *            is the observable object
     * @param arg
     *            the object to where the disk will be moved
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);

        }
        sleep();
    }

}
