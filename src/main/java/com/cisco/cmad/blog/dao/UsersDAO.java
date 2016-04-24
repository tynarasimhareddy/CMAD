package com.cisco.cmad.blog.dao;

import com.cisco.cmad.blog.model.BlogUsers;

public interface UsersDAO {

	public void addUser(BlogUsers user);
	public BlogUsers getUser(String userName);
	public BlogUsers validateUser(String userName, String pswd);
}
