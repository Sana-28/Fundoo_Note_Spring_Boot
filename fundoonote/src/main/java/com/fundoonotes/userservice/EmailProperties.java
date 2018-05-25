<<<<<<< HEAD
=======

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
package com.fundoonotes.userservice;

import org.springframework.stereotype.Component;

@Component
public class EmailProperties {
	private String email;
	private String password;
	private String emailAddress;
	private String frontEndHost;
<<<<<<< HEAD
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFrontEndHost() {
		return frontEndHost;
	}
	public void setFrontEndHost(String frontEndHost) {
		this.frontEndHost = frontEndHost;
=======

	public String getFrontEndHost() {
		return frontEndHost;
	}

	public void setFrontEndHost(String frontEndHost) {
		this.frontEndHost = frontEndHost;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "EmailProperties [frontEndHost=" + frontEndHost + ",email=" + email + ", password=" + password + ", emailAddress=" + emailAddress + "]";
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	}

}
