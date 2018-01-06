package com.personnel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.personnel.entity.User;
import com.personnel.service.UserService;
import com.personnel.utils.ToMD5;

@Controller
@RequestMapping("/basic")
public class UserBasicController {
	@Autowired UserService userService;
	
	@RequestMapping("/loginDisp")
	public String loginDisp(Model model) {
		return "login";
	}
	
	@RequestMapping("/deskTop")
	public String deskTop() {
		return "welcome";
	}
	
	@RequestMapping("/index")
	public String indexDisp() {
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(String phone,String password) {
		int flag = 0;
		System.out.println(phone + " " + password);
		User user = userService.getUserByPhone(phone);
		System.out.println(user.toString());	
		if(user != null) {
			if( user.getPassword().equals(ToMD5.md5Password(password)) ) {
				flag=1;
			}
			else {
				flag=2;
			}
		}
		return flag;	
	}
}
