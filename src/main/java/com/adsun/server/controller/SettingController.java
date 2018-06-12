package com.adsun.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adsun.server.email.EmailServer;
import com.adsun.server.entity.User;
import com.adsun.server.repository.UserRepository;

@RestController
@RequestMapping("/set")
public class SettingController {
	@Autowired
	private EmailServer emailServer;
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/email")
	public void test() {
		/*try {
			emailServer.sendEmail("test", "emailtest", "1216319784@qq.com");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
		repository.save(new User());
	}
}
