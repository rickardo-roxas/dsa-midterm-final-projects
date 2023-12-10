package finlab.backend;

import java.io.File;
import java.util.*;

public class Test {
    private static final GraphUtility graphUtility = new GraphUtility();
    public static void main(String[] args) {
        try {
            graphUtility.readFile(new File("graphs/weighted-directed-matrix"));
            System.out.println("V={" + graphUtility.getGraph().getNodes().toString() + "}");
            System.out.println("E={" + graphUtility.getGraph().getEdges().toString() + "}");

            System.out.println(graphUtility.breadthFirstSearch(graphUtility.getGraph().getNodes().get(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
