package com.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name ="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
    
	@Column(name = "city")
    private String city;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "userName")
    private String userName;
	
	@Column(name = "password")
    private String password;

	
	public User() {
		super();
	}

	
	//To save user
	public User(String firstName, String lastName, String city, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
  //To read user
	public User(int id, String firstName, String lastName, String city, String email, String userName, String password) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.city = city;
	this.email = email;
	this.userName = userName;
	this.password = password;
}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
