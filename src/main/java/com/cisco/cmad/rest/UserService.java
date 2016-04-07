package com.cisco.cmad.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



@Path("/user")
public class UserService {

	static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	static SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Users> getUsers(){
		Session session = sessionFactory.openSession();
		List<Users> userList = session.createQuery("from Users").list();
		session.close();
		System.out.println("Total users are - "+userList.size());
		for(Users user : userList)
			System.out.println(user);
		return userList;
	}
}
