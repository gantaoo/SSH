package com.gt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name="user_test_ssh")
public class UserEntity {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	@Column(name="s_id", length=32)
	private String sid;
	
	@Column(length=32)
	private String password;
	
	@Column(name="user_name", length=10)
	private String username;
	 
	public String getSid() {
		return sid;
	}
 
	public void setSid(String sid) {
		this.sid = sid;
	}
	 
	public String getUsername() {
		return username;
	}
	 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}

	 
	public void setPassword(String password) {
		this.password = password;
	}



}
