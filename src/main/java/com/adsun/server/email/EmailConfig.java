package com.adsun.server.email;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.smtp.SMTPTransport;

@ConfigurationProperties(prefix = "email")
public class EmailConfig {
	@Value("${debug}")
	private boolean debug;

	@Value("${userName}")
	private String userName;

	@Value("${passWord}")
	private String passWord;

	@Value("${host}")
	private String host;

	@Value("${port}")
	private int port;
	
	@Autowired
	private Session session;

	/**
	 * 配置邮件发送器
	 * 
	 * @return
	 * @throws MessagingException
	 */
	@Bean("transport")
	public SMTPTransport transport() {
		
		SMTPTransport transport = new SMTPSSLTransport(session, null);
		try {
			transport.connect(host, port, userName, passWord);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return transport;
	}
	
	@Bean("session")
	public Session session() {
		Properties props = System.getProperties();
		props.setProperty("mail.smtps.auth", "true"); // 需要请求认证
		props.setProperty("mail.smtps.ehlo", "true");
		Session session = Session.getInstance(props);
		session.setDebug(debug); // 设置为debug模式, 可以查看详细的发送 log
		return session;
	}

}
