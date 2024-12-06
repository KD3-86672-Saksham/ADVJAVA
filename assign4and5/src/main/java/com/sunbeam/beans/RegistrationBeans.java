package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBeans {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private int count;
	
	public RegistrationBeans(String firstName, String lastName, String email, String password, String dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public RegistrationBeans() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void saveUser() {
		Date d = Date.valueOf(dob);
		try(UserDao userDao = new UserDaoImpl()){
			User u = new User(0,firstName,lastName,email,password,d,0,"voter");
			count = userDao.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
