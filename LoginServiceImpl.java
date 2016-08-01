package com.niit.backendproject.service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.backendproject.dao.LoginDAO;
	import com.niit.backendproject.model.Login;

	@Service
	@Transactional
	public class LoginServiceImpl implements LoginService {

		@Autowired
		private LoginDAO ld;
		
		@Override
		public boolean checkUser(Login u) {
			boolean b=false;
			b=ld.checkUser(u);
			if(b==true){
				b=true;
			}
			return b;
		}


	}


