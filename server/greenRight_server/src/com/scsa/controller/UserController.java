package com.scsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scsa.model.service.UserService;
import com.scsa.model.vo.User;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@RequestMapping("/login.do")
	public @ResponseBody boolean login(String userId, String password) {
		User user = userService.searchUser(userId);
		if (user!=null && user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	@RequestMapping("/register_user.do")
	public @ResponseBody boolean addUser(User user) {
		return userService.addUser(user);
	}
}
