package com.adsun.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User extends AbstractEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int userId;
	private String userName;
	
	@Override
	public String toString() {
		return String.format("User:[userId='%s',userName='%s']", userId, userName);
	}
}
