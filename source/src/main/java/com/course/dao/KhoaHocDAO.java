/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

import com.course.entites.KhoaHoc;
import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer> implements Sqlbase.sqlKH {

    @Override // Thêm thông tin KhoaHoc vào database
    public boolean Insert(KhoaHoc x) {
        try {
            JdbcHelper.Query(ON + SQL_INSERT + OFF, x.getMaKH(), x.getMaCD(),
                    x.getHocPhi(), x.getThoiLuong(), x.getNgayKG(),
                    x.getGhiChu(), x.getMaNV(), x.getNgayTao());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Cập nhật thông tin KhoaHoc
    public boolean Update(KhoaHoc x) {
        try {
            JdbcHelper.Query(SQL_UPDATE, x.getMaCD(), x.getHocPhi(), x.getThoiLuong(),
                    x.getNgayKG(), x.getGhiChu(), x.getMaNV(), x.getNgayTao(), x.getMaKH());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override // Xóa thông tin KhoaHoc
    public boolean Delete(Integer maKH) {
        try {
            JdbcHelper.Query(SQL_DELETE, maKH);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Lấy danh sách KhoaHoc
    public List<KhoaHoc> SelectAll() {
        return this.SelectBySql(SQL_SELECT);
    }

    @Override // Lấy thông tin KhoaHoc theo lệnh sql
    public List<KhoaHoc> SelectBySql(String sql, Object... agrs) {
        ArrayList<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(sql, agrs);
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc(rs.getInt(Sqlbase.cols.MaKH.name()));
                kh.setHocPhi(rs.getDouble(Sqlbase.cols.HocPhi.name()));
                kh.setThoiLuong(rs.getInt(Sqlbase.cols.ThoiLuong.name()));
                kh.setNgayKG(rs.getDate(Sqlbase.cols.NgayKG.name()));
                kh.setGhiChu(rs.getString(Sqlbase.cols.GhiChu.name()));
                kh.setNgayTao(rs.getDate(Sqlbase.cols.NgayTao.name()));
                kh.setMaCD(rs.getString(Sqlbase.cols.MaCD.name()));
                kh.setMaNV(rs.getString(Sqlbase.cols.MaNV.name()));
                list.add(kh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override // Lấy thông tin theo mã KhoaHoc
    public KhoaHoc SelectById(Integer maKH) {
        List<KhoaHoc> list = this.SelectBySql(SQL_SELECT_ID, maKH);
        return list.isEmpty() ? null : list.get(0);
    }

    // Lấy thông tin danh sách từ mã chuyên đề
    public List<KhoaHoc> SelectByChuyenDe(String MaCD) {
        return this.SelectBySql(FOREIGN_MACD, MaCD);
    }
}
