package com.example.ShoppingCenter.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ShoppingCenter.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE u.username = :username AND u.password = :password")
	User findUserByUserNameAndPassword(@Param("username") String username,@Param("password") String password);
	
}
