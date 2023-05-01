
  package com.example.ShoppingCenter.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	  
  }
