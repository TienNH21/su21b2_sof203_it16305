package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import utils.JdbcUtil;

public class QLMonHocService {
    public List<MonHoc> getAll(int chuyenNganhId) {
        List<MonHoc> ds = new ArrayList<>();

        try {
            String query = "SELECT * FROM mon_hoc WHERE chuyen_nganh_id = ?";
            PreparedStatement ps = JdbcUtil.prepare(query);
            ps.setInt(1, chuyenNganhId);
            
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String tenMH = rs.getString("ten_mon_hoc");
                String maMH = rs.getString("ma_mon_hoc");
                Date ngayTao = rs.getDate("ngay_tao");
                int cnId = rs.getInt("chuyen_nganh_id");
                
                MonHoc mh = new MonHoc(id, maMH, tenMH, ngayTao, cnId);
                
                ds.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }
    
    public MonHoc insert(MonHoc monHoc) {
        try {
            String query = "INSERT INTO mon_hoc(ten_mon_hoc, ma_mon_hoc, ngay_tao, chuyen_nganh_id) "
                + " OUTPUT INSERTED.id VALUES(?, ?, ?, ?)";
            PreparedStatement ps = JdbcUtil.prepare(query);

            ps.setString(1, monHoc.getTenMH());
            ps.setString(2, monHoc.getMaMH());
            ps.setInt(4, monHoc.getChuyenNganhId());

            /*
             * monHoc.getNgayTao() -> java.util.Date
             * setDate(int, java.sql.Date)
             * convert: new java.sql.Date( utilDate.getTime() );
             */
            java.util.Date ngayTaoUtilDate = monHoc.getNgayTao();
            java.sql.Date ngayTaoSqlDate = new java.sql.Date( ngayTaoUtilDate.getTime() );
            
            ps.setDate(3, ngayTaoSqlDate);
            
            /*
             * result: Số bản ghi chịu tác động của câu truy vấn
             * id:     Lấy ra từ ResultSet, id tự tăng khi thêm mới dữ liệu
             */
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next(); // Trỏ tới bản ghi đầu tiên
            int id = rs.getInt(1);
            
            monHoc.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return monHoc;
    }
    
    public boolean update(MonHoc monHoc) {
        try {
            String query = "UPDATE mon_hoc SET ten_mon_hoc = ?, ma_mon_hoc = ?,"
                    + " ngay_tao = ?, chuyen_nganh_id = ?"
                    + " WHERE id = ?";
            PreparedStatement ps = JdbcUtil.prepare(query);
            
            ps.setString(1, monHoc.getTenMH());
            ps.setString(2, monHoc.getMaMH());
            
            java.sql.Date date = new java.sql.Date( monHoc.getNgayTao().getTime() );
            ps.setDate(3, date);
            ps.setInt(4, monHoc.getChuyenNganhId());
            ps.setInt(5, monHoc.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean delete(String maMH) {
        try {
            String query = "DELETE FROM mon_hoc WHERE ma_mon_hoc = ?";
            PreparedStatement ps = JdbcUtil.prepare(query);
            ps.setString(1, maMH);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            
            return false;
        }
        return true;
    }
    
    public boolean delete(int id) {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
