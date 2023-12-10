package finlab.backend;

import java.io.File;
import java.util.*;

public class Test {
    private static final GraphUtility graphUtility = new GraphUtility();
    public static void main(String[] args) {
        try {
            graphUtility.readFile(new File("graphs/weighted-undirected-matrix"));
            System.out.println("V={" + graphUtility.getGraph().getNodes().toString() + "}");
            System.out.println("E={" + graphUtility.getGraph().getEdges().toString() + "}");

            Vertex node = graphUtility.getGraph().getNodes().get(0);
            System.out.println("NODE: " + node);
           // graphUtility.dijkstraShortestPath(1);

            /*System.out.println(
                    Arrays.toString(
                            graphUtility.dijkstraShortestPath(node)
                    )
            );

             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
