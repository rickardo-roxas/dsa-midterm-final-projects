/**
 * Author: John Rey De Torres
 *
 * This class represents a generic stack data structure.
 * It allows elements of a specified type to be pushed onto and popped from the stack.
 *
 * @param <T> the type of elements stored in the stack
 */

package lectureProject;
import Project1.backend.stack.Node;

import java.util.EmptyStackException;

public class Stack<T> {
    private int count;
    private Node<T> top;

    public Stack() {
        count = 0;
        this.top = null;
    }

    public void push(T item) {
        Project1.backend.stack.Node<T> node = new Node<>(item);
        if (!isEmpty())
            node.setNext(top);

        top = node;
        count++;
    }

    public T pop() {
        T topElement = null;
        if (!isEmpty()) {
            topElement = top.getData();
            if (count == 1)
                top = null;
            else
                top = top.getNext();
            count--;
        } // end of if
        return topElement;
    }

    public T peek() {
        if (!isEmpty()) {
            return top.getData(); // returns if stack and top is not null
        } // end of if-else (isEmpty)
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.count;
    }
}


