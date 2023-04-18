package com.course.entites;

/**
 *
 * @author abc
 */
public class HocVien {

    private int maHV;
    private int maKH;
    private String maNH;
    private double diem;

    // Hàm tạo contructor
    public HocVien() {
    }

    public HocVien(int maHV) {
        this.maHV = maHV;
    }

    // Đọc các trường dữ liệu
    public int getMaHV() {
        return maHV;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public double getDiem() {
        return diem;
    }

    // Thay đổi các trường dữ liệu
    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
