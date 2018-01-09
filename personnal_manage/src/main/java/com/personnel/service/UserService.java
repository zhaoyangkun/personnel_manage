package com.personnel.service;

import java.util.List;

import com.personnel.entity.User;

public interface UserService {
	User getUserById(Long id);
	
	User getUserByPhone(String phone);
	
	List<User> getUserListAll();
	
	int addRole(User user);
	
	int deleteRole(Long id);
	
	int updateRole(User user);
	
	List<User> getUserListByKey(String key);
}
