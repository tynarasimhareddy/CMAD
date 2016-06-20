package com.cisco.cmad.blog.dao.mongo.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.cisco.cmad.blog.dao.mongo.PostsDAO;
import com.cisco.cmad.blog.model.mongo.BlogUsers;
import com.cisco.cmad.blog.model.mongo.Posts;

public class PostsDAOImpl implements PostsDAO {

	public void addPost(Posts post) {
		Datastore ds = ServicesFactory.getMongoDB();
		ds.save(post);

	}

	public List<Posts> getPosts(String userName) {
		List<Posts> result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		result = ds.createQuery(Posts.class).filter("author ==", userName).asList();
		return result;
	}
	
	public Posts getPost(String permalink){
		Posts result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		
		Query<Posts> queryDs = ds.createQuery(Posts.class).filter("permalink ==", permalink);
		result = queryDs.get();
		return result;
	}

	public List<Posts> getAllPosts() {
		List<Posts> result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		result = ds.find(Posts.class).asList();
		return result;
	}
	
	public List<Posts> searchByTitle(String title) {
		System.out.println("NTY searching for "+title);
		List<Posts> result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		result = ds.createQuery(Posts.class).field("title").containsIgnoreCase(title).asList();
		System.out.println("NTY restult  = "+result);
		return result;
	}
	

}
