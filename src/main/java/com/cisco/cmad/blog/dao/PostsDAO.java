package com.cisco.cmad.blog.dao;

import java.util.List;

import com.cisco.cmad.blog.model.Posts;

public interface PostsDAO {

	public void addPost(Posts post);
	public List<Posts> getPosts(String userName);
	public List<Posts> getAllPosts();
}
