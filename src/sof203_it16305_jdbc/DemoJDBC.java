package sof203_it16305_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import models.User;
//import models.User;

public class DemoJDBC {
    public static void main(String[] args) {
        try {
            // Bước 1: Load driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // url format:
            // <protocol>://<host>:<port>;databaseName=<db-name>
            String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic",
                dbUsername = "sa", dbPassword = "Aa@123456";

            // Bước 2: Tạo kết nối đến DB
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            String query = "SELECT * FROM users";
            
            // Bước 3: Tạo Statement để thực thi câu truy vấn
            Statement stm = conn.createStatement();
            
            // Bước 4: Thực thi câu truy vấn
            ResultSet rs = stm.executeQuery(query);

            /*
             * Bước 5: Bóc dữ liệu
             * rs.next() -> boolean: true|false
             * Nếu còn dữ liệu có thể đọc được từ ResultSet -> true
             * Nếu ko còn dữ liệu có thể đọc                -> false
             */
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                
                User u = new User(id, username, password, role);
                
                System.out.printf("%d - %s - %s - %d\n", id, username, password, role);
            }
            
            // Bước 6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
