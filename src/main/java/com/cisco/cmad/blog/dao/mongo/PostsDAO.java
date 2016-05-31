package com.cisco.cmad.blog.dao.mongo;

import java.util.List;

import com.cisco.cmad.blog.model.mongo.Posts;

public interface PostsDAO {

	public void addPost(Posts post);
	public List<Posts> getPosts(String userName);
	public List<Posts> getAllPosts();
	public Posts getPost(int postId);
}
