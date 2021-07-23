/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author tiennh
 */
public class MonHoc {
    private int id;
    private String maMH;
    private String tenMH;
    private Date ngayTao;
    private int chuyenNganhId;

    public MonHoc() {
    }

    public MonHoc(int id, String maMH, String tenMH, Date ngayTao, int chuyenNganhId) {
        this.id = id;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.ngayTao = ngayTao;
        this.chuyenNganhId = chuyenNganhId;
    }
    
    public int getId() {
        return id;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public int getChuyenNganhId() {
        return chuyenNganhId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setChuyenNganhId(int chuyenNganhId) {
        this.chuyenNganhId = chuyenNganhId;
    }
    
    
}
