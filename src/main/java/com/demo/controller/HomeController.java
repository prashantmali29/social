package com.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.dto.UserDto;


@RestController
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	
	 @RequestMapping(method = RequestMethod.POST, value = "/login")
	 public @ResponseBody User login(@RequestBody UserDto dto){
		
		 User user = userDao.login(dto);
		 return  user;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/signUp")
	 @ResponseBody
	 public UserDto signUp(@RequestBody UserDto dto1){
		 return userDao.saveUser(dto1);
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/getAllUsers")
	 @ResponseBody
	 public List<User> getAllUsers(){
		 return userDao.getAllUsers();
	 }
	
}
