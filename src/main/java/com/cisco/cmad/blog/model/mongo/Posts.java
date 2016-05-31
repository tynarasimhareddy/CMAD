package com.cisco.cmad.blog.model.mongo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("posts")
public class Posts {

	@Id
	private ObjectId id;
	String title = "";
	String body = "";
	Date date ;
	String author = "";
	
	public Posts() {
		// TODO Auto-generated constructor stub
	}
	
	public Posts(String title, String body, Date date, String author) {
		this(title, body, author);
		this.date = date;
		
	}
	
	public Posts(String title, String body, String author) {
		this.title = title;
		this.body = body;
		this.author = author;
	}

	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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
	
	@Override
	public String toString(){
		return "title : "+title+", author : "+author+", date : "+date+", body : "+body;
	}
	
	
}
