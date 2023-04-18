/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.dao;

import java.util.List;

import com.course.entites.HocVien;
import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer> implements Sqlbase.sqlHV {

    @Override // Thêm thông tin HocVien vào database
    public boolean Insert(HocVien x) {
        try {
            JdbcHelper.Query(ON+SQL_INSERT+OFF, x.getMaHV(), x.getMaKH(), x.getDiem(), x.getMaNH());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Cập nhật thông tin HocVien
    public boolean Update(HocVien x) {
        try {
            JdbcHelper.Query(SQL_UPDATE, x.getMaKH(), x.getDiem(),x.getMaNH(), x.getMaHV());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override // Xóa thông tin HocVien
    public boolean Delete(Integer maHV) {
        try {
            JdbcHelper.Query(SQL_DELETE, maHV);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override // Lấy danh sách HocVien
    public List<HocVien> SelectAll() {
        return this.SelectBySql(SQL_SELECT);
    }

    @Override // Lấy thông tin HocVien theo lệnh sql
    public List<HocVien> SelectBySql(String sql, Object... agrs) {
        ArrayList<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(sql, agrs);
            while (rs.next()) {
                HocVien hv = new HocVien(rs.getInt(Sqlbase.cols.MaHV.name()));
                hv.setDiem(rs.getDouble(Sqlbase.cols.Diem.name()));
                hv.setMaKH(rs.getInt(Sqlbase.cols.MaKH.name()));
                hv.setMaNH(rs.getString(Sqlbase.cols.MaNH.name()));
                list.add(hv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override // Lấy thông tin theo mã HocVien
    public HocVien SelectById(Integer maHV) {
        List<HocVien> list = this.SelectBySql(SQL_SELECT_ID, maHV);
        return list.isEmpty() ? null : list.get(0);
    }

    // Lấy thông tin theo mã khóa học
    public List<HocVien> SelectByMaKH(Integer maKH){
        return this.SelectBySql(FOREIGN_KH, maKH);
    }
    
    // Lấy mã số lớn nhất
    public int SelectMaxMaHV(){
        try {
            ResultSet rs = JdbcHelper.getResultSet(SQL_MAXCODE);
            rs.next(); return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } return -1;
    }
    
    // Cập nhập điểm
    public boolean UpPoint(double diem, int maHV){
        try {
            JdbcHelper.Query(SQL_UP_POINT, diem, maHV);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
