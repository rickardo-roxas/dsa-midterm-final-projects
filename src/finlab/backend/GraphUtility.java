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


    public static void main(String[] args) {
        int adjMat [] [] = {
                {0, 2, 0, 4, 0, 0},
                {0, 0, 3, 2, 0, 0},
                {2, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};

        //creating a distance array to keep a note of distance of vertex from source
        int [] distance = new int[adjMat.length];

        //taking source vertex to be 0
        int source = 0;

        //creating a visited array to keep a count of visited vertices.
        boolean [] visited = new boolean[adjMat.length];

        //marking distance of source vertex
        distance[source] = 0;

        // filling up other distance in array "distance" as infinity or the max value
        for (int i = 0; i < adjMat.length; i++) {
            if( i == source) continue;
            distance[i] = Integer.MAX_VALUE;
        }

        //finding the vertex that is most close to current node or source
        for(int i = 0; i < adjMat.length; i++) {
            int minDistVertex = findMinDistVertex(distance, visited);

            //marking the vertex that is most close to source/current vertex as true
            visited[minDistVertex] = true;

            //exploring the neighbors of each vertex and updating distance array with new distance
            for(int j = 0; j < adjMat.length; j++) {
                if(adjMat[minDistVertex][j] != 0 && visited[j] == false && distance[minDistVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minDistVertex] + adjMat[minDistVertex][j];
                    if(newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }

        for(int i = 0; i < adjMat.length; i++) {
            System.out.println("Vertex : " + i + " & Distance from Source : " +distance[i]);
        }

        for (int distance1 : distance) {
            System.out.println(distance1);
        }
    }

    public static int findMinDistVertex(int[] distance, boolean [] visited) {

        int minVertex = -1;

        //traversing through the distance array and finding the least distance vertex whose visited is also false
        for(int i = 0; i < distance.length; i++) {
            if(visited[i] == false && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

}
