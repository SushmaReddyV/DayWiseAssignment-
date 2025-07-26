package executorservice;
import java.util.concurrent.*;

public class FileUploadDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Runnable uploadTask = () -> System.out.println("File uploaded by: " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            service.submit(uploadTask);
        }

        service.shutdown();
    }
}