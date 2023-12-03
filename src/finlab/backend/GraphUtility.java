package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * TODO: Documentation
 */
public class GraphUtility {
    private Graph graph;

    public GraphUtility() {
        graph = null;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * TODO: Documentation
     * @param file given file path
     * @throws Exception if error or exception occurs
     */
    public void readFile(File file) throws Exception {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            graph = new Graph();
            String line;
            int y = 0;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                populateVertices(tokens.length);

                for (int x = 0; x < tokens.length; x++) {
                    if (!tokens[x].equals("0")) {
                        graph.addEdge(graph.getNodes().get(y), graph.getNodes().get(x));
                    }
                }
                y++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            throw new Exception();
        }
    }

    public int[][] getAdjacencyMatrix() {
        int numVertices = graph.getCount();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];
        for (Edge edge : graph.getEdges()) {
            int startIndex = graph.getNodes().indexOf(edge.getStart());
            int endIndex = graph.getNodes().indexOf(edge.getEnd());
            adjacencyMatrix[startIndex][endIndex] = edge.getWeight() > 0 ? (int) edge.getWeight() : 1;
        }
        return adjacencyMatrix;
    }


    /**
     * TODO: Documentation
     * @param verticesCount given number of nodes
     * @return ArrayList of nodes.
     */
    private void populateVertices(int verticesCount) {
        if (graph != null) {
            List<Vertex> vertices = new ArrayList<>();
            String labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char symbol;

            for (int i = 0; i < verticesCount; i++) {
                symbol = labels.charAt(i);
                Vertex vertex = new Vertex(String.valueOf(symbol));
                vertices.add(vertex);
                graph.addVertex(vertex);
            }
            graph.setNodes(vertices);
        } else {
            graph = new Graph();
        }
    }

    public void depthFirstSearch(Vertex start) {
        // TODO: write corresponding code here
    }

    public void breadthFirstSearch(Vertex start) {
        // TODO: write corresponding code here
    }

    public void dijkstraShortestPath(Vertex start, Vertex end) {

    }
}
