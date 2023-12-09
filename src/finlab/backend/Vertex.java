package finlab.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertex class
 */
public class Vertex {
    //Class variables
    private String label;
    private List<Edge> neighbors;

    /**
     * Default Constructor
     */
    public Vertex() {
        label = "";
        neighbors = null;
    }

    /**
     * Constructor
     * @param label : String
     */
    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    /**
     * Constructor where there is a list of neighbors
     * @param label : String
     * @param neighbors : List<Edge
     */
    public Vertex(String label, List<Edge> neighbors) {
        this.label = label;
        this.neighbors = neighbors;
    }

    /**
     * Setter for Label
     * @param label : String
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Setter for neghbors
     * @param neighbors : List<Edge>
     */
    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }

    /**
     * Getter for label
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Getter for neighbors
     * @return neighbors
     */
    public List<Edge> getNeighbors() {
        return neighbors;
    }

    /**
     * toString method
     * @return string representation
     */
    public String toString() {
        return label;
    }

    /**
     * Equal method
     * @param obj : Object
     * @return boolean comparison value
     */
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
