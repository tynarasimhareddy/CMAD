package com.cisco.cmad.blog.dao.mongo.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;

import com.cisco.cmad.blog.dao.mongo.PostsDAO;
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
	
	public Posts getPost(int postId){
		Posts result = null;
		
		return result;
	}

	public List<Posts> getAllPosts() {
		List<Posts> result = null;
		Datastore ds = ServicesFactory.getMongoDB();
		result = ds.find(Posts.class).asList();
		return result;
	}

}
