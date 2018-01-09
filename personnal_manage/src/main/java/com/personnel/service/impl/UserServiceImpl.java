package com.personnel.service.impl;

import java.util.List;

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

	@Override
	public User getUserByPhone(String phone) {
		return userMapper.selectByPhone(phone);
	}

	@Override
	public List<User> getUserListAll() {
		return userMapper.getUserListAll();
	}

	@Override
	public int addRole(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int deleteRole(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateRole(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> getUserListByKey(String key) {
		return userMapper.getUserListByKey(key);
	}
	
}
