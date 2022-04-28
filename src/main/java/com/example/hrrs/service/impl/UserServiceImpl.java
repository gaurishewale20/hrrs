package com.example.hrrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrrs.service.UserService;
import com.example.hrrs.controller.bean.User;
import com.example.hrrs.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	
	
	@Override
	public User getUserByUserId(String userId){
		User user = userDao.getUserById(userId);
		return user;
	}

	public User getUserById(Long id) {
		User user = userDao.getUserByIdNo(id);
		return user;
	}
	@Override 
	public int createNewUser(User user) {
		return userDao.createNewUser(user);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

}
