package com.personnel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public int login(String phone,String password,HttpServletRequest request) {
		int flag = 0;
		User user = userService.getUserByPhone(phone);
		System.out.println(user.toString());	
		if(user != null) {														//如果存在该用户
			if( user.getPassword().equals(ToMD5.md5Password(password)) ) {		//如果该密码正确
				flag = 1;
				HttpSession session = request.getSession(true);					//创建登录用户的session
				session.setAttribute("user", user);								
			}
			else {																//密码不正确
				flag = 2;
			}
		}
		return flag;	
	}
}
