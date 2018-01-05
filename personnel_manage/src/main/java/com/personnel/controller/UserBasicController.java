package com.personnel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		Long id = (long) 1;
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		System.out.println(user.toString());	
		return "login";
	}
}
