package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public boolean checkUser(User user) {
		return userDao.checkUser(user);
	}

}
