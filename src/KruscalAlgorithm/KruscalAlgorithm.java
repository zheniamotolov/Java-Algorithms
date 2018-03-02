package KruscalAlgorithm;

import java.util.Arrays;

/**
 * Created by eugene on 12/18/17.
 */
public class KruscalAlgorithm {
    int V, E;
    Edge edges[];
    Vertex vertex[];
    KruscalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        vertex = new Vertex[v];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
        for (int i = 0; i < v; ++i)
            vertex[i] = new Vertex();
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0,i=0;

        for (i = 0; i < V; ++i)
            result[i] = new Edge();
        Arrays.sort(edges);
        i = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edges[i++];
            if (!vertex[edges[i - 1].dest].used || !vertex[edges[i - 1].src].used) {
                vertex[edges[i - 1].src].used = true;
                vertex[edges[i - 1].dest].used = true;
                result[e++] = next_edge;
            } else {
                continue;
            }
            System.out.println("Edge   Weight");
            for (i = 0; i < e; ++i)
                System.out.println(result[i].src + " - " +
                        result[i].dest + " " + result[i].weight);
        }
    }
}
