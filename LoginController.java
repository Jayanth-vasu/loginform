package com.niit.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backendproject.model.Login;
import com.niit.backendproject.service.LoginService;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@Autowired
	LoginService ls;

	@Autowired
	Login u;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginuser(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		boolean isvaliduser = false;
		u.setUser_name(name);
		u.setUser_password(pwd);
		isvaliduser = ls.checkUser(u);
		ModelAndView mv = null;
		if (isvaliduser == true) {
			 mv = new ModelAndView("success");
			mv.addObject("msg", "Welcome");
			mv.addObject("name", u.getUser_name());
		}
		return mv;
	}

}
