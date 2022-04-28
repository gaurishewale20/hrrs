package com.example.hrrs.dao;

import java.util.List;

import com.example.hrrs.controller.bean.User;

public interface UserDao {
	User getUserById(String userId);
	User getUserByIdNo(Long id);
	int createNewUser(User user);
	List<User>getAllUsers();
}
