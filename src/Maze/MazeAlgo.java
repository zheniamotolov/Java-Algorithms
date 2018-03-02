//package Maze;
//
///**
// * Created by eugene on 11/13/17.
// */
//public class MazeAlgo {
//    Cell[][] maze;
//    int height;
//    int width;
//    private java.util.Random rand = new java.util.Random();
//
//    public MazeAlgo(int height, int width) {
//        this.height = height;
//        this.width = width;
//        maze = new Cell[height][width];
//        initialize();
//    }
//
//    void initialize() {
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                maze[i][j] = new Cell(0, 0, 0, 0);
//            }
//        }
//    }
//
//    void generate() {
//        generateFirstRow();
//        int temp = 0;
//        for (int i = 1; i < height - 1; i++) {
//            for (int j = 0; j < width; j++) {
//                if (j == 0) {
//                    temp = rand.nextInt(2);
//                    if (temp == 0) {
//                        maze[i][j].right = 0;
//                        maze[i][j + 1].lefft = 0;
//                    }
//                    maze[i][j].right = 1;
//                    maze[i][j + 1].lefft = 1;
//                } else if (j == width - 1) {
//                    continue;// = new Cell(0, 0, 0, 1);
//                } else {
//                    temp = rand.nextInt(2);
//                    if (temp == 0) {
//                        maze[i][j].right = 0;
//                        maze[i][j + 1].lefft = 0;
//                    } else {
//                        maze[i][j].right = 1;
//                        maze[i][j + 1].lefft = 1;
//                    }
//                }
//            }
//            generateDownborder(i);
//        }
//        //  generateLastRow();
//    }
//
//    void generateFirstRow() {
//        for (int j = 0; j < width; j++) {
//            if (j == 0) {
//                maze[0][j].right = 1;
//                // = new Cell(0, 1, 0, 0);
//            }
//            if (j == width - 1) {
//                maze[0][j].lefft = 1; //= new Cell(0, 0, 0, 1);
//            }
//            maze[0][j].right = rand.nextInt(2);
//            maze[0][j].lefft = 1;//= new Cell(0, rand.nextInt(2), 0, 1);
//        }
//    }
//
//    //rand.nextInt((max - min) + 1) + min
//    void generateDownborder(int i) {
//        int counter = 0;
//        for (int j = 1; j < width - 1; j++) {
//            if (maze[i][j].right != 1) {
//                maze[i][rand.nextInt((j - (j - counter)) + 1) + (j - counter)].down = 1;
//                counter = 0;
//            } else {
//                counter++;
//            }
//        }
//    }
//
//    void print() {
//        for (int i = 1; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (maze[i][j].up == 0) {
//                    System.out.print("[][][]");
//                }
//            }
//            System.out.println();
//            for (int j = 0; j < width; j++) {
//                if (maze[i][j].lefft == 0 && maze[i][j].right == 0) {
//                    System.out.print("[] []");
//                } else if (maze[i][j].lefft == 0 && maze[i][j].right == 1) {
//                    System.out.print("[]   ");
//                } else if (maze[i][j].lefft == 1 && maze[i][j].right == 0) {
//                    System.out.print("   []");
//                }
//            }
//            System.out.println();
//            for (int j = 0; j < width; j++) {
//                if (maze[i][j].down == 0) {
//                    System.out.print("[][][]");
//                }
//                else{
//                    System.out.print("      ");
//                }
//
//
//            }
//            System.out.println();
//
//
//        }
//    }
//
//}
