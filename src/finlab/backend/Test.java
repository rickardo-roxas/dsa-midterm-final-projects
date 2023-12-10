package finlab.backend;

import java.io.File;
import java.util.*;

public class Test {
    private static final GraphUtility graphUtility = new GraphUtility();
    public static void main(String[] args) {
        try {
            graphUtility.readFile(new File("graphs/undirected-test"));
            System.out.println("V={" + graphUtility.getGraph().getNodes().toString() + "}");
            System.out.println("E={" + graphUtility.getGraph().getEdges().toString() + "}");

            System.out.println(graphUtility.breadthFirstSearch(graphUtility.getGraph().getNodes().get(1)));

            System.out.println("Depth-First Search: ");
            ArrayList<Vertex> visited = new ArrayList<>();
            graphUtility.depthFirstSearch(graphUtility.getGraph().getNodes().get(0), visited);
            System.out.println(visited);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
