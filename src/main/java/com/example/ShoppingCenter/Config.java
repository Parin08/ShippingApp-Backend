package com.example.ShoppingCenter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.HttpSession;

@Configuration
public class Config {	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
