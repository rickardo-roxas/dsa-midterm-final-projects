package finlab.backend;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * GraphUtility class for working with graphs and related algorithms.
 */
public class GraphUtility {

    // Class variable
    private Graph graph;
    private StringBuilder dijkstraData;

    /**
     * Default constructor for class
     */
    public GraphUtility() {
        graph = null;
        dijkstraData = null;
    }

    /**
     * Getter for graph
     * @return graph
     */
    public Graph getGraph() {
        return graph;
    }

    public StringBuilder getDijkstraData() {
        return dijkstraData;
    }

    /**
     * Setter for graph
     * @param graph
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setDijkstraData(StringBuilder dijkstraData) {
        this.dijkstraData = dijkstraData;
    }

    /**
     * Reads the contents of a file into a graph class
     * @param file given file path
     * @throws Exception if error or exception occurs
     */
    public void readFile(File file) throws Exception {
        // Use a try-with-resources block to ensure that the reader is closed automatically.
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            graph = new Graph();
            // Read the contents of the file line by line.
            String line;
            int y = 0;

            while ((line = br.readLine()) != null) {
                // Split each line into a list of tokens and trim trailing whitespace.
                String[] tokens = line.split(",");
                // Create a new Graph object if the graph has not yet been populated.
                if (graph.getCount() == 0) {
                    populateVertices(tokens.length);
                }
                // Add an edge to the graph for each token with a non-zero weight.
                for (int x = 0; x < tokens.length; x++) {
                    int weight = Integer.parseInt(tokens[x].trim());
                    if (weight != 0) {
                        Vertex sourceVertex = graph.getNodes().get(y);
                        Vertex destinationVertex = graph.getNodes().get(x);
                        graph.addEdge(sourceVertex, destinationVertex, weight);
                    }
                }
                y++;
            }
        } catch (Exception e) {
            // If an error occurs, print the stack trace and throw an exception.
            e.printStackTrace();
            throw new Exception("Error reading the file.");
        }
    }



    /**
     * Populates the graph with a number of vertices
     * @param verticesCount given number of nodes
     * @return ArrayList of nodes.
     */
    private void populateVertices(int verticesCount) {
        // If the graph is not null and populated, create a new list of vertices to hold the nodes.
        if (graph != null) {
            List<Vertex> vertices = new ArrayList<>();
            // Set a string label for each vertex.
            String labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char symbol;

            // Iterate through the given number of nodes and create new Vertex objects with unique IDs.
            for (int i = 0; i < verticesCount; i++) {
                symbol = labels.charAt(i);
                Vertex vertex = new Vertex(String.valueOf(symbol));
                vertex.setId(i);  // Assign unique ID to each vertex
                vertices.add(vertex);
                graph.addVertex(vertex);
            }
            // Set the list of vertices as the nodes of the graph.
            graph.setNodes(vertices);
        } else {
            // If no graph exists, create a new graph.
            graph = new Graph();
        }
    }

    /**
     * Performs depth-first search starting from a given vertex.
     * @param start The starting vertex.
     * @param visited List of visited vertices.
     * @return List of vertices visited in depth-first order.
     */
    public ArrayList<Vertex> depthFirstSearch(Vertex start, ArrayList<Vertex> visited) {
        visited.add(start);

        for (Edge edge : graph.getEdges()) {
            if (edge.getStart().equals(start)) {
                Vertex neighbor = edge.getEnd();

                if (!visited.contains(neighbor)) {
                    depthFirstSearch(neighbor, visited);
                }
            }
        }

        return visited;
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

    /**
     * Finds the shortest path using Dijkstra's algorithm.
     * @param graph The graph to search.
     * @param startLabel The label of the starting vertex.
     * @param endLabel The label of the destination vertex.
     * @return List of vertices representing the shortest path.
     */
    public ArrayList<Vertex> dijkstraShortestPath(Graph graph, String startLabel, String endLabel) {
        List<Vertex> nodes =  graph.getNodes();
        Vertex start = null, end = null;
        for (Vertex vertex : nodes) {
            if (vertex.getLabel().equalsIgnoreCase(startLabel)) {
                start = vertex;
            }
            if (vertex.getLabel().equalsIgnoreCase(endLabel)) {
                end = vertex;
            }
        }

        //Will hold the distances
        double[] distance = new double[graph.getNodes().size()];

        //Will hold the previous nodes to get to curr node
        Vertex[] predecessor = new Vertex[graph.getNodes().size()];

        // Will hold all the visited paths
        boolean[] visited = new boolean[graph.getNodes().size()];

        // 1. Initialize distances to all equal infinity
        Arrays.fill(distance, Double.POSITIVE_INFINITY);

        // 2. Set start vertex to 0
        distance[start.getId()] = 0;

        // Use a PriorityQueue to get the minimum distance vertex
        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>();
        pq.add(new VertexDistancePair(start, 0));

        while (!pq.isEmpty()) {
            VertexDistancePair currentPair = pq.poll();
            Vertex currentVertex = currentPair.getVertex();

            if (!visited[currentVertex.getId()]) {
                visited[currentVertex.getId()] = true;

                for (Edge neighbor : currentVertex.getNeighbors()) {
                    int neighborIndex = neighbor.getEnd().getId();

                    if (!visited[neighborIndex]) {
                        double newDistance = distance[currentVertex.getId()] + neighbor.getWeight();
                        if (newDistance < distance[neighborIndex]) {
                            distance[neighborIndex] = newDistance;
                            predecessor[neighborIndex] = currentVertex;
                            pq.add(new VertexDistancePair(neighbor.getEnd(), (int) newDistance));
                        }
                    }
                }
            }
        }
        dijkstraData = new StringBuilder();
        dijkstraData.append("Vertex IDs: " + Arrays.toString(graph.getNodes().stream().map(Vertex::getId).toArray()));
        dijkstraData.append("\n");
        dijkstraData.append("Edge Weights: " + graph.getEdges().stream().map(Edge::getWeight).collect(Collectors.toList()));
        dijkstraData.append("\n");
        dijkstraData.append("Distances: " + Arrays.toString(distance));


        // Construct the shortest path
        ArrayList<Vertex> shortestPath = new ArrayList<>();
        Vertex current = end;
        while (current != null) {
            shortestPath.add(current);
            current = predecessor[current.getId()];
        }

        // Reverse the path to get it from start to end
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}

/**
 * Class to be used in dijkstraShortestPath since it requires a means to store the distance.
 */
class VertexDistancePair implements Comparable<VertexDistancePair> {
    private Vertex vertex;
    private double distance;
    private Vertex predecessor;


    /**
     * Constructs a VertexDistancePair.
     * @param vertex The vertex.
     * @param distance The distance.
     */
    public VertexDistancePair(Vertex vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
        this.predecessor = null;
    }

    // Getter and setter for predecessor
    public Vertex getPredecessor() {
        return predecessor;
    }

    /**
     * Sets the predecessor vertex.
     * @param predecessor The predecessor vertex to set.
     */
    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    // Getter and setter for vertex
    public Vertex getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * Compares two VertexDistancePairs based on distance.
     * @param other The other VertexDistancePair.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(VertexDistancePair other) {
        return Double.compare(this.distance, other.distance);
    }
}
