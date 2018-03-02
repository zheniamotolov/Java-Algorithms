package Maze;

/**
 * Created by eugene on 11/14/17.
 */
public class MazeApp {
    public static void main(String[] args) {
        HardCodedMaze hardCodedMaze = new HardCodedMaze(5, 5);
        hardCodedMaze.generate(hardCodedMaze.maze[0][0]);
        hardCodedMaze.display();
    }
}
