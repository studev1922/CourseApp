package com.course.model;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * @author abc
 */
public class MsgBox {

    /**
     * LỚP THÔNG BÁO TRẠNG THÁI
     * 
     * @parent vị trí theo form truyền vào
     * @message nội dung thông báo
     * @title tiêu đề nội dung thông báo
     * @type các dạng icon thông báo
     */
    public static int KhongCo = -1;
    public static int BaoLoi = 0;
    public static int ThongTin = 1;
    public static int CanhBao = 2;
    public static int CauHoi = 3;
    
    public static void alert(Component parent, Object message, String title, int type) {
        JOptionPane.showMessageDialog(parent, message, title, type);
    }

    public static int confirm(Component parent, Object message, String title, int confirmType) {
        return JOptionPane.showConfirmDialog(parent, message, title, confirmType);
    }

    public static String prompt(Component parent, Object message, String title, int type) {
        return JOptionPane.showInputDialog(parent, message, title, type);
    }

}
