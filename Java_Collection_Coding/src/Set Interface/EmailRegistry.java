import java.util.*;

public class EmailRegistry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> emails = new HashSet<>();

        System.out.println("Enter email IDs (type 'end' to finish):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("end")) break;
            emails.add(email);
        }

        System.out.println("Registered Emails:");
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
