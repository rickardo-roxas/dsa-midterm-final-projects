package finlab.backend;

import java.util.List;
import java.util.ArrayList;

public class Graph {
    private List<Node> nodes = new ArrayList<>();
    private int count;

    public Graph() {
        nodes = null;
        count = 0;
    }

    public Graph(List<Node> nodes, int count) {
        this.nodes = nodes;
        this.count = count;
    }

    public void addNode(Node node) {
        nodes.add(node);
        count++;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int getCount() {
        return count;
    }
}
