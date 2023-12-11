package finlab.backend;

import java.io.File;
import java.util.*;


public class Test {
    public static void main(String[] args) {
        // Instantiate GraphUtility and read graph from file
        GraphUtility graphUtility = new GraphUtility();
        try {
            File file = new File("graphs/weighted-directed-matrix");  // Replace with your file path
            graphUtility.readFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Get the graph from GraphUtility
        Graph graph = graphUtility.getGraph();

        // Choose a source vertex (you can change this as needed)
        Vertex source = graph.getNodes().get(0);

        // Dijkstra's algorithm
        ArrayList<Vertex> distance = graphUtility.dijkstraShortestPath(graph, graph.getNodes().get(0), graph.getNodes().get(4));

        // Printing results
            System.out.print("Shortest Path: " + distance + ", ");

    }
}
