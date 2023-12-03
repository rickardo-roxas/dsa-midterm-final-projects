package finlab.backend;

import java.io.File;
import java.util.*;

public class Test {
    private static final GraphUtility graphUtility = new GraphUtility();
    public static void main(String[] args) {
        try {
            graphUtility.readFile(new File("graphs/unweighted-undirected-matrix"));
            System.out.println("V={" + graphUtility.getGraph().getNodes().toString() + "}");
            System.out.println("E={" + graphUtility.getGraph().getEdges().toString() + "}");

            System.out.println(graphUtility.getGraph().getNodes().get(0));

            System.out.println(graphUtility.getGraph().getNodes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
