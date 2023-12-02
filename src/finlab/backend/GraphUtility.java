package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * TODO: Documentation
 */
public class GraphUtility {
    Graph graph;

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

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                graph.setNodes(populateVertices(tokens.length));

                for (int x = 0; x < tokens.length; x++) {
                    for (int y = 0; y < tokens.length; y++) {
                        if (!tokens[x].equals("0") && !tokens[y].equals("0")) {
                            graph.addEdge(graph.getNodes().get(x), graph.getNodes().get(y));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            throw new Exception();
        }
    }

    /**
     * TODO: Documentation
     * @param verticesCount given number of nodes
     * @return ArrayList of nodes.
     */
    private List<Vertex> populateVertices(int verticesCount) {
        List<Vertex> vertices = new ArrayList<>();
        String labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char symbol;

        for (int i = 0; i < verticesCount; i++) {
            symbol = labels.charAt(i);
            vertices.add(new Vertex(String.valueOf(symbol)));
        }
        return vertices;
    }


    public void depthFirstSearch(Vertex start, Vertex end) {
        // TODO: write corresponding code here
    }

    public void breadthFirstSearch(Vertex start, Vertex end) {
        // TODO: write corresponding code here
    }

    public void dijkstraShortestPath(Vertex start) {

    }
}
