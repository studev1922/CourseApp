package com.course.entites;

import java.sql.Date;

/**
 *
 * @author abc
 */
public class NguoiHoc {

    // Các field trường dữ liệu
    private final String maNH;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String dienThoai;
    private String email;
    private String ghiChu;
    private String maNV;
    private Date ngayDK;

    // Hàm tạo
    public NguoiHoc(String maNH) {
        this.maNH = maNH;
    }

    // Các phương thức đọc dữ liệu
    public String getMaNH() {
        return maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    // Các phương thức ghi dữ liệu
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

}
