package com.adsun.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adsun.server.entity.User;
import com.adsun.server.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
	@Autowired
	private UserRepository repository;
	
	@Test
	public void UserRepositoryTest() {
		repository.saveAndFlush(new User());
	}
}
