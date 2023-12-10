package finlab.backend;

/**
 * Edge Class
 */
public class Edge {

    // Class Variables
    private Vertex start;
    private  Vertex end;
    private int weight;
    private int id;

    /**
     * Default Constructor
     */
    public Edge() {
        start = null;
        end = null;
        weight = 0;
        id = 0;
    }

    /**
     * Constructor for edge without weight
     * @param start : vertex
     * @param end : vertex
     */
    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.weight = 0;
        id = 0;
    }

    /**
     * Constructor for edge with weight
     * @param start
     * @param end
     * @param weight
     */
    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**
     * Setter for start vertex
     * @param start : Vertex
     */
    public void setStart(Vertex start) {
        this.start = start;
    }

    /**
     * Setter for end vertex
     * @param end : Vertex
     */
    public void setEnd(Vertex end) {
        this.end = end;
    }

    /**
     * Setter for weight of edge
     * @param weight : double
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Setter for ID
     * @param id : id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for start
     * @return : Vertex
     */
    public Vertex getStart() {
        return start;
    }

    /**
     * Getter for end
     * @return : Vertex
     */
    public Vertex getEnd() {
        return end;
    }

    /**
     * Getter for weight
     * @return : weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Getter for id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * toString method
     * @return string representation
     */
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
