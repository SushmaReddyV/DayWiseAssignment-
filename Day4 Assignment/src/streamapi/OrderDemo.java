package streamapi;
import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    String category;
    double amount;

    Order(String customer, String category, double amount) {
        this.customer = customer;
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return customer + " - " + category + ": " + amount;
    }
}

public class OrderDemo {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", "Books", 250),
            new Order("Bob", "Electronics", 500),
            new Order("Alice", "Books", 150),
            new Order("Bob", "Clothes", 200)
        );

        System.out.println("Orders > 200:");
        orders.stream().filter(o -> o.amount > 200).forEach(System.out::println);

        System.out.println("\nTotal orders per customer:");
        Map<String, Long> total = orders.stream()
            .collect(Collectors.groupingBy(o -> o.customer, Collectors.counting()));
        System.out.println(total);

        System.out.println("\nOrders grouped by category:");
        Map<String, List<Order>> grouped = orders.stream()
            .collect(Collectors.groupingBy(o -> o.category));
        grouped.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}