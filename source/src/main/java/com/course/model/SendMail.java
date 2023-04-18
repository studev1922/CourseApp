package com.course.model;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * config google email: https://myaccount.google.com/security
 * S1: turn on: 2-Step verification
 * S2: forward to https://myaccount.google.com/apppasswords
 *     - mail & your device > generate
 *     - copy pass generated example: "gicawozhnwuakhys"
 * S3: add your mail and app-password generated
 */
public class SendMail {

    private final String user;
    private final String pass;
    private MimeMessage m;
    private File file;

    public SendMail() {
        this.user = "[your mail]";
        this.pass = "[app - password]";
    }

    public SendMail(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setFile(File file) {
        this.file = file;
    }

    // Setup cấu hình và nội dung
    public boolean setUp(String toEmail, String subject, String mesage) {
        try {
            toEmail = toEmail.replace(" ", "").replace("\n", "");
            m = new MimeMessage(this.createSource());
            m.setFrom(new InternetAddress(user));
            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            m.setSubject(subject);
            m.setText(mesage);

            this.SetUpFile();
            return true;
        } catch (MessagingException e) {
            System.out.println("At here: " + e.getMessage());
            return false;
        }
    }

    // Gửi thông tin eamil
    public boolean sendingEmail() {
        try {
            Transport.send(m, user, pass);
            return true;
        } catch (MessagingException ex) {
            System.out.println("Gui that bai: " + ex.getMessage());
            return false;
        }
    }

    // CÁC PHƯƠNG THỨC HỖ TRỢ SẮP ĐẶT NỘI DUNG EMAIL
    // Tạo Properties port gửi email
    private Properties createProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);
        return p;
    }

    // Tạo phiên gửi thông tin email
    private javax.mail.Session createSource() {
        return javax.mail.Session.getInstance(
                createProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPassAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
    }

    // Thêm file vào nội dung
    private void SetUpFile() {
        if (file != null) {
            try {
                Multipart multipart = new MimeMultipart(); // Nhiều nội dung

                // Thêm vào nội "dung tin" nhắn email
                MimeBodyPart mesage = new MimeBodyPart();
                mesage.setDataHandler(m.getDataHandler());

                // Thêm vào "nội dung file" vào email
                MimeBodyPart fileBody = new MimeBodyPart();
                fileBody.setFileName(file.getName());
                fileBody.setDataHandler(new DataHandler(new FileDataSource(file)));

                multipart.addBodyPart(mesage); // Thêm tin nhắn > nội dung
                multipart.addBodyPart(fileBody); // Thêm file > nội dung

                m.setContent(multipart); // Thay nội dung
            } catch (MessagingException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
