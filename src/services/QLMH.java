package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class QLMH {
    public List<MonHoc> getAll() {
        List<MonHoc> ds = new ArrayList<>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String dbUser = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";

            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            String query = "SELECT * FROM mon_hoc";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String tenMH = rs.getString("ten_mon_hoc");
                String maMH = rs.getString("ma_mon_hoc");
                Date ngayTao = rs.getDate("ngay_tao");
                int chuyenNganhId = rs.getInt("chuyen_nganh_id");
                
                MonHoc mh = new MonHoc(id, maMH, tenMH, ngayTao, chuyenNganhId);
                
                ds.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }
    
    public MonHoc insert(MonHoc monHoc) {
        return null;
    }
    
    public boolean update(MonHoc monHoc) {
        return true;
    }
    
    public boolean delete(int id) {
        return true;
    }
}
