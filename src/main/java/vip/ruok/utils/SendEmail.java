package com.tmk.utils;
import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * @author Temuulen
 */
public class SendEmail {
    /**
     * 发送验证码
     * @param email
     *  接收邮箱
     * @param code
     *  验证码
     */
    public void send(String email, String code) {

        Properties prop = new Properties();
        //设置QQ邮件服务器
        prop.setProperty("mail.host", "smtp.qq.com");
        // 邮件发送协议
        prop.setProperty("mail.transport.protocol", "smtp");
        // 需要验证用户名密码
        prop.setProperty("mail.smtp.auth", "true");
        try {
            // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
            MailSSLSocketFactory sf = null;

            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);

            //使用JavaMail发送邮件的5个步骤

            //创建定义整个应用程序所需的环境信息的 Session 对象

            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮件用户名、授权码
                    return new PasswordAuthentication("524101765@qq.com", "oampumhfixxfbigg");
                }
            });
            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(true);

            //2、通过session得到transport对象
            Transport ts = session.getTransport();

            //3、使用邮箱的用户名和授权码连上邮件服务器
            ts.connect("smtp.qq.com", "524101765@qq.com", "oampumhfixxfbigg");

            //4、创建邮件

            //创建邮件对象
            MimeMessage message = new MimeMessage(session);
            //指明邮件的发件人
            message.setFrom(new InternetAddress("524101765@qq.com"));

            //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            //邮件的标题
            message.setSubject("【小小志的部落阁】");

            //邮件的文本内容
            message.setContent(code+"是你的验证码！欢迎注册！", "text/html;charset=UTF-8");

            //5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());

            ts.close();
        } catch (GeneralSecurityException | MessagingException e) {
            e.printStackTrace();
        }
    }
}