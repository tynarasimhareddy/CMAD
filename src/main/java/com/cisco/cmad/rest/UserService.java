package com.cisco.cmad.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;



@Path("/user")
public class UserService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Users> getUsers(){
		Session session = HibernateUtil.currentSession();
		List<Users> userList = null;
		try {
			userList = session.createCriteria(Users.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
		System.out.println("Total users are - "+userList.size());
		for(Users user : userList)
			System.out.println(user);
		return userList;
	}
}
