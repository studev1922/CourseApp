package com.course.entites;

/**
 *
 * @author abc
 */
public class ChuyenDe {

    // Các field trường dữ liệu
    private final String maCD;
    private String tenCD;
    private double hocPhi;
    private int thoiLuong;
    private String hinh;
    private String moTa;

    public ChuyenDe(String maCD) {
        this.maCD = maCD;
    }

    // Các phương thức đọc các trường dữ liệu
    public String getMaCD() {
        return maCD == null ? null : maCD;
    }

    public String getTenCD() {
        return tenCD == null ? null : tenCD;
    }

    public double getHocPhi() {
        return hocPhi == 0 ? 0 : hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong == 0 ? 0 : thoiLuong;
    }

    public String getHinh() {
        return hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    // Các phương thức xét các trường dữ liệu
    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
