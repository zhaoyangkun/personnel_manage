package com.personnel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.personnel.entity.User;
import com.personnel.service.UserService;
import com.personnel.utils.Contants;

@Controller
@RequestMapping("/basic")
public class UserBasicController {
	@Autowired UserService userService;
	
	@RequestMapping("/welcome")
	public String loginDisp(Model model) {
		return "login";
	}
	
	@RequestMapping("/index")
	public String indexDisp() {
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(int phone,String password) {
		System.out.println(phone + " " + password);
		User user = userService.getUserByPhone(phone);
		System.out.println(user.toString());	
		return 0;
	}
}
