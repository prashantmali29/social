package com.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.UserDao;
import com.demo.dto.UserDto;


@RestController
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	
	 @RequestMapping(method = RequestMethod.POST, value = "/login")
	 @ResponseBody
	 public UserDto login(@RequestBody UserDto dto1){
		 UserDto dto = new UserDto();
		 dto.setFirstName("prashant");
		 dto.setLastName("Mali");
		 dto.setAddress("Sangali");
		 userDao.saveUser(dto);
		 return dto;
		 
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/signUp")
	 @ResponseBody
	 public UserDto signUp(@RequestBody UserDto dto1){
		 
		 System.out.println(dto1.getFirstName());
		 
		 UserDto dto = new UserDto();
		 dto.setFirstName("prashant");
		 dto.setLastName("Mali");
		 dto.setAddress("Sangali");
		 userDao.saveUser(dto);
		 return dto1;
		 
	 }
	 
	 
	
}
