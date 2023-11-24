package finlab.backend;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String label;
    private List<Edge> adjacencyList = new ArrayList<>();

    public Node() {
        label = "";
        adjacencyList = null;
    }

    public Node(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAdjacencyList(List<Edge> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public String getLabel() {
        return label;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public String toString() {
        return label;
    }
}
