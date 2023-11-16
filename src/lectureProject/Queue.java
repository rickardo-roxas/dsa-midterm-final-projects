package lectureProject;
import Project1.backend.stack.Node;

/**
 * Author: Karl Jasper Urbiztondo
 */
public class Queue<T> {
    int size;
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        front = rear = new Node<>(null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (!isEmpty())
            return front.getData();
        return null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear.getData() == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            if (size==1) {
                front.setNext(newNode);
            }
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;

    }

    public void dequeue() {
        if (!isEmpty()) {
            Node<T> newFront = front.getNext();
            front.setNext(null);
            front = newFront;
        }
    }

    public T front() {
        if (!isEmpty()) {
            return front.getData();
        }
        return null;
    }


}