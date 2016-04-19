package com.cisco.cmad.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cisco.cmad.dao.UsersDao;




@Path("/user")
public class UserService {
	
	UsersDao dao = new UsersDao();
	
	public void setUserDao(UsersDao dao){
		this.dao = dao;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Users> getUsers(){
		List<Users> userList = dao.getUsers();
		System.out.println("Total users are - "+userList.size());
		for(Users user : userList)
			System.out.println(user);
		return userList;
	}
	
	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public Users getUser(@PathParam("param") Integer id) {
		return dao.getUser(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//public void createUser(@FormParam("name") String name,@FormParam("age") Integer age,@FormParam("emailId") String emailId){
	public void createUser(Users u){
		System.out.println("Creating user: "+u.getName()+" Age: "+u.getAge());
		dao.createUser(u);
	}
	
	@DELETE
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public boolean deleteUser(@PathParam("param") Integer id) {
		System.out.println("Deleting user: "+id);
		return dao.deleteUser(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//public void updateUser(@FormParam("id") Integer id, @FormParam("name") String name,@FormParam("age") Integer age,@FormParam("emailId") String emailId){
	public void updateUser(Users u){
		dao.updateUser(u);
	}
	
	public void clearAllUsers(){
		System.out.println("NTY executing test case - clearAllUsers");
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List<Users> userList = session.createQuery("from Users").list();
		for(Users user : userList)
			session.delete(user);
		tx.commit();
	}
	
	public void addUser(){
		System.out.println("NTY executing test case - addUser");
		System.out.println("Dummy check-in");
		Users user = new Users();
		user.setName("T Y Narasimha Reddy");
		user.setAge(27);
		user.setEmailId("nty@cisco.com");
		user.setJoinDate(new Date());
		user.setPassword("tnrTNR123#");
		user.setState("AP");
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
}
