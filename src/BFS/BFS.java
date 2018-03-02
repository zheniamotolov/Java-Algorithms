package BFS;

/**
 * Created by eugene on 10/24/17.
 */
public class BFS {
    private  int amountOfVerteses;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][];
    private int nVerts;
    private Queue theQueue;

    public BFS(int amountOfVerteses) {
        this.amountOfVerteses=amountOfVerteses;
        vertexList = new Vertex[amountOfVerteses];
        // Матрица смежности
        adjMat = new int[amountOfVerteses][amountOfVerteses];
        nVerts = 0;
        for (int j = 0; j < amountOfVerteses; j++)
            for (int k = 0; k < amountOfVerteses; k++)
                adjMat[j][k] = 0;
        theQueue = new Queue();
// Матрица смежности
// заполняется нулями
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }


    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public void bfs()
    {
        vertexList[0].setVisited(true);
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setVisited(true);
                displayVertex(v2);
                theQueue.insert(v2);
            }

        }
        checkConnectvivty();
        for (int j = 0; j < nVerts; j++)
            vertexList[j].setVisited(false);
    }

    public void checkConnectvivty() {
//        for (Vertex vertex : vertexList) {
//            if (!vertex.isVisited()) {
//                System.out.println("\n this vertex not connected to others " + vertex.getLabel() + "\n");
//            }
//        }
        for (int i=0;i<vertexList.length;i++) {
            if (!vertexList[i].isVisited()) {
                System.out.println("\n this vertex not connected to others " + vertexList[i].getLabel());
            }
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].isVisited()) {
                return j;
            }            // Возвращает первую найденную вершину
        }          // Таких вершин нет
        return -1;
    }

}