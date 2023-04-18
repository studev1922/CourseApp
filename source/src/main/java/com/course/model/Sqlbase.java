/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.model;

/**
 * @author abc
 */
public class Sqlbase {

    /**
     * 1. cols: Các cột trong cơ sở dữ liệu. 
     * 2. sqlNV: Các lệnh truy vấn databse bảng Nhân viên.
     * 3. sqlNH: Các lệnh truy vấn databse bảng Người Học.
     * 4. sqlCD: Các lệnh truy vấn databse bảng Chuyên Đề.
     * 5. sqlKH: Các lệnh truy vấn databse bảng Khóa Học.
     * 6. sqlHV: Các lệnh truy vấn databse bảng Học Viên.
     * 7. sqlTT: Các lệnh truy vấn databse procduce Thông tin.
     */
    // Các tên cột dữ liệu trong database
    public enum cols {
        MaNV, MatKhau, HoTen, VaiTro, MaNH, GioiTinh, NgaySinh, DienThoai,
        Email, EmailNV, GhiChu, NgayDK, MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa,
        MaKH, NgayKG, NgayTao, MaHV, Diem
    }

    // Các hằng dữ liệu câu truy vấn sql server bảng NhanVien
    public static interface sqlNV {

        String SQL_INSERT = "Insert into NhanVien values(?,?,?,?,?)";
        String SQL_UPDATE = "Update NhanVien Set MatKhau= ?,HoTen= ?, EmailNV=?, VaiTro= ? Where MaNV= ?";
        String SQL_DELETE = "Delete from NhanVien where MaNV = ?";
        String SQL_SELECT_ID = "Select * from NhanVien where MaNV = ?";
        String SQL_SELECT = "Select * from NhanVien";
    }

    // Các hằng dữ liệu câu truy vấn sql server bảng NguoiHoc
    public static interface sqlNH {

        String SQL_INSERT = "Insert into NguoiHoc values(?,?,?,?,?,?,?,?,?)";
        String SQL_UPDATE = "Update NguoiHoc Set HoTen= ?,NgaySinh= ?,GioiTinh= ?"
                + ",DienThoai= ?,Email= ?,GhiChu= ?,MaNV= ?,NgayDK= ? Where MaNH= ?";
        String SQL_DELETE = "Delete from NguoiHoc where MaNH = ?";
        String SQL_SELECT_ID = "Select * from NguoiHoc where MaNH = ?";
        String SQL_SELECT = "Select * from NguoiHoc";
        String JOINOT_HOCVIEN = SQL_SELECT + " where MaNH not in "
                + "(Select MaNH from HocVien where MaKH = ?)";
        String FOREIGN_MAKH = SQL_SELECT + " where MaKH = ?";
    }

    // Các hằng dữ liệu câu truy vấn sql server bảng ChuyenDe
    public static interface sqlCD {

        String SQL_INSERT = "Insert into ChuyenDe values(?,?,?,?,?,?)";
        String SQL_UPDATE = "Update ChuyenDe Set TenCD= ?,HocPhi= ?,ThoiLuong= ?"
                + ",Hinh= ?,MoTa= ? Where MaCD= ?";
        String SQL_DELETE = "Delete from ChuyenDe where MaCD = ?";
        String SQL_SELECT = "Select * from ChuyenDe";
        String SQL_SELECT_ID = SQL_SELECT + " where MaCD = ?";
    }

    // Các hằng dữ liệu câu truy vấn sql server bảng KhoaHoc
    public static interface sqlKH {

        String ON = "SET IDENTITY_INSERT [dbo].[KhoaHoc] ON \n";
        String OFF = "\n SET IDENTITY_INSERT [dbo].[KhoaHoc] OFF";
        String SQL_INSERT = "Insert KhoaHoc(MaKH,MaCD,HocPhi,ThoiLuong,"
                + "NgayKG,GhiChu,MaNV,NgayTao) values(?,?,?,?,?,?,?,?)";
        String SQL_UPDATE = "Update KhoaHoc Set MaCD= ?,HocPhi= ?, ThoiLuong= ?,"
                + "NgayKG= ?,GhiChu= ?,MaNV= ?,NgayTao= ? Where MaKH= ?";
        String SQL_DELETE = "Delete from KhoaHoc where MaKH = ?";
        String SQL_SELECT = "Select * from KhoaHoc";
        String SQL_SELECT_ID = SQL_SELECT + " where MaKH = ?";
        String FOREIGN_MACD = SQL_SELECT + " where MaCD = ?";
    }

    // Các hằng dữ liệu câu truy vấn sql server bảng HocVien
    public static interface sqlHV {

        String ON = "SET IDENTITY_INSERT [dbo].[HocVien] ON \n";
        String OFF = "\n SET IDENTITY_INSERT [dbo].[HocVien] OFF";
        String SQL_INSERT = "Insert into HocVien ([MaHV], [MaKH], [Diem], [MaNH])"
                + " values(?,?,?,?)";
        String SQL_UPDATE = "Update HocVien Set MaKH= ?, Diem= ?, MaNH= ? where MaHV= ?";
        String SQL_DELETE = "Delete from HocVien where MaHV = ?";
        String SQL_SELECT_ID = "Select * from HocVien where MaHV = ?";
        String SQL_SELECT = "Select * from HocVien";
        String SQL_UP_POINT = "Update HocVien set Diem = ? where MaHV = ?";
        String SQL_MAXCODE = "Select MAX(MaHV) from HocVien";
        String FOREIGN_KH = SQL_SELECT + " where MaKH = ?";
    }

    // Thông tin thủ tục lưu
    public static interface sqlTT {

        String SQL_PROC_DIEM = "{CALL sp_BangDiem(?)}";
        String SQL_PROC_NGUOI_HOC = "{CALL sp_LuongNguoiHoc}";
        String SQL_PROC_DIEM_CD = "{CALL sp_DiemChuyenDe}";
        String SQL_PROC_DOANH_THU = "{CALL sp_DoanhThu(?)}";
    }

}
