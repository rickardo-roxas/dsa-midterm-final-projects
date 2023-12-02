package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;


public class GraphUtility {

    public Graph readFile(File file) throws Exception {
        BufferedReader br;
        Graph graph;

        try {
            br = new BufferedReader(new FileReader(file));
            graph = new Graph();

            String line;
            int row = 0;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                List<Vertex> vertices = populateVertices(tokens.length);

                for (int column = 0; column < tokens.length; column++) {
                    int value = Integer.parseInt(tokens[column]);
                    if (value == 1) {
                        graph.addVertex(vertices.get(row));
                        graph.addVertex(vertices.get(column));
                        // Add an undirected edge between vertices
                        graph.addEdge(vertices.get(row), vertices.get(column));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            throw new Exception();
        }
        return graph;
    }

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

    public void depthFirstSearch() {
        // TODO: write corresponding code here
    }

    public void breadthFirstSearch() {
        // TODO: write corresponding code here
    }
}
