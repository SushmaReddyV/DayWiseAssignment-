import java.util.*;

public class BookTitleFilter {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>(Arrays.asList("Python Guide", "Java Basics", "C++ Handbook", "Perl Tips"));
        Iterator<String> it = books.iterator();

        while (it.hasNext()) {
            String title = it.next();
            if (title.startsWith("P")) {
                it.remove();
            }
        }

        System.out.println("Filtered Book Titles:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
