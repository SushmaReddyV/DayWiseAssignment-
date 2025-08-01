package course;
import db.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class CourseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = DBConnection.getConnection("course_db");

        if (conn == null) {
            System.out.println("Connection failed.");
            return;
        }

        while (true) {
            System.out.println("\n1. Add Course\n2. View Courses\n3. Update Course\n4. Delete Course\n5. Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID, Name, Faculty, Credits: ");
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO courses VALUES (?, ?, ?, ?)");
                        ps.setInt(1, sc.nextInt());
                        ps.setString(2, sc.next());
                        ps.setString(3, sc.next());
                        ps.setInt(4, sc.nextInt());
                        ps.executeUpdate();
                        System.out.println("Course added.");
                        break;
                    case 2:
                        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM courses");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " +
                                               rs.getString(3) + " | " + rs.getInt(4));
                        }
                        break;
                    case 3:
                        System.out.print("Enter Course ID to update: ");
                        int id = sc.nextInt();
                        System.out.print("New Faculty: ");
                        String faculty = sc.next();
                        System.out.print("New Credits: ");
                        int credits = sc.nextInt();
                        PreparedStatement ps2 = conn.prepareStatement("UPDATE courses SET faculty=?, credits=? WHERE course_id=?");
                        ps2.setString(1, faculty);
                        ps2.setInt(2, credits);
                        ps2.setInt(3, id);
                        ps2.executeUpdate();
                        System.out.println("Course updated.");
                        break;
                    case 4:
                        System.out.print("Enter Course ID to delete: ");
                        int delId = sc.nextInt();
                        PreparedStatement ps3 = conn.prepareStatement("DELETE FROM courses WHERE course_id=?");
                        ps3.setInt(1, delId);
                        ps3.executeUpdate();
                        System.out.println("Course deleted.");
                        break;
                    case 5:
                        System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}