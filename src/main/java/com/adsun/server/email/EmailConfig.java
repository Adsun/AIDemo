package com.adsun.server.email;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.smtp.SMTPTransport;

@ConfigurationProperties(prefix = "email")
@Component
public class EmailConfig {
	
//	@Value("${email.debug}")
	private boolean debug;

//	@Value("${email.userName}")
	private String userName;

//	@Value("${email.passWord}")
	private String passWord;

//	@Value("${email.host}")
	private String host;

//	@Value("${email.port}")
	private int port;
	
	@Resource
	private Session session;

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

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
