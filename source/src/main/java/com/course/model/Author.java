package com.course.model;
import com.course.dao.NhanVienDAO;
import com.course.entites.NhanVien;

/**
 *
 * @author abc
 */
public class Author {

    public static NhanVien user = null;

    // Contructer tạo đối tượng người dùng(kiểm tra mã tồn tại)
    public Author(String maCode) {
        user = new NhanVienDAO().SelectById(maCode);
    }

    public static void setUser(NhanVien user) {
        Author.user = user;
    }

    public static NhanVien getUser() {
        return user;
    }

    // Xóa người dùng trong chương trình
    public static void clear() {
        user = null;
    }

    // Kiểm tra đăng nhập
    public static boolean isLogin() {
        return user != null;
    }

    // Kiểm tra vai trò
    public static boolean isManager() {
        if (user != null) {
            return user.isVaiTro();
        }
        return false;
    }

}
