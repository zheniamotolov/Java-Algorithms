package BFS;

/**
 * Created by eugene on 10/24/17.
 */
public class Vertex {
    public char getLabel() {
        return label;
    }

    private char label;

    public boolean isVisited() {
        return isVisited;
    }

    private boolean isVisited;


    public void setVisited(boolean visited) {
        isVisited = visited;
    }


    Vertex(char label){
        isVisited=false;
        this.label=label;
    }

}
