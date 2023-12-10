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


    static int totalNumberOfVertex = 9;

    int minimumDistance(int[] distance, Boolean[] shortestPathSet) {
        int maxValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int x = 0; x < totalNumberOfVertex; x++) {

            // If path has not been finalized set the minIndex to x
            if (!shortestPathSet[x] && distance[x] <= maxValue) {
                maxValue = distance[x];
                minIndex = x;
            }
        }
        return minIndex;

    }

    void dijkstra(int[][] graph, int startVertex) {

        int[] distance = new int[totalNumberOfVertex];

        // Will be setting this to true while we finalize the shortest path to each node
        Boolean[] shortestPathSet = new Boolean[totalNumberOfVertex];


        // Set all distances to infinity
        // Set all the shortestPathSets to false
        for (int x = 0; x < totalNumberOfVertex; x++) {
            distance[x] = Integer.MAX_VALUE;
            shortestPathSet[x] = false;
        }

        // Set the distance from the source vertex to itself to 0
        distance[startVertex] = 0;


        for (int x = 0; x < totalNumberOfVertex - 1; x++)  {

            // Call minimumDistance to get the shortest path set for for the vertex
            int minDistance = minimumDistance(distance, shortestPathSet);

            // Set shortestPathSet to true
            shortestPathSet[minDistance] = true;

            //Update distance of neighbor vertices
            for (int vertex = 0; vertex < totalNumberOfVertex; vertex++)

                if (!shortestPathSet[vertex] && //Vertex has not been finalized in shortestPathSet
                        graph[minDistance][vertex] != -1 &&  // An edge exists between the two values
                        distance[minDistance] != Integer.MAX_VALUE && //the distance not equal infinity
                        distance[minDistance] + graph[minDistance][vertex] < distance[vertex]) { // new path distance less than old path distance
                    distance[vertex] = distance[minDistance] + graph[minDistance][vertex]; //set new distance
                }
        }
        printShortestPath(distance, totalNumberOfVertex);
    }

    void printShortestPath(int distance[], int n) {
        System.out.println("The shortest Distance from source 0th node to all other nodes are: ");
        for (int j = 0; j < n; j++)
            System.out.println("To " + j + " the shortest distance is: " + distance[j]);
    }

    // main method
    public static void main(String args[]) {
        int[][] graph = new int[][] {
                { -1, 3, -1, -1, -1, -1, -1, 7, -1 },
                { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
                { -1, 7, -1, 6, -1, 2, -1, -1, 1 },
                { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
                { -1, -1, -1, 8, -1, 9, -1, -1, -1 },
                { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
                { -1, -1, -1, -1, -1, 4, -1, 2, 5 },
                { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
                { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };

        GraphUtility obj = new GraphUtility();
        obj.dijkstra(graph, 0);
    }

}
