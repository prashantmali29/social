package com.pack.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.demo.config.AppConfig;
import com.demo.domain.User;
import com.demo.dto.UserDto;
import com.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class TestDemo {

	@Autowired
	UserService userService;

	@Test
	public void loginTest() {
		UserDto dto = new UserDto();
		dto.setUserName("MMMMMMMMMMMMMM");
		dto.setPassword("1234");
		User user = userService.login(dto);
		assertNotNull("is not null", user);
	}

	@Test
	public void getAllUserTest() {
		List<User> user = userService.getAllUsers();
		assertNotNull("is not null", user);
	}

	@Test
	public void editUserTest() {
		int id = 3;
		UserDto dto = userService.editUser(id);
		assertNotNull(dto);
	}
	
	@Test
	public void updateUserTest(){
		UserDto dto = new UserDto();
		dto.setUserName("MMMMMMMMMMMMMM");
		dto.setPassword("1234");
		dto.setId(9);
	   boolean flag =	userService.updateUser(dto);
	   
	   assertTrue(flag);
	}
	

}
