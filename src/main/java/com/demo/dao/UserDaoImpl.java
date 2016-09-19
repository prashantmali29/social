package com.demo.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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
		                    criteria.setProjection(Projections.projectionList()
		                    		.add(Projections.property("firstName"),"firstName")
		                    		.add(Projections.property("userName"),"userName")
		                    		.add(Projections.property("id"),"id")
		                    		.add(Projections.property("lastName"),"lastName")
		                    		.add(Projections.property("email"),"email")
		                    		);
		@SuppressWarnings("unchecked")
		List<User> userList = criteria.setResultTransformer(Transformers.aliasToBean(UserDto.class)).list();
		return userList;
	}

	@Override
	@Transactional
	public UserDto editUser(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", userId));
        criteria.setProjection(Projections.projectionList()
        		.add(Projections.property("firstName"),"firstName")
        		.add(Projections.property("userName"),"userName")
        		.add(Projections.property("id"),"id")
        		.add(Projections.property("lastName"),"lastName")
        		.add(Projections.property("email"),"email")
        		.add(Projections.property("city"),"city")
        		.add(Projections.property("password"),"password")
        		);
       UserDto userDto = (UserDto) criteria.setResultTransformer(Transformers.aliasToBean(UserDto.class)).uniqueResult();
       return userDto; 		
        		
	}

	@Override
	@Transactional
	public boolean updateUser(UserDto dto) {
		User user = new User(dto.getId(),dto.getFirstName(),dto.getLastName(),dto.getCity(),dto.getEmail(),dto.getUserName(),dto.getPassword());
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

}
