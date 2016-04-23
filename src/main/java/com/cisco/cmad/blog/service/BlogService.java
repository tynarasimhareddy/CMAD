package com.cisco.cmad.blog.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cisco.cmad.blog.dao.PostsDAO;
import com.cisco.cmad.blog.dao.UsersDAO;
import com.cisco.cmad.blog.dao.impl.PostsDAOImpl;
import com.cisco.cmad.blog.dao.impl.UsersDAOImpl;
import com.cisco.cmad.blog.model.Users;

@Path("/blog")
public class BlogService {

	private UsersDAO usersDao = null;
	private PostsDAO postsDao = null;
	BlogService(){
		usersDao = new UsersDAOImpl();
		postsDao = new PostsDAOImpl();
	}

	BlogService(UsersDAO usersDao, PostsDAO postsDao){
		this.usersDao = usersDao;
		this.postsDao = postsDao;
	}

	@POST
	@Path("/signUp")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(Users user){
		usersDao.addUser(user);
	}
	
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Users getUser(@PathParam("userName") String userName){
		return usersDao.getUser(userName);
	}
	
	
	
	/**
	 * @param usersDao the usersDao to set
	 */
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}


	/**
	 * @param postsDao the postsDao to set
	 */
	public void setPostsDao(PostsDAO postsDao) {
		this.postsDao = postsDao;
	}
}
