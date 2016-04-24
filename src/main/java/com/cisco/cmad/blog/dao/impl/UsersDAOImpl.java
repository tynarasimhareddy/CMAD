package com.cisco.cmad.blog.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cisco.cmad.blog.dao.UsersDAO;
import com.cisco.cmad.blog.model.BlogUsers;
import com.cisco.cmad.rest.HibernateUtil;

public class UsersDAOImpl implements UsersDAO {

	public void addUser(BlogUsers user) {
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	public BlogUsers getUser(String userName) {
		Session session = HibernateUtil.currentSession();
		BlogUsers result = null;
		try{
			Criteria crit =  session.createCriteria(BlogUsers.class);
			crit.add(Restrictions.idEq(userName));
			result = (BlogUsers) crit.uniqueResult();
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}
	
	public BlogUsers validateUser(String userName, String pswd){
		BlogUsers user = getUser(userName);
		if(null != user){
			if(user.getPswd().equals(pswd)){
				return user;
			}
		}
		return null;
	}

}
