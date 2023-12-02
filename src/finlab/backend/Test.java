package finlab.backend;

import java.io.File;

public class Test {
    private static final GraphUtility graphUtility = new GraphUtility();
    public static void main(String[] args) {
        try {
            Graph graph = graphUtility.readFile(new File("graphs/matrix"));
            System.out.println(graph.getNodes().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
