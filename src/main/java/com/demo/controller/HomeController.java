package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.dto.UserDto;
import com.demo.service.UserService;

@RestController
public class HomeController {

	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public User login(@RequestBody UserDto dto) {
		return userService.login(dto);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signUp")
	public UserDto signUp(@RequestBody UserDto dto1) {
		return userService.saveUser(dto1);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editUser/{id}")
	public UserDto getEditUser(@PathVariable int id) {
		return userService.editUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateUser")
	public boolean geUpdateUser(@RequestBody UserDto dto) {
		return userService.updateUser(dto);
	}
}
