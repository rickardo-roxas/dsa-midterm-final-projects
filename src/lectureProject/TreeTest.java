package lectureProject;
public class TreeTest {

    /**
     * Main method to test the Tree class functionality.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(5);
        root.setLeft(new Tree<>(2));
        root.setRight(new Tree<>(6));
        root.getLeft().setLeft(new Tree<>(8));
        root.getLeft().setRight(new Tree<>(1));

        System.out.println("Tree Structure:");
        displayTree(root, 0);

        System.out.println("\nTree Data:");
        printTreeData(root);
    }

    /**
     * A method to display the tree structure using recursion.
     *
     * @param node  The current tree node being processed.
     * @param level The level of the current tree node in the tree structure.
     */
    private static void displayTree(Tree<?> node, int level) {
        if (node != null) {
            displayTree(node.getRight(), level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.getData());
            displayTree(node.getLeft(), level + 1);
        }
    }

    /**
     * A method to print data from the tree nodes using recursion.
     *
     * @param node The current tree node being processed.
     */
    private static void printTreeData(Tree<?> node) {
        if (node != null) {
            printTreeData(node.getLeft());
            System.out.print(node.getData() + " ");
            printTreeData(node.getRight());
        }
    }
}