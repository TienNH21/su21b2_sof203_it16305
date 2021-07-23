package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;

public class QLMonHocService {
    public List<MonHoc> getAll() {
        List<MonHoc> list = new ArrayList<>();

        // 6 bước kết nối JDBC để lấy danh sách các môn học

        return list;
    }
    
    public int them(MonHoc mh) {
        // https://stackoverflow.com/a/7917874
        return 0;
    }
    
    public boolean capNhat(MonHoc mh) {
        return true;
    }
    
    public boolean xoa(int id) {
        return true;
    }
}
