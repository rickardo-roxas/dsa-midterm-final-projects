package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * GraphUtility class
 */
public class GraphUtility {

    // Class variable
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

    /**
     * The following code returns the Breadth-First Search traversal (ArrayList) of a graph given a starting node.
     * @param start
     * @return
     */
    public ArrayList<Vertex> breadthFirstSearch(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        ArrayList<Vertex> visited = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();


            List<Edge> edges = graph.getEdges();

            for (Edge edge : edges){
                if (edge.getStart().equals(curr)){
                    Vertex neighbor = edge.getEnd();

                    if (!visited.contains(neighbor) && !queue.contains(neighbor)){
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }

            }

        }

        return visited;
    }



    public ArrayList<Vertex> dijkstraShortestPath(Vertex start, Vertex end) {

    }
}
