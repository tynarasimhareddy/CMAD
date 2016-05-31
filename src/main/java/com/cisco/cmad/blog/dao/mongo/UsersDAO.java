package com.cisco.cmad.blog.dao.mongo;

import com.cisco.cmad.blog.model.mongo.BlogUsers;

public interface UsersDAO {

	public void addUser(BlogUsers user);
	public BlogUsers getUser(String userName);
	public BlogUsers validateUser(String userName, String pswd);
}
