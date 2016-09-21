package com.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public UserDto saveUser(UserDto userDto) {
	return userDao.saveUser(userDto);
	}

	@Override
	public User login(UserDto dto) {
		return userDao.login(dto);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public UserDto editUser(int id) {
		return userDao.editUser(id);
	}

	@Override
	public boolean updateUser(UserDto dto) {
		return userDao.updateUser(dto);
	}

}
