package com.example.ShoppingCenter.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ShoppingCenter.models.Order;
import com.example.ShoppingCenter.models.Product;

public class OrderDAOImpl {
	
	@Autowired
	private OrderDAO orderdao;
	
	public void addOrderData(Order order) {
		orderdao.save(order);
	}
	
	public List<Order> getAllOrders(int user_id) {
	
		List<Object[]> o = orderdao.getAllOrders(user_id);
		List<Order> orderHistory = new ArrayList<>();
		for(Object[] obj:o) {
			Order order = new Order();
			Long l = (Long) obj[0];
			
			order.setQuantity(l.intValue());
			order.setPrice((double)obj[1]);
			order.setDate((Date)obj[2]);
			order.setShipping_type((String)obj[3]);
			order.setSession_id((String)obj[4]);
			orderHistory.add(order);			
		}
		return orderHistory;
	}
	
	public List<Product> getOrderDetails(String session_id){
		System.out.println(session_id);
		List<Object[]> orderDetails =  orderdao.getOrderDetails(session_id);
		List<Product> products = new ArrayList<>();
		for(Object[] obj:orderDetails) {			
			Product product = (Product)obj[1];
			products.add(product);
		}
		return products;
	}
	
	
	public List<Order> getDeliveryDetails(String session_id){
		
		List<Object[]> orderDetails =  orderdao.getOrderDetails(session_id);
		List<Order> orders = new ArrayList<>();
		for(Object[] obj:orderDetails) {			
			Order order = (Order)obj[0];
			orders.add(order);
		}
		return orders;
	}

}
