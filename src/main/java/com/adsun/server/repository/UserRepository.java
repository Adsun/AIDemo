package com.adsun.server.repository;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;

import com.adsun.server.entity.User;
@Aspect
public interface UserRepository extends JpaRepository<User, Long> {

}
