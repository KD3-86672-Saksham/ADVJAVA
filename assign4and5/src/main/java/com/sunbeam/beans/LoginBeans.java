package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBeans {
	private String email;
	private String password;
	private int count;
	
	public LoginBeans() {
	
	}

	public LoginBeans(String email, String password, int count) {
		this.email = email;
		this.password = password;
		this.count = count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void getUser() {
		try(UserDao userDao = new UserDaoImpl()) {
			
			User u = userDao.findByEmail(email);
			
			if(u.getEmail().equals(email) && u.getPassword().equals(password) && u.getRole().equals("admin")) {
				count = 1;
			}
			else if(u.getEmail().equals(email) && u.getPassword().equals(password) && u.getRole().equals("voter")) {
				count = 2;
			}
			else {
				count = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
