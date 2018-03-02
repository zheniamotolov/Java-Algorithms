package EulerCycle;

import java.util.LinkedList;

/**
 * Created by eugene on 11/12/17.
 */
public class Graph {
    private LinkedList[] listOfAdjusments;
    private int maxAmountOfVertexes;
    private StringBuilder eulerCycle;
    int realAmountOfEdges;
    int edgesCounter;
    int lastVisitedVertex;

    Graph(int maxAmountOfVertexes) {
        this.maxAmountOfVertexes = maxAmountOfVertexes;
        listOfAdjusments = new LinkedList[maxAmountOfVertexes];
        for (int i = 0; i < maxAmountOfVertexes; i++) {
            listOfAdjusments[i] = new LinkedList();
        }
        eulerCycle = new StringBuilder();
    }

    public void addEdge(int source, int destination) {
        realAmountOfEdges++;
        listOfAdjusments[source].add(new Vertex(destination));
        listOfAdjusments[destination].add(new Vertex(source));

    }

    public void eulerCycleFinder(int j) {
        for (int i = 0; i < listOfAdjusments[j].size(); i++) {
            Vertex vertex = (Vertex) listOfAdjusments[j].get(i);

            listOfAdjusments[j].remove(i);
            System.out.print(j+"-");
            for (int k = 0; k < listOfAdjusments[vertex.label].size(); k++) {
                Vertex tempVertex = (Vertex) listOfAdjusments[vertex.label].get(k);

                if (tempVertex.label == j) {
                    System.out.print(tempVertex.label);
                    listOfAdjusments[vertex.label].remove(k);
                } else {
                    continue;

                }
            }
            edgesCounter++;
            lastVisitedVertex = vertex.label;
            eulerCycleFinder(vertex.label);
        }
    }

    public boolean checkGraf() {
        eulerCycleFinder(0);
        System.out.println(0);
        if (edgesCounter == realAmountOfEdges && lastVisitedVertex == 0) {
            return true;
        } else {
            return false;
        }
    }


}
