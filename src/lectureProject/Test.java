package lectureProject;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack size: " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }

        System.out.println("Stack size after popping all elements: " + stack.size());
    }

}
