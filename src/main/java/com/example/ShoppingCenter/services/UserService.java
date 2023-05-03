package com.example.ShoppingCenter.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingCenter.DAO.UserDAOImpl;
import com.example.ShoppingCenter.Utils.UserModel;
import com.example.ShoppingCenter.models.User;

@Service
public class UserService {

	@Autowired
	private UserDAOImpl userdaoimpl;
	@Autowired
	private ModelMapper mm;

	public UserModel addUser(UserModel usermodel) {
		User user = mm.map(usermodel, User.class);
		if (userdaoimpl.addUser(user) != null) {
			return usermodel;
		} else {
			return null;
		}
	}

	public UserModel findUser(UserModel usermodel) {
		User user = userdaoimpl.findUser(usermodel.getUsername(), usermodel.getPassword());		
		if (user != null) {
			UserModel um = mm.map(user, UserModel.class);
			return um;
		}
		return null;
	}
	
	public boolean isUnique(String username) {
		
		for(User u:userdaoimpl.getUsers()) {
			if(u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
