package BetterPrimAlgorithm;


/**
 * Created by eugene on 12/12/17.
 */
public class Start {
    final static String path = "src/BetterPrimAlgorithm/data.txt";
    final static int N = 6;
    static int graph[][];

    public static void main(String[] args) {
        graph = new int[N][N];
        Reader reader = new Reader();
        graph = reader.readFromfile(path, N);
        BetterPrimAlgorithm betterPrimAlgorithm = new BetterPrimAlgorithm(graph, N);
        betterPrimAlgorithm.primMST();
       //betterPrimAlgorithm.printMST();
    }

}
