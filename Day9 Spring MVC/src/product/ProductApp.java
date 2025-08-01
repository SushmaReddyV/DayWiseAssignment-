package product;
import db.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = DBConnection.getConnection("inventory_db");

        if (conn == null) {
            System.out.println("Connection failed.");
            return;
        }

        while (true) {
            System.out.println("\n1. Add Product\n2. View Products\n3. Update Quantity\n4. Delete Product\n5. Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID, Name, Quantity, Price: ");
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?)");
                        ps.setInt(1, sc.nextInt());
                        ps.setString(2, sc.next());
                        ps.setInt(3, sc.nextInt());
                        ps.setDouble(4, sc.nextDouble());
                        ps.executeUpdate();
                        System.out.println("Product added.");
                        break;
                    case 2:
                        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM products");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " +
                                               rs.getInt(3) + " | " + rs.getDouble(4));
                        }
                        break;
                    case 3:
                        System.out.print("Enter Product ID to update quantity: ");
                        int id = sc.nextInt();
                        System.out.print("New Quantity: ");
                        int qty = sc.nextInt();
                        PreparedStatement ps2 = conn.prepareStatement("UPDATE products SET quantity=? WHERE product_id=?");
                        ps2.setInt(1, qty);
                        ps2.setInt(2, id);
                        ps2.executeUpdate();
                        System.out.println("Quantity updated.");
                        break;
                    case 4:
                        System.out.print("Enter Product ID to delete: ");
                        int delId = sc.nextInt();
                        PreparedStatement ps3 = conn.prepareStatement("DELETE FROM products WHERE product_id=?");
                        ps3.setInt(1, delId);
                        ps3.executeUpdate();
                        System.out.println("Product deleted.");
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