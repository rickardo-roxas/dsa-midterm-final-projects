package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;


public class GraphUtility {

    public Graph readFile(File file) throws Exception {
        BufferedReader br;
        Graph graph;
        String line;
        String[] tokens;

        try {
            br = new BufferedReader(new FileReader(file));
            graph = new Graph();
            while ((line = br.readLine()) != null) {
                tokens = line.split(",");
                List<Vertex> vertices = populateVertices(tokens.length);
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
