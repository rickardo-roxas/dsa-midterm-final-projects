package lectureProject;

/**
 * Author: Basti Siccuan
 */
class Tree<T> {
    T data;
    Tree<T> left;
    Tree<T> right;
    public Tree(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
