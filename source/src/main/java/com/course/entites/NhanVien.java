package com.course.entites;

/**
 *
 * @author abc
 */
public class NhanVien {

    // Field trường dữ liệu
    private final String MaNV;
    private String MatKhau;
    private String HoTen;
    private String Email;
    private boolean VaiTro;

    // Hàm tạo đối tượng
    public NhanVien(String MaNV) {
        this.MaNV = MaNV;
    }

    // Các phương thức đọc dữ liệu
    public String getMaNV() {
        return MaNV == null ? "" : MaNV;
    }

    public String getMatKhau() {
        return MatKhau == null ? "" : MatKhau;
    }

    public String getHoTen() {
        return HoTen == null ? "" : HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    // Các phương thức ghi dữ liệu
    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

}
