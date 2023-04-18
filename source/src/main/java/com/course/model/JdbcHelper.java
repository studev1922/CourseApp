package com.course.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class JdbcHelper {

    final static String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String db_Url="jdbc:sqlserver://localhost:1433;databaseName=EduSys;trustServercertificate=true";
    static String user = "sa";
    static String password = "songlong";

    // Nạp driver một lần bằng khối satatic
    static {
        try {
            Class.forName(CLASSNAME); // Nạp driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Tạo thủ tục lưu dữ liệu trong database
    public static PreparedStatement getStatement(String sql, Object... agrs)
            throws SQLException {
        Connection con = DriverManager.getConnection(db_Url, user, password);
        // Kiểm tra có phải là procduce hoặc chuỗi slq bình thường.
        PreparedStatement statement = sql.trim().startsWith("{")
                ? con.prepareCall(sql) : con.prepareStatement(sql);
        for (int i = 0; i < agrs.length; i++) {
            statement.setObject(i + 1, agrs[i]);
        }
        return statement;
    }

    // Lấy resultSet
    public static ResultSet getResultSet(String sql, Object... agrs)
            throws SQLException {
        try {
            return getStatement(sql, agrs).executeQuery();
        } catch (SQLException e) {
            throw e;
        }
    }

    // Lấy thông tin đầu tiên
    public static Object Value(String sql, Object... agrs)
            throws SQLException {
        try {
            ResultSet rs = getResultSet(sql, agrs);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    // Thao tác dữ liệu trên database
    public static int Query(String sql, Object... agrs) throws SQLException {
        try {
            PreparedStatement statement = getStatement(sql, agrs);
            try {
                return statement.executeUpdate();
            } finally {
                statement.getConnection().close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
