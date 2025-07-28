import java.util.*;

public class StudentNameSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> students = new ArrayList<>();

        System.out.println("Enter student names (type 'end' to finish):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            students.add(name);
        }

        Collections.sort(students);
        System.out.println("Sorted Student Names:");
        for (String name : students) {
            System.out.println(name);
        }
    }
}
