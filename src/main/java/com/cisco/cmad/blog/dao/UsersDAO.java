package com.cisco.cmad.blog.dao;

import com.cisco.cmad.blog.model.Users;

public interface UsersDAO {

	public void addUser(Users user);
	public Users getUser(String userName);
}
