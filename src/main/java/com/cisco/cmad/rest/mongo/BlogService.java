package com.cisco.cmad.rest.mongo;

import java.util.Date;
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

import com.cisco.cmad.blog.dao.mongo.PostsDAO;
import com.cisco.cmad.blog.dao.mongo.UsersDAO;
import com.cisco.cmad.blog.dao.mongo.impl.PostsDAOImpl;
import com.cisco.cmad.blog.dao.mongo.impl.UsersDAOImpl;
import com.cisco.cmad.blog.model.mongo.BlogUsers;
import com.cisco.cmad.blog.model.mongo.Posts;

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
	public String createUser(BlogUsers user){
		try{
			if(null == usersDao.getUser(user.getUserName())){
				usersDao.addUser(user);
				return "Added the User Successfully";
			}else{
				return "Failed to add the User. User is already exist in the system";
			}
			
			
		}catch(Exception e){
			return "Failed to add the User. "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/user/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public BlogUsers getUser(@PathParam("userName") String userName){
		return usersDao.getUser(userName);
	}
	
	@POST
	@Path("/login")
	public String login(BlogUsers user){
		System.out.println("UserName ="+user.getUserName()+", password="+user.getPswd());
		if(null == usersDao.validateUser(user.getUserName(), user.getPswd())){
			return "Failed to Login. Invalid access details";
		}
		return "Logged in succesfully";
	}
	
	@POST
	@Path("/newPost")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPost(Posts post){
		if(null != usersDao.getUser(post.getAuthor())){
			post.setDate(new Date(System.currentTimeMillis()).toString());
			postsDao.addPost(post);
			return "Added the post Successfully";
		}else{
			System.out.println("Unknown author - "+post.getAuthor());
			return "Failed to add Post. Unknown author - "+post.getAuthor();
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
