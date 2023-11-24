package finlab.backend;

public class Edge {
    private Node start;
    private Node end;
    private double weight;
    private String label;

    public Edge() {
      start = null;
      end = null;
      weight = 0.0;
      label = null;
    }

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.weight = 0;
        this.label = "";
    }

    public Edge(Node start, Node end, String label) {
        this.start = start;
        this.end = end;
        this.weight = 0;
        this.label = label;
    }

    public Edge(Node start, Node end, double weight, String label) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.label = label;
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

    public void setLabel(String label) {
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
