package BFS;

/**
 * Created by eugene on 10/24/17.
 */
public class BFSApp {
    public static void main(String[] args) {
        BFS bfs = new BFS(6);
        bfs.addVertex('A');
        bfs.addVertex('B');
        bfs.addVertex('C');
        bfs.addVertex('D');
        bfs.addVertex('E');
        bfs.addVertex('L');
        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(0, 3);
        bfs.addEdge(3, 1);
        System.out.print("Visits: ");
        bfs.bfs();             // Обход в ширину
        System.out.println();
    }

}
