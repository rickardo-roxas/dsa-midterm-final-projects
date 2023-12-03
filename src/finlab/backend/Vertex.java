package finlab.backend;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String label;
    private List<Edge> neighbors;

    public Vertex() {
        label = "";
        neighbors = null;
    }

    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    public Vertex(String label, List<Edge> neighbors) {
        this.label = label;
        this.neighbors = neighbors;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }

    public String getLabel() {
        return label;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public String toString() {
        return label;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vertex otherVertex = (Vertex) obj;
        return label.equals(otherVertex.label);
    }

}
