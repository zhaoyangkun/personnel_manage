package com.personnel.service;

import com.personnel.entity.User;

public interface UserService {
	User getUserById(Long id);
	User getUserByPhone(int phone);
}
