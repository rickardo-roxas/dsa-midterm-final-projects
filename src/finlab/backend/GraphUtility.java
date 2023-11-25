package finlab.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class GraphUtility {

    public void loadFile(File file) throws Exception {
        BufferedReader inputStream;
        String line = "";

        try {
            inputStream = new BufferedReader(new FileReader(file));

            while ((line = inputStream.readLine()) != null) {

            }
        } catch (Exception e) {
            throw new Exception();
        } // end of try-catch
    } // end of loadFile method

    private void populateUndirectedGraph(String[] vertices, String[] edges) {
        Graph undirectedGraph = new Graph();
        String token = "";

        for (int x = 0; x < vertices.length; x++) {
            undirectedGraph.addNode(new Node(vertices[x]));
        }

        for (int x = 0; x < edges.length; x++) {
            edges = token.split("[(),]+");
            new Edge();
        }


    }

    private void populateDirectedGraph(int[][] adjacencyMatrix) {

    }
}
