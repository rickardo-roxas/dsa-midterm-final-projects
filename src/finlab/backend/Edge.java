package finlab.backend;

public class Edge {
    private Vertex start;
    private  Vertex end;
    private double weight;
    private int id;

    public Edge() {
        start = null;
        end = null;
        weight = 0.0;
        id = 0;
    }

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.weight = 0.0;
        id = 0;
    }

    public Edge(Vertex start, Vertex end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
