package com.demo.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	public UserDto saveUser(UserDto userDto) {
     System.out.println("in save user impl");
     Session session = sessionFactory.getCurrentSession();
     User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getCity(),
    		              userDto.getEmail(),userDto.getUserName(),userDto.getPassword());
     session.save(user);
     return userDto;
		
	}

	@Override
	@Transactional
	public User login(UserDto dto) {
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		                     criteria.add(Restrictions.eq("userName", dto.getUserName()));
		                     criteria.add(Restrictions.eq("password", dto.getPassword()));
		       User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		                    /*criteria.setProjection(Projections.projectionList().add(Projections.property("firstName"),"firstName")
		                    		.add(Projections.property("id"),"id")
		                    		.add(Projections.property("lastName"),"lastName")
		                    		.add(Projections.property("email"),"email")
		                    		);*/
		                    
		List<User> userList = criteria.list();
		return userList;
	}

}
