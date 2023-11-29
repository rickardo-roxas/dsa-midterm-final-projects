package lecture_project;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> bankLine = new Queue<String>();
        bankLine.enqueue("Karl Jasper");
        bankLine.peek();
        bankLine.enqueue("Rithik");
        bankLine.enqueue("Patrick");
        bankLine.enqueue("Johan");
        bankLine.enqueue("Ramon");
        System.out.println(bankLine.peek());
        bankLine.dequeue();
        System.out.println(bankLine.peek());
        bankLine.dequeue();
        System.out.println(bankLine.peek());



    }
}
