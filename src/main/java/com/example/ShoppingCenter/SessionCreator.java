package com.example.ShoppingCenter;

import jakarta.servlet.http.HttpSession;

public class SessionCreator {
	
	private static HttpSession session;
	
	private static int orderSession;
	
	public static int getOrderSession() {
		return orderSession;
	}

	public static void setOrderSession() {
		orderSession = (int) Math.round(Math.random() * 10000 + 99999);
	}
	
	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession s) {
		session = s;
	}
}
