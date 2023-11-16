/**
 * Author: John Rey De Torres
 *
 * This class represents a generic stack data structure.
 * It allows elements of a specified type to be pushed onto and popped from the stack.
 *
 * @param <T> the type of elements stored in the stack
 */
package lectureProject;

public class StackTest {
    public static void main(String[] args) {
        // Demonstrate the usage of the Stack class

        // Create a stack of integers
        Stack<Integer> intStack = new Stack<>();

        // Push some elements onto the stack
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);

        // Display the current size of the stack
        System.out.println("Size of the stack: " + intStack.size());

        // Peek at the top element of the stack
        System.out.println("Top element: " + intStack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + intStack.pop());
        System.out.println("Popped element: " + intStack.pop());

        // Display the current size of the stack
        System.out.println("Size of the stack: " + intStack.size());
    }
}

