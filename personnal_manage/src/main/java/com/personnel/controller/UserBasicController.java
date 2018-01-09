package com.personnel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.personnel.entity.User;
import com.personnel.service.UserService;
import com.personnel.utils.*;

@Controller
@RequestMapping("/basic")
public class UserBasicController {
	
	@Autowired UserService userService;
	
	private String userPath = Contants.path.USERMANAGE_PATH;
	
	/***************************授权管理****************************/
	@RequestMapping("/authorityList")
	public String authorityList(Model model) {
		List<User> roleList = userService.getUserListAll();
		int totalNumber = roleList.size();
		model.addAttribute("totalNumber", totalNumber);
		model.addAttribute("roleList", roleList);
		return userPath + "authorityList";
	}
	
	@RequestMapping("/searchAuthorityList")
	public String searchAuthorityList(Model model,String key) {
		List<User> roleList = userService.getUserListByKey(key);
		int totalNumber = roleList.size();
		model.addAttribute("totalNumber", totalNumber);
		model.addAttribute("roleList", roleList);
		return userPath + "authorityList";
	}
	
	@RequestMapping("/changeAuthority")
	@ResponseBody
	public int changeAuthority(Long id) {
		System.out.println("**************** " + id);
		User user = new User();		
		user = userService.getUserById(id);
		System.out.println(user.toString());
		if(user.getpermissions() == 1 || user.getpermissions() == 2) {
			user.setpermissions(0);
		}else if(user.getpermissions() == 0) {
			user.setpermissions(2);
		}	
		return userService.updateRole(user);
	}
	
	/***************************角色管理****************************/
	@RequestMapping("/roleList")
	public String showRoleList(Model model) {
		List<User> roleList = userService.getUserListAll();
		int totalNumber = roleList.size();
		model.addAttribute("totalNumber", totalNumber);
		model.addAttribute("roleList", roleList);
		return userPath + "roleList";
	}
	
	@RequestMapping("/roleAddDisp")
	public String roleAddDisp() {
		return userPath + "roleAdd";
	}
	
	@RequestMapping("/addRole")
	@ResponseBody
	public int addRole(User user) {
		System.out.println(user.toString());
		int flag = 0;
		user.setPassword(ToMD5.md5Password(user.getPassword()));
		flag = userService.addRole(user);
		return flag;
	}
	
	@RequestMapping("/editRoleDisp")
	public String editRoleDisp(Long id,Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("role", user);
		return userPath + "roleEdit";
	}
	
	@RequestMapping("/editRole")
	@ResponseBody
	public int editRole(User user) {
		user.setPassword(ToMD5.md5Password(user.getPassword()));
		System.out.println(user.toString());
		return userService.updateRole(user);
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public int deleteRole(Long id) {
		return userService.deleteRole(id);
	}
	
	@RequestMapping("/searchRole")
	public String searchRole(String key,Model model) {
		List<User> roleList = userService.getUserListByKey(key);
		int totalNumber = roleList.size();
		model.addAttribute("totalNumber", totalNumber);
		model.addAttribute("roleList", roleList);
		return userPath + "roleList";
	}	
	
	/**************************主页显示和登录****************************/
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
			if( (user.getPassword().equals(ToMD5.md5Password(password))) && (user.getpermissions() != 0) ) { //如果该密码正确且有权限
				flag = 1;
				HttpSession session = request.getSession();					//创建登录用户的session
				session.setAttribute("user", user);								
			}
			else {																//密码不正确
				flag = 2;
			}
		}
		return flag;	
	}
	

	
}
