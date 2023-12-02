package finlab.backend;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> nodes;
    private List<Edge> edges;
    private int count;

    public Graph() {
        nodes = new ArrayList<>();
        count = 0;
    }

    public Graph(List<Vertex> nodes, int count) {
        this.nodes = nodes;
        this.count = count;
    }

    public void addVertex(Vertex vertex) {
        if (!nodes.contains(vertex)) {
            this.nodes.add(vertex);
            this.count++;
        }
    }

    public void addEdge(Vertex start, Vertex end) {
        edges.add(new Edge(start, end));
    }

    public void setNodes(List<Vertex> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getCount() {
        return count;
    }

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
