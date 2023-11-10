package lectureProject;
import Project1.backend.stack.Node;

/**
 * Author: Karl Jasper Urbiztondo
 */
public class Queue<T> {
    int size;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = tail = new Node<>(null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T firstElement() {
        if (!isEmpty() && head.getNext() != null)
            return head.getNext().getData();
        else return null;
    }

    public T lastElement() {
        if (!isEmpty())
            return tail.getData();
        else return null;
    }
}