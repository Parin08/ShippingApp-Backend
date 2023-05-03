
  package com.example.ShoppingCenter.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ShoppingCenter.models.User;

public class UserDAOImpl {
	  @Autowired
	  private UserDAO userdao;
	  
	  public User addUser(User user) {
		  return userdao.save(user);
	  }
	  
	  
	  public User findUser(String username,String password) {
		  return userdao.findUserByUserNameAndPassword(username, password);
	  }
	  
	  public List<User> getUsers(){
		  return userdao.findAll();
	  }
	  
  }
