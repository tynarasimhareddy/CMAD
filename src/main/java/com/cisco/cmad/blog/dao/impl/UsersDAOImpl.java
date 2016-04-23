package com.cisco.cmad.blog.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cisco.cmad.blog.dao.UsersDAO;
import com.cisco.cmad.blog.model.Users;
import com.cisco.cmad.rest.HibernateUtil;

public class UsersDAOImpl implements UsersDAO {

	public void addUser(Users user) {
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	public Users getUser(String userName) {
		Session session = HibernateUtil.currentSession();
		Users result = null;
		try{
			Criteria crit =  session.createCriteria(Users.class);
			crit.add(Restrictions.idEq(userName));
			result = (Users) crit.uniqueResult();
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

}
