package BetterPrimAlgorithm;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class BetterPrimAlgorithm {
    int INF = Integer.MAX_VALUE ;
    int vertexesNumber;
    int[][] graph;
    BetterPrimAlgorithm(int[][] graph, int vertexesNumber) {
        this.graph = graph;
        this.vertexesNumber = vertexesNumber;
    }
    int minWeight(int mstEdgeWeight[], Boolean freeVertex[]) {
       
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertexesNumber; v++)
            if (!freeVertex[v] && mstEdgeWeight[v] < min) {
                min = mstEdgeWeight[v];
                min_index = v;
            }

        return min_index;
    }
    void printMST(int createdMST[], int n, int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < vertexesNumber; i++)
            System.out.println(createdMST[i] + " - " + i + "    " +
                    graph[i][createdMST[i]]);
    }
    void primMST() {
        int createdMST[] = new int[vertexesNumber];
        int mstEdgeWeight[] = new int[vertexesNumber];
        Boolean freeVertex[] = new Boolean[vertexesNumber];
        for (int i = 0; i < vertexesNumber; i++) {
            mstEdgeWeight[i] = Integer.MAX_VALUE;
            freeVertex[i] = false;
        }
        mstEdgeWeight[0] = 0;
        createdMST[0] = -1;
        for (int count = 0; count < vertexesNumber - 1; count++) {
            int u = minWeight(mstEdgeWeight, freeVertex);
            freeVertex[u] = true;
            for (int v = 0; v < vertexesNumber; v++)
                if (graph[u][v] != 0 && !freeVertex[v] && graph[u][v] < mstEdgeWeight[v]) {
                    createdMST[v] = u;
                    mstEdgeWeight[v] = graph[u][v];
                }
        }
        printMST(createdMST, vertexesNumber, graph);
    }
}
