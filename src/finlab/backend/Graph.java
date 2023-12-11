package finlab.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph Class
 */
public class Graph {

    //Class variables
    private List<Vertex> nodes; // nodes are a list of vertices
    private List<Edge> edges;
    private int count;

    /**
     * Default Constructor
     */
    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        count = 0;
    }

    /**
     * Constructor
     * @param nodes : List<Vertex
     * @param count : int
     */
    public Graph(List<Vertex> nodes, int count) {
        this.nodes = nodes;
        this.count = count;
    }

    /**
     * Method to add a vertex
     * @param vertex : Vertex
     */
    public void addVertex(Vertex vertex) {
        if (!nodes.contains(vertex)) {
            this.nodes.add(vertex);
            this.count++;
        }
    }

    /**
     * Method to add edge
     * @param start : Vertex
     * @param end : Vertex
     */
    public void addEdge(Vertex start, Vertex end) {
        edges.add(new Edge(start, end));
    }

    public void addEdge(Vertex start, Vertex end, int weight) {
        Edge edge = new Edge(start, end, weight);
        edges.add(edge);
        start.addEdge(edge);
    }

    /**
     * Setter to set nodes
     * @param nodes : List<Vertex
     */
    public void setNodes(List<Vertex> nodes) {
        this.nodes = nodes;
    }

    /**
     * Setter to set edges
     * @param edges : List<Edge
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Setter to set count
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Getter to get nodes
     * @return
     */
    public List<Vertex> getNodes() {
        return nodes;
    }

    /**
     * Getter to get edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Getter for count
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * toString method
     * @return string representation
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("V={");
        for (Vertex vertex : this.nodes) {
            sb.append(vertex + ",");
        }
        sb.append("}\n");

        sb.append("E={");
        for (Edge edge : this.edges) {
            sb.append(edge + ",");
        }
        sb.append("}");
        return sb.toString();
    }
}
