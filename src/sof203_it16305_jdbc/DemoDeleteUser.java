package sof203_it16305_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoDeleteUser {
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
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, u.getId());

            // B4: Truy vấn
            // B5: Bóc dữ liệu
            ps.executeUpdate();

            // B6: Đóng kết nối
            conn.close();

            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
