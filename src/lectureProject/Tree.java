package lectureProject;

/**
 * Author: Basti Siccuan
 */
class Tree<T> {
    T data;
    Tree<T> left;
    Tree<T> right;

    // Constructor to initialize a Tree node with given data
    public Tree(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Getter method to retrieve the data stored in the tree node
    public T getData() {
        return data;
    }

    // Setter method to set the data in the tree node
    public void setData(T data) {
        this.data = data;
    }

    // Getter method to retrieve the left child of the current tree node
    public Tree<T> getLeft() {
        return left;
    }

    // Setter method to set the left child of the current tree node
    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    // Getter method to retrieve the right child of the current tree node
    public Tree<T> getRight() {
        return right;
    }

    // Setter method to set the right child of the current tree node
    public void setRight(Tree<T> right) {
        this.right = right;
    }
}
