package AlgorithmPrima;

/**
 * Created by eugene on 11/28/17.
 */
public class Runner {
    public static void main(String[] args) {
        AlgorithmPrima algorithmPrima = new AlgorithmPrima();
        algorithmPrima.addNewEdge(0, 1, 7);
        algorithmPrima.addNewEdge(1, 2, 8);
        algorithmPrima.addNewEdge(1, 3, 9);
        algorithmPrima.addNewEdge(1, 4, 15);
        algorithmPrima.addNewEdge(1, 5, 8);
        algorithmPrima.addNewEdge(2, 4, 7);
        algorithmPrima.addNewEdge(2, 3, 8);

        algorithmPrima.addNewEdge(3, 4, 5);

        algorithmPrima.addNewEdge(4, 6, 9);

        algorithmPrima.addNewEdge(4, 5, 8);

        algorithmPrima.addNewEdge(5, 6, 11);
        algorithmPrima.algorithmByPrim();
        algorithmPrima.show();

    }
}
