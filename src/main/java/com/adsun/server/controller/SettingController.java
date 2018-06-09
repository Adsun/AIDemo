package com.adsun.server.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adsun.server.email.EmailServer;

@RestController
@RequestMapping("/set")
public class SettingController {
	@Autowired
	private EmailServer emailServer;
	
	@GetMapping("/email")
	public void sendEmailTest() {
		try {
			emailServer.sendEmail("test", "emailtest", "1216319784@qq.com");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
