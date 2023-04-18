/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

import com.course.entites.NguoiHoc;
import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> implements Sqlbase.sqlNH {

    @Override // Thêm thông tin NguoiHoc vào database
    public boolean Insert(NguoiHoc x) {
        try {
            JdbcHelper.Query(SQL_INSERT,
                    x.getMaNH(), x.getHoTen(), x.getNgaySinh(),
                    x.isGioiTinh(), x.getDienThoai(), x.getEmail(),
                    x.getGhiChu(), x.getMaNV(), x.getNgayDK());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Cập nhật thông tin NguoiHoc
    public boolean Update(NguoiHoc x) {
        try {
            JdbcHelper.Query(SQL_UPDATE,
                    x.getHoTen(), x.getNgaySinh(), x.isGioiTinh(), x.getDienThoai(),
                    x.getEmail(), x.getGhiChu(), x.getMaNV(), x.getNgayDK(), x.getMaNH());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Xóa thông tin NguoiHoc
    public boolean Delete(String maNH) {
        try {
            JdbcHelper.Query(SQL_DELETE, maNH);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override // Lấy thông tin theo mã NguoiHoc
    public NguoiHoc SelectById(String maNH) {
        List<NguoiHoc> list = this.SelectBySql(SQL_SELECT_ID, maNH);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override // Lấy danh sách NguoiHoc
    public List<NguoiHoc> SelectAll() {
        return this.SelectBySql(SQL_SELECT);
    }

    @Override // Lấy thông tin NguoiHoc theo lệnh sql
    public List<NguoiHoc> SelectBySql(String sql, Object... agrs) {
        ArrayList<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(sql, agrs);
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc(rs.getString(Sqlbase.cols.MaNH.name()));
                nh.setHoTen(rs.getString(Sqlbase.cols.HoTen.name()));
                nh.setGioiTinh(rs.getBoolean(Sqlbase.cols.GioiTinh.name()));
                nh.setNgaySinh(rs.getDate(Sqlbase.cols.NgaySinh.name()));
                nh.setDienThoai(rs.getString(Sqlbase.cols.DienThoai.name()));
                nh.setEmail(rs.getString(Sqlbase.cols.Email.name()));
                nh.setGhiChu(rs.getString(Sqlbase.cols.GhiChu.name()));
                nh.setNgayDK(rs.getDate(Sqlbase.cols.NgayDK.name()));
                nh.setMaNV(rs.getString(Sqlbase.cols.MaNV.name()));
                list.add(nh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Lấy thông tin người họcs
    public List<NguoiHoc> SelectNotInCourse(String name, int maKH) {
        return this.SelectBySql(JOINOT_HOCVIEN + " and HoTen like N'%" + name + "%'", maKH);
    }

}
