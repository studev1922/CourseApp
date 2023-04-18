/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

import com.course.entites.ChuyenDe;
import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> implements Sqlbase.sqlCD {

    @Override // Thêm thông tin ChuyenDe vào database
    public boolean Insert(ChuyenDe x) {
        try {
            JdbcHelper.Query(SQL_INSERT, x.getMaCD(), x.getTenCD(),
                    x.getHocPhi(), x.getThoiLuong(), x.getHinh(), x.getMoTa());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Cập nhật thông tin ChuyenDe
    public boolean Update(ChuyenDe x) {
        try {
            JdbcHelper.Query(SQL_UPDATE, x.getTenCD(), x.getHocPhi(),
                    x.getThoiLuong(), x.getHinh(), x.getMoTa(), x.getMaCD());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Xóa thông tin ChuyenDe
    public boolean Delete(String maCD) {
        try {
            JdbcHelper.Query(SQL_DELETE, maCD);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Lấy thông tin theo mã ChuyenDe
    public ChuyenDe SelectById(String maCD) {
        List<ChuyenDe> list = this.SelectBySql(SQL_SELECT_ID, maCD);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override // Lấy danh sách ChuyenDe
    public List<ChuyenDe> SelectAll() {
        return this.SelectBySql(SQL_SELECT);
    }

    @Override // Lấy thông tin ChuyenDe theo lệnh sql
    public List<ChuyenDe> SelectBySql(String sql, Object... agrs) {
        ArrayList<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(sql, agrs);
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe(rs.getString(Sqlbase.cols.MaCD.name()));
                cd.setTenCD(rs.getString(Sqlbase.cols.TenCD.name()));
                cd.setHocPhi(rs.getDouble(Sqlbase.cols.HocPhi.name()));
                cd.setThoiLuong(rs.getInt(Sqlbase.cols.ThoiLuong.name()));
                cd.setHinh(rs.getString(Sqlbase.cols.Hinh.name()));
                cd.setMoTa(rs.getString(Sqlbase.cols.MoTa.name()));
                list.add(cd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
