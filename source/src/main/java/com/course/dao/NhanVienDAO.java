/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

import com.course.entites.NhanVien;
import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> implements Sqlbase.sqlNV {

    @Override // Thêm thông tin NhanVien vào database
    public boolean Insert(NhanVien x) {
        try {
            JdbcHelper.Query(SQL_INSERT, x.getMaNV(), x.getMatKhau(), x.getHoTen(), x.getEmail(), x.isVaiTro());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override // Cập nhật thông tin NhanVien
    public boolean Update(NhanVien x) {
        try {
            JdbcHelper.Query(SQL_UPDATE, x.getMatKhau(), x.getHoTen(), x.getEmail(), x.isVaiTro(), x.getMaNV());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override // Xóa thông tin NhanVien
    public boolean Delete(String maNV) {
        try {
            JdbcHelper.Query(SQL_DELETE, maNV);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override // Lấy thông tin theo mã NhanVien
    public NhanVien SelectById(String maNV) {
        List<NhanVien> list = this.SelectBySql(SQL_SELECT_ID, maNV);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override // Lấy danh sách NhanVien
    public List<NhanVien> SelectAll() {
        return this.SelectBySql(SQL_SELECT);
    }

    @Override // Lấy thông tin NhanVien theo lệnh sql
    public List<NhanVien> SelectBySql(String sql, Object... agrs) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(sql, agrs);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(Sqlbase.cols.MaNV.name()));
                nv.setMatKhau(rs.getString(Sqlbase.cols.MatKhau.name()));
                nv.setHoTen(rs.getString(Sqlbase.cols.HoTen.name()));
                nv.setEmail(rs.getString(Sqlbase.cols.EmailNV.name()));
                nv.setVaiTro(rs.getBoolean(Sqlbase.cols.VaiTro.name()));
                list.add(nv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
