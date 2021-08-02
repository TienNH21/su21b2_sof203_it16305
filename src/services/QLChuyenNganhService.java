package services;

import java.util.ArrayList;
import java.util.List;
import models.ChuyenNganh;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.JdbcUtil;

public class QLChuyenNganhService {
    public List<ChuyenNganh> getAll() {
        List<ChuyenNganh> list = new ArrayList<ChuyenNganh>();
        
        try {
            String query = "SELECT * FROM chuyen_nganh";
            PreparedStatement ps = JdbcUtil.prepare(query);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String tenChuyenNganh = rs.getString("ten_chuyen_nganh");
                ChuyenNganh cn = new ChuyenNganh(id, tenChuyenNganh);
                list.add(cn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
