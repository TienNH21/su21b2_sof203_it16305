package sof203_it16305_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoUpdateUser {
    // Nguyễn Khánh Toàn
    public static void main(String[] args) {
        User u = new User(2002, "TienNH11", "123123", 1);
        
        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nỗi
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic",
                dbUsername = "sa", dbPassword = "Aa@123456";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // B3: Tạo PreparedStatement
            String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getRole());
            ps.setInt(4, u.getId());

            // B4: Truy vấn
            // B5: Bóc dữ liệu
            int kq = ps.executeUpdate();

            System.out.println("Kết quả: " + kq);
            
            // B6: Đóng kết nối
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
