package com.cisco.cmad.blog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cisco.cmad.blog.dao.PostsDAO;
import com.cisco.cmad.blog.model.Posts;
import com.cisco.cmad.rest.HibernateUtil;

public class PostsDAOImpl implements PostsDAO {

	public void addPost(Posts post) {
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(post);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}

	}

	public List<Posts> getPosts(String userName) {
		Session session = HibernateUtil.currentSession();
		List<Posts> result = null;
		try{
			Criteria crit = session.createCriteria(Posts.class);
			crit.add(Restrictions.eq("author", userName));
			result = crit.list();
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

	public List<Posts> getAllPosts() {
		Session session = HibernateUtil.currentSession();
		List<Posts> result = null;
		try{
			result = session.createCriteria(Posts.class).list();
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

}
