package com.demo.service;




import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Service("userDetailsService")
public class UserDetailsServiceImpl extends JdbcUserDetailsManager {
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails ud = super.loadUserByUsername(username);
       // return new MyUser(ud.getUsername(), ud.getPassword(), ud.isEnabled(), ud.isAccountNonExpired(), ud.isCredentialsNonExpired(), ud.isAccountNonLocked(), ud.getAuthorities());
        return ud;
    }
    
    
    private DataSource dataSource(){
    	
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
    	return dataSource;
    	
    }
    
   
    
    
    
    
    
    
        

   

}