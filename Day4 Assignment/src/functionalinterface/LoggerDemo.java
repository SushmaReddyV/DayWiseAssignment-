package functionalinterface;
import java.util.function.Predicate;

@FunctionalInterface
interface LogFilter {
    boolean filter(String message);
}

public class LoggerDemo {
    public static void main(String[] args) {
        log("System started", msg -> msg.contains("System"));
        log("Error occurred", msg -> msg.contains("Error"));
    }

    static void log(String message, LogFilter filter) {
        if (filter.filter(message)) {
            System.out.println("LOG: " + message);
        }
    }
}