package com.example.ShoppingCenter.Controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCenter.SessionCreator;
import com.example.ShoppingCenter.Utils.UserModel;
import com.example.ShoppingCenter.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;

	@PostMapping("/signup")
	public boolean addUser(HttpSession httpsession, @RequestBody UserModel usermodel) {
		usermodel.setUserId((int) Math.round(Math.random() * 10000) + 99999);
		if (userservice.addUser(usermodel) != null) {
			SessionCreator.setSession(httpsession);
			SessionCreator.getSession().setAttribute("user", usermodel);
			SessionCreator.setOrderSession();
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/login")
	public boolean findUser(HttpSession httpsession, @RequestBody UserModel usermodel) {
		UserModel um = userservice.findUser(usermodel);
		if ( um!= null) {
			SessionCreator.setSession(httpsession);
			SessionCreator.getSession().setAttribute("user", um);
			SessionCreator.setOrderSession();
			return true;
		} else {
			return false;
		}

	}
	
	@GetMapping("/signout")
	public boolean signout() {
		if (SessionCreator.getSession() != null) {
			SessionCreator.setSession(null);
			return true;
		}else
			return false;
	}

	@GetMapping("/authenticate")
	public boolean authenticate() {
		if (SessionCreator.getSession() != null)
			return true;
		else
			return false;

	}

	
	@GetMapping("/authorised")
	public boolean authorise() {
		if (SessionCreator.getSession() != null) {
			UserModel usermodel = (UserModel) SessionCreator.getSession().getAttribute("user");
			System.out.println(usermodel);
			if (usermodel.getUsername().equals("pate0468") && usermodel.getPassword().equals("3Cfe170c$")) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

}
