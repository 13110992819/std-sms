package com.std.sms.sent;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IConfigureBO;
import com.std.sms.exception.BizException;
import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 发邮箱
 * 
 * @author Administrator
 * 
 */
@Component
public class EmailSenter {
    protected static final Logger logger = LoggerFactory
        .getLogger(EmailSenter.class);

    @Autowired
    private IConfigureBO configureBO;

    public void send(String companyCode, String channel, String email,
            String captcha) throws BizException {
        if (channel.equalsIgnoreCase("QQ")) {
            this.sendByQQ(companyCode, channel, email, captcha);
        } else if (channel.equalsIgnoreCase("aliyun")) {
            this.sendByAliyun(companyCode, channel, email, captcha);
        } else {
            throw new BizException("xn709901", "邮件配置信息，channel未定义");
        }
    }

    private void sendByQQ(String companyCode, String channel, String email,
            String captcha) throws BizException {
        // 发送邮件
        try {
            // 收件人电子邮箱
            String to = email;

            // 发件人电子邮箱
            final String from = configureBO.doGetConfigure(
                companyCode + "_email", channel, "from").getValue();

            // 指定发送邮件的主机为 localhost
            String host = configureBO.doGetConfigure(companyCode + "_email",
                channel, "host").getValue();

            // 授权码
            final String password = configureBO.doGetConfigure(
                companyCode + "_email", channel, "password").getValue();

            // 邮件主题
            String subject = configureBO.doGetConfigure(companyCode + "_email",
                channel, "subject").getValue();

            // 邮件内容模板
            String content = configureBO.doGetConfigure(companyCode + "_email",
                channel, "content").getValue();
            content = String.format(content, captcha);

            // 获取系统属性
            Properties properties = System.getProperties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            // 获取默认session对象
            Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password); // 发件人邮件用户名、密码
                    }
                });

            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            message.setText(content);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception e) {
            throw new BizException("xn000000", "发送邮件异常，原因：" + e.getMessage());
        }
    }

    private void sendByAliyun(String companyCode, String channel, String email,
            String captcha) throws BizException {
        // 发送邮件
        try {
            // 收件人电子邮箱
            String to = email;

            // 发件人电子邮箱
            final String from = configureBO.doGetConfigure(
                companyCode + "_email", channel, "from").getValue();

            // 指定发送邮件的主机为 localhost
            String host = configureBO.doGetConfigure(companyCode + "_email",
                channel, "host").getValue();

            // 授权码
            final String password = configureBO.doGetConfigure(
                companyCode + "_email", channel, "password").getValue();

            // 邮件主题
            String subject = configureBO.doGetConfigure(companyCode + "_email",
                channel, "subject").getValue();

            // 邮件内容模板
            String content = configureBO.doGetConfigure(companyCode + "_email",
                channel, "content").getValue();
            content = String.format(content, captcha);

            // 获取系统属性
            Properties properties = new Properties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.auth", "true");

            // 获取默认session对象
            Session session = Session.getInstance(properties);

            Transport ts = session.getTransport();
            ts.connect(from, password);
            Message message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(
                to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            message.setText(content);

            // 发送消息
            ts.sendMessage(message, message.getAllRecipients());
            // Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (Exception e) {
            throw new BizException("xn000000", "发送邮件异常，原因：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // new Senter().send("XN1001", "CSMD",
        // "【雄牛科技】尊敬的用户,您的验证码是678987 ,请妥善保留",
        // "15088750712");
    }
}
