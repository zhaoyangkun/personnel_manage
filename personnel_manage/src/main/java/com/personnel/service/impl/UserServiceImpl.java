package com.personnel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.UserMapper;
import com.personnel.entity.User;
import com.personnel.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	UserMapper userMapper;
	
	@Override
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
}
