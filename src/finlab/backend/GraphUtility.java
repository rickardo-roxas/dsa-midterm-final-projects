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

    /**
     * Default constructor for class
     */
    public GraphUtility() {
        graph = null;
    }

    /**
     * Getter for graph
     * @return graph
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Setter for graph
     * @param graph
     */
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
        Queue<Vertex> queue = new LinkedList<>(); // Adjacent nodes of current vertex
        ArrayList<Vertex> visited = new ArrayList<>(); // Visited Nodes

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();


            List<Edge> edges = graph.getEdges(); // Get the edges of the current graph

            for (Edge edge : edges){
                if (edge.getStart().equals(curr)){ // If it is a neighbour
                    Vertex neighbor = edge.getEnd(); // Get the adjacent node

                    if (!visited.contains(neighbor) && !queue.contains(neighbor)){
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }

            }

        }

        return visited;
    }



    public void dijkstraShortestPath(Vertex start, Vertex end) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        HashSet<Vertex> visited = new HashSet<>();

        List<Vertex> vertices = graph.getNodes();  // Get the vertices
        List<Edge> edges = graph.getEdges();
        int[] distance = new int[graph.getCount()]; // Will hold all the distances of the vertices
        Arrays.fill(distance, Integer.MAX_VALUE);  // Make the distances infinity


        // Set the weight of start node equal to 0 to signify it is the start ndoe
        for (Edge edge : edges) {
            if (edge.getStart().equals(start)) {
                edge.setWeight(0);
            }
        }

        priorityQueue.add(start);  //Add start to priority queue

        distance[vertices.indexOf(start)] = 0;

        while (visited.size() != priorityQueue.size()) {
            Vertex workingNode = priorityQueue.remove();
            visited.add(workingNode);

            // Get number of nodes adjacent to the working node
            int numberOfAdjacentNodes = 0;
            for (Edge edge : edges)
                if (edge.getStart().equals(start))
                    numberOfAdjacentNodes+=1;

            for (int x = 0 ; x < numberOfAdjacentNodes; x++ ) {

            }

        }



    }

}
