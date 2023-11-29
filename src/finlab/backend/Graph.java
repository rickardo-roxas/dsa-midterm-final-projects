package finlab.backend;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> nodes;
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
        this.nodes.add(vertex);
        this.count++;
    }

    public void setNodes(List<Vertex> nodes) {
        this.nodes = nodes;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : this.nodes) {
            sb.append(vertex + "\n");
        }
        return String.valueOf(sb);
    }
}
