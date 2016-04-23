package com.cisco.cmad.blog.model;

public class Users {
	
	private String userName  = null;
	private String emailId  = null;
	private String pswd  = null;
	
	public Users(String userName, String emailId, String pswd) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.pswd = pswd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
}
