/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.model;

import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author abc
 */
// Lớp kiểm tra các thuộc tính
public class Validate {

    public static final String KI_TU_DAC_BIET = "^[a-zA-Z0-9]*$";
    public static final String HO_VA_TEN = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
    public static final String MAT_KHAU = "[a-zA-Z0-9]{1,50}";
    public static final String DIEN_THOAI = "\\d{6,24}";
    public static final String EMAIL = "\\w+@\\w+(\\.\\w+){1,2}";

    /**
     * @param parent: hiển thị "vị trí" theo đối tượng này.
     * @param format: kiểm tra "biểu thức chính quy".
     * @param strCheck: chuỗi cần được "kiểm tra".
     * @param min: "tối thiểu" kí tự.
     * @param max: "tối đa" kí tự.
     * @param mes: "Các thông tin cần được thông báo"
     * @return kết quả kiểm tra sau "biểu thức chính quy" + "độ dài chuỗi"
     */
    public static boolean ValString(Component parent, String format,
            String strCheck, int min, int max, String... mes) {
        if (strCheck.isEmpty()) {
            MsgBox.alert(parent,
                    ("Không được để dữ liệu là null"),
                    "Cảnh báo dữ liệu nhập vào", MsgBox.CanhBao);
            return false;
        } else {
            // Kiểm tra độ dài
            int length = strCheck.length();
            if (length < min || max < length) {
                if (min == max) {
                    System.out.println(min + "" + max);
                    MsgBox.alert(parent,
                            ("Chiều dài chuỗi phải là:\"" + min + "\" kí tự."),
                            "Cảnh báo dữ liệu nhập vào", MsgBox.CanhBao);
                } else {
                    MsgBox.alert(parent,
                            ("Chiều dài chuỗi phải trong khoảng \"" + min
                            + " tới " + max + "\" kí tự."),
                            "Cảnh báo dữ liệu nhập vào", MsgBox.CanhBao);
                }
                return false;
            } else if (!strCheck.matches(format)) {
                String mesage = "";
                for (String x : mes) {
                    mesage += "\n - " + x;
                }
                MsgBox.alert(parent,
                        "Dữ liệu không đúng quy định!" + mesage,
                        "Cảnh báo dữ liệu nhập vào",
                        MsgBox.CanhBao);
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * @param number convert to (int) Integer
     * @return kết quả sau khi đổi, nếu không thành công => -1
     */
    public static int ConvertInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @param number convert to (double) Double
     * @return type double after convert from String
     */
    public static double ConvertDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @param string là: chuỗi truyền vào cần dược cắt
     * @param first == 0 cắt từ 0...end
     * @param end == 0 cắt từ first...string.length()
     * @return "String" sau khi được sử lý
     */
    public static String cutString(String string, int first, int end) {
        try {
            string = string.trim();
            return string.substring(
                    0 < first && first <= string.length() ? first : 0,
                    0 < end && end <= string.length() ? end : string.length()
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static Date ConvertDate(String date, Component com, long day) {
        try {
            if (date.trim() == null) {
                return new Date(new java.util.Date().getTime());
            }
            date = date.replace("-", "/");
            long L = new SimpleDateFormat("yyyy/MM/dd").parse(date).getTime();
            return new Date(L);
        } catch (ParseException e) {
            boolean check = 0 == MsgBox.confirm(com,
                    "Sai định dạng ngày, hệ thống tự chọn ngày",
                    "Thêm dữ liệu ngày", MsgBox.CanhBao);
            // Ngày hiện tại thêm 1 tuần(7 ngày)
            if (check) {
                return new Date(day + new java.util.Date().getTime());
            } else {
                return null;
            }
        }
    }
}
