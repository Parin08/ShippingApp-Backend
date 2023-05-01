package com.example.ShoppingCenter.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingCenter.SessionCreator;
import com.example.ShoppingCenter.DAO.OrderDAOImpl;
import com.example.ShoppingCenter.Utils.OrderModel;
import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.Utils.UserModel;
import com.example.ShoppingCenter.models.Order;
import com.example.ShoppingCenter.models.Product;

@Service
public class OrderService {
	@Autowired
	private OrderDAOImpl orderdaoimpl;
	@Autowired
	private ModelMapper modelmapper;
	
	
	public void addOrderData(OrderModel ordermodel) {
		Order order = modelmapper.map(ordermodel, Order.class);
		orderdaoimpl.addOrderData(order);
	}
	
	public List<OrderModel> getAllOrders() {
		List<OrderModel> ordermodel = new ArrayList<>();
		UserModel usermodel = (UserModel) SessionCreator.getSession().getAttribute("user"); 
		for(Order order: orderdaoimpl.getAllOrders(usermodel.getUserId())) {
			ordermodel.add(modelmapper.map(order, OrderModel.class));
		}
		return ordermodel;
	}
	
	public List<ProductModel> getOrderDetails(String session_id){
		List<ProductModel> productmodel = new ArrayList<>();
		for(Product product: orderdaoimpl.getOrderDetails(session_id)) {
			productmodel.add(modelmapper.map(product, ProductModel.class));
		}
		return productmodel;

	}
	
	public List<OrderModel> getDeliveryDetails(String session_id){
		List<OrderModel> ordermodel = new ArrayList<>();
		for(Order order: orderdaoimpl.getDeliveryDetails(session_id)) {
			ordermodel.add(modelmapper.map(order, OrderModel.class));
		}
		return ordermodel;

	}
	

}
