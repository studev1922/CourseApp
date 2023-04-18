package com.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.model.JdbcHelper;
import com.course.model.Sqlbase;
import com.course.model.Util;

/**
 *
 * @author abc
 */
public class ThongTinDAO implements Sqlbase.sqlTT {

    // Xem thông tin bảng điểm
    public List<Object[]> getBangDiem(Integer maKH) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(SQL_PROC_DIEM, maKH);
            while (rs.next()) {
                double diem = rs.getDouble(Sqlbase.cols.Diem.name());
                Object[] x = {rs.getObject(1), rs.getObject(2),
                    diem, Util.HocLuc(diem)};
                list.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Xem thông tin người học
    public List<Object[]> getNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(SQL_PROC_NGUOI_HOC);
            while (rs.next()) {
                Object[] x = {
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3),
                    rs.getDate(4),};
                list.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Xem thông tin chuyên đề
    public List<Object[]> getChuyenDe() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(SQL_PROC_DIEM_CD);
            while (rs.next()) {
                Object[] x = {rs.getObject(1), rs.getObject(2),
                    rs.getObject(3), rs.getObject(4), rs.getObject(5)};
                list.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Xem thông tin doanh thu
    public List<Object[]> getDoanhThu(Integer nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.getResultSet(SQL_PROC_DOANH_THU, nam);
            while (rs.next()) {
                Object[] x = {rs.getObject(1), rs.getObject(2), rs.getObject(3),
                    rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7),};
                list.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
