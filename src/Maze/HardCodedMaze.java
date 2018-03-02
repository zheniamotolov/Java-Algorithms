package Maze;

import java.util.Stack;

/**
 * Created by eugene on 11/14/17.
 */
public class HardCodedMaze {
    Cell[][] maze;
    int height;
    int width;
    Stack<Cell> stack;
    int i = 0;
    java.util.Random rand = new java.util.Random();

    public HardCodedMaze(int height, int width) {
        stack = new Stack<Cell>();
        this.height = height;
        this.width = width;
        maze = new Cell[height][width];
        initialize();
    }


    void initialize() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell(0, 0, 0, 0, j, i);
            }
        }
    }

    //y=i(height),x=j(width)
    void generate(Cell cell) {

        i++;
        int temp = rand.nextInt(4);
        if (temp == 0) {
            if (cell.y > 0) {
                if ((isSatisfuedBorders(maze[cell.y - 1][cell.x])) && (!maze[cell.y - 1][cell.x].isVisited)) {
                    maze[cell.y][cell.x].up = 1;
                    maze[cell.y - 1][cell.x].down = 1;
                    cell.isVisited = true;
                    generate(maze[cell.y - 1][cell.x]);
                }
                else{
                    generate(cell);
                }
            }
        } else if (temp == 1) {
            if (cell.x < width - 1) {
                if ((isSatisfuedBorders(maze[cell.y][cell.x + 1])) && (!maze[cell.y][cell.x + 1].isVisited)) {
                    maze[cell.y][cell.x].right = 1;
                    maze[cell.y][cell.x + 1].left = 1;
                    cell.isVisited = true;
                    generate(maze[cell.y][cell.x + 1]);
                }
            }
            else{
                generate(cell);
            }
        } else if (temp == 2) {
            if (cell.y < height - 1) {
                if ((isSatisfuedBorders(maze[cell.y + 1][cell.x])) && (!maze[cell.y + 1][cell.x].isVisited)) {
                    maze[cell.y][cell.x].down = 1;
                    maze[cell.y + 1][cell.x].up = 1;
                    cell.isVisited = true;
                    generate(maze[cell.y + 1][cell.x]);
                }
            } else{
                generate(cell);
            }
        } else if (temp == 3) {
            if (cell.x > 0) {
                if ((isSatisfuedBorders(maze[cell.y][cell.x - 1])) && (!maze[cell.y][cell.x - 1].isVisited)) {
                    maze[cell.y][cell.x].left = 1;
                    maze[cell.y][cell.x - 1].right = 1;
                    cell.isVisited = true;
                    generate(maze[cell.y][cell.x - 1]);

                }

            } else{
                generate(cell);
            }

        }

    }


    boolean isSatisfuedBorders(Cell cell) {
        int x = cell.x;
        int y = cell.y;
        if (((x >= 0) && (x <= width)) && ((y >= 0) && (y <= width))) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        for (int i = 0; i < height; i++) {
            // draw the north edge
            for (int j = 0; j < width; j++) {
                if (maze[i][j].up == 0) {
                    System.out.print("+---");
                } else {
                    System.out.print("+   ");
                }
//                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < width; j++) {
                if (maze[i][j].left == 0) {
                    System.out.print("|   ");
                } else {
                    System.out.print("    ");
                }
//                System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");

            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < width; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
        System.out.println(i);

    }

}
