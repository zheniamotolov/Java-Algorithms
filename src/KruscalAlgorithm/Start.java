package KruscalAlgorithm;

import BetterPrimAlgorithm.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by eugene on 12/18/17.
 */
public class Start {
    final static String path = "src/KruscalAlgorithm/data1.txt";


    public static void main(String[] args) {

        int V = 5;  // Number of vertices in graph
        int E = 7;  // Number of edges in graph
        KruscalAlgorithm graph = new KruscalAlgorithm(V, E);
//        int i = 0,e=0,weight=0;
//        try (FileReader fileReader = new FileReader(path); Scanner input = new Scanner(fileReader)) {
//            while (input.hasNextLine()) {
//                for (int j = i; j < V; j++) {
//                    weight=input.nextInt();
//                    if (weight!= 0) {
//                        graph.edges[e].src = i;
//                        graph.edges[e].dest = j;
//                        graph.edges[e].weight =weight ;
//                        e++;
//                    }
//                }
//                i++;
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 2;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 3;
        graph.edges[1].weight = 6;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 8;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 4;
        graph.edges[3].weight = 5;

        graph.edges[4].src = 1;
        graph.edges[4].dest = 2;
        graph.edges[4].weight = 3;

        graph.edges[5].src = 2;
        graph.edges[5].dest = 4;
        graph.edges[5].weight = 7;

        graph.edges[6].src = 3;
        graph.edges[6].dest = 4;
        graph.edges[6].weight = 9;
        graph.KruskalMST();
    }
}
