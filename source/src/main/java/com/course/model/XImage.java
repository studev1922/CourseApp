/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.model;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author abc
 */
public class XImage {

    // Lấy ảnh có sẵn đường dẫn
    public static ImageIcon getIcon(String path) {
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage() == null ? null : icon;
    }

    // Lấy ảnh chọn theo đường dẫn
    public static ImageIcon getIconSelection(Component parent) {
        return new ImageIcon(ChooserFile(parent).getAbsolutePath());
    }

    // Lấy đường dẫn tới file
    public static File ChooserFile(Component Parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("PNG, JPG", "jpg", "png"));
        if (chooser.showOpenDialog(Parent) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        System.out.println("Hủy chọn!");
        return null;
    }

    // Lưu ảnh vào project
    public static boolean SaveIcon(File src) {
        if (src == null) {
            return false;
        }
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Files.copy(
                    Paths.get(src.getAbsolutePath()),
                    Paths.get(dst.getAbsolutePath()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // phương thức xóa file
    public static boolean DeleteIcon(File file) {
        try {
            file = file.getAbsoluteFile();
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
