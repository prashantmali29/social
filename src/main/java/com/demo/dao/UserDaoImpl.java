package com.demo.dao;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.User;
import com.demo.dto.UserDto;

@Repository
public class UserDaoImpl  implements UserDao {
	
	 @Autowired
	private SessionFactory sessionFactory;
 
	 @Transactional
	public void saveUser(UserDto userDto) {
		 
		 System.out.println("in save user impl");
     Session session = sessionFactory.getCurrentSession();
     Transaction tx = session.beginTransaction();
     User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getAddress());
     session.save(user);
     tx.commit();
     
		
	}

}
