import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        printQueue.offer("Document1");
        printQueue.offer("Document2");
        printQueue.offer("Document3");

        while (!printQueue.isEmpty()) {
            System.out.println("Printing: " + printQueue.poll());
        }
    }
}
