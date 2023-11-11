/**
 * Author: John Rey De Torres
 *
 * This class represents a generic stack data structure.
 * It allows elements of a specified type to be pushed onto and popped from the stack.
 *
 * @param <T> the type of elements stored in the stack
 */

package lectureProject;
import java.util.EmptyStackException;

public class Stack<T> {
    private int capacity;
    private Object[] elements;
    private int top;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.top = -1;
    }

    public void push(T item) {
        if (top < capacity - 1) {
            elements[++top] = item;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            T item = (T) elements[top];
            elements[top] = null;
            top--;
            return item;
        } else {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) elements[top];
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}


