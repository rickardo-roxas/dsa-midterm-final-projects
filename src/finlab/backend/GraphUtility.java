package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;


public class GraphUtility {

    public Graph readFile(File file) throws Exception {
        BufferedReader br;
        Graph graph;
        String line = "";
        String[] tokens;
        try {
            br = new BufferedReader(new FileReader(file));
            graph = new Graph();
            while ((line = br.readLine()) != null) {
                tokens = line.split(",");
                for (int x = 0; x < tokens.length; x++) {
                    graph.addVertex();
                }
            }
        } catch (Exception e) {
            throw new Exception();
        }
        return graph;
    }

    private List<Vertex> populateVertices(int x)
    {

    }
    public void depthFirstSearch() {
        // TODO: write corresponding code here
    }

    public void breadthFirstSearch() {
        // TODO: write corresponding code here
    }
}
