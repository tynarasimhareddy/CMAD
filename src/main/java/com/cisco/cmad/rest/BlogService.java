package com.cisco.cmad.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cisco.cmad.blog.dao.PostsDAO;
import com.cisco.cmad.blog.dao.UsersDAO;
import com.cisco.cmad.blog.dao.impl.PostsDAOImpl;
import com.cisco.cmad.blog.dao.impl.UsersDAOImpl;
import com.cisco.cmad.blog.model.BlogUsers;
import com.cisco.cmad.blog.model.Posts;

@Path("/blog")
public class BlogService {

	private UsersDAO usersDao = null;
	private PostsDAO postsDao = null;
	public BlogService(){
		usersDao = new UsersDAOImpl();
		postsDao = new PostsDAOImpl();
	}

	public BlogService(UsersDAO usersDao, PostsDAO postsDao){
		this.usersDao = usersDao;
		this.postsDao = postsDao;
	}

	@POST
	@Path("/signUp")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(BlogUsers user){
		usersDao.addUser(user);
	}
	
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public BlogUsers getUser(@PathParam("userName") String userName){
		return usersDao.getUser(userName);
	}
	
	@POST
	@Path("/login")
	public Boolean login(@QueryParam("userName")String userName, @QueryParam("password")String pswd){
		System.out.println("UserName ="+userName+", password="+pswd);
		BlogUsers user = usersDao.validateUser(userName, pswd);
		if(null == user){
			return false;
		}
		
		return true;
	}
	
	@POST
	@Path("/newPost")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPost(Posts post){
		if(null != usersDao.getUser(post.getAuthor())){
			postsDao.addPost(post);
		}else{
			System.out.println("Unknown author - "+post.getAuthor());
		}
	}
	
	@GET
	@Path("/viewPosts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Posts> getAllPosts(){
		return postsDao.getAllPosts();
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
