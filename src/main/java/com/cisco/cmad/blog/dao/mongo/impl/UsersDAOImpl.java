package com.cisco.cmad.blog.dao.mongo.impl;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.cisco.cmad.blog.dao.mongo.UsersDAO;
import com.cisco.cmad.blog.model.mongo.BlogUsers;

public class UsersDAOImpl implements UsersDAO {

	public void addUser(BlogUsers user) {
		Datastore ds = ServicesFactory.getMongoDB();
		ds.save(user);
	}

	public BlogUsers getUser(String userName) {
		BlogUsers result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		Query<BlogUsers> queryDs = ds.createQuery(BlogUsers.class);
		queryDs.field("userName").equals(userName);
		result = queryDs.get();
		return result;
	}
	
	public BlogUsers validateUser(String userName, String pswd){
		BlogUsers user = getUser(userName);
		if(null != user){
			if(user.getPswd().equals(pswd)){
				return user;
			}
		}
		return null;
	}

}
