package sof203_it16305_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoInsertStatement {
    public static void main(String[] args) {
        // PH15099 - Mai Thành Vinh -> nghỉ
        // Nguyễn Đức Huy

        User user = new User(0, "TienNH19", "123456", 2);

        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic";
            // url: <protocol>://<host>:<port>;databaseName=<db-name>
            
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // B3: Tạo PreparedStatement
            String query = "INSERT INTO users(username, password, role) VALUES (?, ?, ?) ";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole());

            // B4 - B5: Thực thi truy vấn
            int result = ps.executeUpdate();
            
            System.out.println("Result: " + result);

            // B6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
