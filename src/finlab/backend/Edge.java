package finlab.backend;

public class Edge {
    private Node start;
    private Node end;
    private double weight;

    public Edge() {
      start = null;
      end = null;
      weight = 0.0;
    }

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.weight = 0;
    }

    public Edge(Node start, Node end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
