package com.cisco.cmad.blog.model.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("users")
@Indexes(
			@Index(value = "userName", fields = @Field("userName"))
		)
public class BlogUsers {
	
	@Id
	private ObjectId id;
	private String userName  = null;
	private String emailId  = null;
	private String pswd  = null;
	
	public BlogUsers() {
		// TODO Auto-generated constructor stub
	}
	public BlogUsers(String userName, String emailId, String pswd) {
		this.userName = userName;
		this.emailId = emailId;
		this.pswd = pswd;
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
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
