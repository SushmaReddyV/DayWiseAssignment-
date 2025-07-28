import java.util.*;

public class ToDoListManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        tasks.add("Buy groceries");
        tasks.add("Read a book");
        tasks.add("Pay bills");

        System.out.println("Mark 'Read a book' as done.");
        tasks.remove("Read a book");

        System.out.println("Pending Tasks:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }
}
