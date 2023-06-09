/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.views;

import com.course.dao.NhanVienDAO;
import com.course.entites.NhanVien;
import com.course.model.Author;
import com.course.model.MsgBox;
import com.course.model.Util;

/**
 *
 * @author abc
 */
public final class DangNhapJDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form DangNhapJDialog
     *
     * @param parent
     * @param modal
     */
    java.awt.Frame parent = null;
    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.parent = parent;
        this.toFront();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnh = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        bntDangNhap = new javax.swing.JButton();
        bntketThuc = new javax.swing.JButton();
        bntQuenMK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("EduSys - Đăng nhập");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icons/Poly.png"))); // NOI18N

        lblMaNV.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lblMaNV.setText("Tên đăng nhập");

        lblMatKhau.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lblMatKhau.setText("Mật khẩu");

        txtMaNV.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        txtMaNV.setText("admin");

        txtMatKhau.setText("songlong");

        bntDangNhap.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bntDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icons/key.png"))); // NOI18N
        bntDangNhap.setText("Đăng nhập");
        bntDangNhap.setBorderPainted(false);
        bntDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntDangNhap.setVerifyInputWhenFocusTarget(false);
        bntDangNhap.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bntDangNhap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDangNhapActionPerformed(evt);
            }
        });

        bntketThuc.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bntketThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icons/exit.png"))); // NOI18N
        bntketThuc.setText("Kết thúc");
        bntketThuc.setBorderPainted(false);
        bntketThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntketThuc.setVerifyInputWhenFocusTarget(false);
        bntketThuc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bntketThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntketThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntketThucActionPerformed(evt);
            }
        });

        bntQuenMK.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bntQuenMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icons/refresh.png"))); // NOI18N
        bntQuenMK.setText("Quên MK");
        bntQuenMK.setBorderPainted(false);
        bntQuenMK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntQuenMK.setVerifyInputWhenFocusTarget(false);
        bntQuenMK.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bntQuenMK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntQuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntQuenMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaNV)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bntDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntketThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMatKhau))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntketThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntQuenMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntketThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntketThucActionPerformed
        // Thoát chương trình (tiêu đề, vị trí)
        Util.ExitForm(this.getTitle(), this);
    }//GEN-LAST:event_bntketThucActionPerformed

    @SuppressWarnings("deprecation")
    private void bntDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDangNhapActionPerformed
        String user = this.txtMaNV.getText();
        String pass = this.txtMatKhau.getText();
        NhanVien nv = new NhanVienDAO().SelectById(user);
        if (nv != null) {
            if (pass.equals(nv.getMatKhau())) {
                Author.user = nv; // Lưu nhân viên (com.sample.model)
                this.dispose();
                new MainJFrame().setVisible(true);
            } else {
                MsgBox.alert(this, "Sai mật khẩu!", this.getTitle(), MsgBox.CanhBao);
            }
        } else {
            MsgBox.alert(this, "Sai tên đăng nhập!", this.getTitle(), MsgBox.CanhBao);
        }
    }//GEN-LAST:event_bntDangNhapActionPerformed

    private void bntQuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntQuenMKActionPerformed
        new QuenMatKhauJDialog(parent, true).setVisible(true);
    }//GEN-LAST:event_bntQuenMKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntDangNhap;
    private javax.swing.JButton bntQuenMK;
    private javax.swing.JButton bntketThuc;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
