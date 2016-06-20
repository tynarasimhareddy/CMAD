package com.cisco.cmad.blog.model.mongo;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("posts")
@Indexes(
		@Index(value = "title", fields = @Field("title"))
	)
public class Posts {

	@Id
	private ObjectId id;
	String title = "";
	String body = "";
	String date = "";
	String author = "";
	String permalink = "";
	
	public Posts() {
		// TODO Auto-generated constructor stub
	}
	
	public Posts(String title, String body, String date, String author, String permalink) {
		this(title, body, author, permalink);
		this.date = date;
		
	}
	
	public Posts(String title, String body, String author, String permalink) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.permalink = permalink;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Override
	public String toString(){
		return "title : "+title+", author : "+author+", date : "+date+", permalink = "+permalink+", body : "+body;
	}
	
	
}
