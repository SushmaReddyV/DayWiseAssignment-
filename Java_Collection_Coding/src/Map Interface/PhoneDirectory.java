import java.util.*;

public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> directory = new HashMap<>();

        System.out.println("Enter name and phone number (type 'end' to stop):");
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;

            System.out.print("Phone: ");
            String phone = sc.nextLine();
            directory.put(name, phone);
        }

        System.out.println("Phone Directory:");
        for (Map.Entry<String, String> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
