package lambda;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + ": " + salary;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 70000),
            new Employee("Charlie", 40000)
        );

        System.out.println("Sorted by Name:");
        employees.stream()
                 .sorted((e1, e2) -> e1.name.compareTo(e2.name))
                 .forEach(System.out::println);

        System.out.println("\nFiltered by Salary > 45000:");
        employees.stream()
                 .filter(e -> e.salary > 45000)
                 .forEach(System.out::println);
    }
}