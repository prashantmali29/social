package com.demo.service;

import java.util.List;

import com.demo.domain.User;
import com.demo.dto.UserDto;

public interface UserService {

	UserDto saveUser(UserDto userDto);

	User login(UserDto dto);

	List<User> getAllUsers();

	UserDto editUser(int id);

	boolean updateUser(UserDto dto);

}
