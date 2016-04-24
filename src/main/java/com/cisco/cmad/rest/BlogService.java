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
import javax.ws.rs.core.Response;

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
	@Path("/user/{userName}")
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
	public Response addPost(Posts post){
		if(null != usersDao.getUser(post.getAuthor())){
			postsDao.addPost(post);
			return Response.ok("Added the post Successfully").build();
		}else{
			System.out.println("Unknown author - "+post.getAuthor());
			return Response.ok("Failed to add Post. Unknown author - "+post.getAuthor()).build();
		}
	}
	
	@GET
	@Path("/viewPosts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Posts> getAllPosts(){
		return postsDao.getAllPosts();
	}
	
	@GET
	@Path("/post/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Posts getPost(@PathParam("postId") Integer postId){
		
		return postsDao.getPost(postId); 
	}
	
	@GET
	@Path("/posts/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Posts> getPosts(@PathParam("userName") String userName){
		
		return postsDao.getPosts(userName);
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
