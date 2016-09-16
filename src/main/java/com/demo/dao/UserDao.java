package com.demo.dao;



import java.util.List;

import com.demo.domain.User;
import com.demo.dto.UserDto;

public interface UserDao {
	UserDto saveUser(UserDto userDto);

	User login(UserDto dto);

	List<User> getAllUsers();

}
