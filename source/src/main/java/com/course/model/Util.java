package com.course.model;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 * @author abc
 * @see ExitForm(...) thoát chương trình
 * @see ramdomCode(...) Ramdom mã có độ dài kí tự bằng số truyền vào
 * @see HocLuc(...) tính điểm trả phân loại học
 */
public class Util {

    public static void saveToExcel(JTable table) throws Exception {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // header name
        String[] headNames = new String[model.getColumnCount()];
        for (int i = 0; i < headNames.length; i++) {
            headNames[i] = model.getColumnName(i);
        }
        // data
        Object[][] data = new Object[model.getRowCount()][model.getColumnCount()];
        List<Vector> list = model.getDataVector();
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i).toArray();
        }
        // write file data
        excel.writeExcel(headNames, data, null);
    }

    // Thoát chương trình đăng hiện tại
    public static void ExitForm(String title, Component component) {
        int n = MsgBox.confirm(component, "Thoát chương trình \""
                + title + "\"?", "KẾT THÚC " + title, MsgBox.BaoLoi);
        if (n == 0) {
            System.exit(0);
        }
        /* esle {...} */
    }

    // Random mã với độ dài truyền vào
    public static String ramdomCode(int length) {
        Random r = new Random();
        String a = "";
        // lấy 3 kí tự cuối của khách hàng
        while (a.length() < length) {
            int i = r.nextInt(122);
            if (i > 47 && i < 58) {
                a += (char) i;
            } else if (i > 64 && i < 91) {
                a += (char) i;
            } else if (i > 96 && i < 123) {
                a += (char) i;
            }
        }
        // ramdom 5 kí tự đầu + 3 kí tự cuối của khách
        return a;
    }

    // Tính học lực
    public static String HocLuc(double diem) {
        if (diem < 0) {
            return "không xếp loại!";
        }
        if (diem < 3) {
            return "Kém";
        }
        if (diem < 5) {
            return "Yếu";
        }
        if (diem < 6.5) {
            return "Trung bình";
        }
        if (diem < 7.5) {
            return "Khá";
        }
        if (diem < 9) {
            return "Giỏi";
        }
        if (diem <= 10) {
            return "Suất xắc";
        } else {
            return "-";
        }
    }

    // Chạy đồng hồ
    public static Timer setTimer(JLabel lblThoiGian, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        Timer timer = new Timer(1000, (e) -> {
            lblThoiGian.setText(format.format(e.getWhen()));
        });
        return timer;
    }

}
