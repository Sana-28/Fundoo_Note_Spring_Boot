package com.fundoonotes.userservice;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "user", strategy = "increment")
	@GeneratedValue(generator = "user")
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private boolean isActive;
	public User() {

	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	private String randomID;
	
	public User(UserDto userDto) {
		this.setName(userDto.getName());
		this.setEmail(userDto.getEmail());
		this.setMobileNumber(userDto.getMobileNumber());
	}
	public String getRandomID() {
		return randomID;
	}

	public void setRandomID(String randomID) {
		this.randomID = randomID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
