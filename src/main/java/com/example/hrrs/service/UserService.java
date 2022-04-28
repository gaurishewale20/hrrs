package com.example.hrrs.service;

import java.util.List;

import com.example.hrrs.controller.bean.User;

public interface UserService {
	
	User getUserByUserId(String userId);
	User getUserById(Long id);
	int createNewUser(User user);
	List<User> getAllUsers();
}
