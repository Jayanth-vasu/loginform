package com.niit.backendproject.dao;

import com.niit.backendproject.model.Login;


public interface LoginDAO {
	public boolean checkUser(Login u);

	public void saveOrUpdate(Login u);
}
