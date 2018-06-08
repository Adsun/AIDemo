package com.adsun.server.email;

import java.util.Date;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.mail.smtp.SMTPTransport;

@Component
public class EmailServer {
	@Autowired
	private SMTPTransport transport;
	@Autowired
	private Session session;
	
	public void sendEmail(String subject, String content, String address) throws AddressException, MessagingException {
		this.sendEmail(subject, "UTF-8", content, "text/html;charset=UTF-8", new Date(), address);
	}
	
	public void sendEmail(String subject, String content, Date sendDate, String address) throws AddressException, MessagingException {
		this.sendEmail(subject, "UTF-8", content, "text/html;charset=UTF-8", sendDate, address);
	}

	public void sendEmail(String subject, String subjectCharset, String content, String contentCharset, Date sendDate, String address) throws AddressException, MessagingException {

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(transport.getLocalHost()));
		
		Address[] add = InternetAddress.parse(address);

		//  To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipients(MimeMessage.RecipientType.TO, add);

		message.setSubject(subject, subjectCharset);

		// 5. Content: 邮件正文（可以使用html标签）
		message.setContent(content, contentCharset);

		// 6. 设置发件时间
		message.setSentDate(sendDate);

		// 7. 保存设置
		message.saveChanges();
		
		transport.sendMessage(message, add);

	}
}
