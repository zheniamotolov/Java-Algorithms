package KruscalAlgorithm;

/**
 * Created by eugene on 12/19/17.
 */

// A class to represent a graph edge
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Comparator function used for sorting edges
    // based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};