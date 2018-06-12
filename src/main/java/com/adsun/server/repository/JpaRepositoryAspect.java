package com.adsun.server.repository;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adsun.server.entity.AbstractEntity;

@Component
@Aspect
public class JpaRepositoryAspect{
	@Before(value="save(entity)",argNames="entity")
	public void beforeSave(Object entity) {
		System.out.println("***************************************************");
		AbstractEntity absEntity = (AbstractEntity) entity;
		absEntity.setCreatedBy("");
		absEntity.setCreatedDatetime(new Date());
		absEntity.setUpdatedBy("");
		absEntity.setUpdatedDatetime(new Date());
		absEntity.setVersion(0L);
	}
	@Pointcut(value="execution(* org.springframework.data.jpa.repository.support.SimpleJpaRepository.save(..)) && args(entity)",argNames="entity")
	public void save(Object entity) {}
}
