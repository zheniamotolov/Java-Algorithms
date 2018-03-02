package Maze;

/**
 * Created by eugene on 11/13/17.
 */
public class Cell {
    int up;
    int right;
    int down;
    int left;
    int x;
    int y;
    boolean isVisited;

    public Cell(int up, int right, int down, int left, int x, int y) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.x = x;
        this.y = y;
    }
}
