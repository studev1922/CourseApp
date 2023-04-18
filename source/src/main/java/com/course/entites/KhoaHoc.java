package com.course.entites;

import java.sql.Date;

/**
 *
 * @author abc
 */
public class KhoaHoc {

    // Các field trường dữ liệu
    private int MaKH;
    private double hocPhi;
    private int thoiLuong;
    private Date ngayKG;
    private String ghiChu;
    private String maCD;
    private String maNV;
    private Date ngayTao;

    // Hàm tạo đối tượng 
    public KhoaHoc() {
    }

    public KhoaHoc(int MaKH) {
        this.MaKH = MaKH;
    }

    // Các phương thức đọc dữ liệu
    public int getMaKH() {
        return MaKH;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public Date getNgayKG() {
        return ngayKG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getMaCD() {
        return maCD;
    }

    public String getMaNV() {
        return maNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    // Các phương thức ghi dữ liệu
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

}
