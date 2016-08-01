package com.niit.backendproject.dao;


	

	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;
	 


import com.niit.backendproject.model.Login;

	@Repository("loginDAO")
	@Transactional
	public class LoginDAOImpl implements LoginDAO {

		@Autowired
		private SessionFactory sessionFactory;
		@Override
		public boolean checkUser(Login u) {
			boolean isvaliduser=false;
			
			Query q=sessionFactory.openSession().createQuery("from Login where name= '"+u.getUser_name()+"' and password='"+u.getUser_password()+"'");
			List<Login> ul= q.list();
			int s=ul.size();
			if(s==1)
			{
				isvaliduser=true;
			}
			
			return isvaliduser;
		}
		
		public void saveOrUpdate(Login u) {
			sessionFactory.getCurrentSession().saveOrUpdate(u);

		}


	}


