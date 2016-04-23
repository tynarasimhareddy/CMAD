package com.cisco.cmad.blog.model;

import java.util.Date;

public class Posts {

	Integer postId = null;
	String title = null;
	String body = null;
	Date date = null;
	String author = null;
	
	public Posts(Integer postId, String title, String body, Date date, String author) {
		this(postId, title, body, author);
		this.date = date;
		
	}
	
	public Posts(Integer postId, String title, String body, String author) {
		this.postId = postId;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
