package com.example.ShoppingCenter.Controllers;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCenter.SessionCreator;
import com.example.ShoppingCenter.DAO.UserDAOImpl;
import com.example.ShoppingCenter.Utils.OrderModel;
import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.Utils.ShippingOptionModel;
import com.example.ShoppingCenter.Utils.UserModel;
import com.example.ShoppingCenter.models.Product;
import com.example.ShoppingCenter.services.OrderService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class OrderController {
	@Autowired
	private OrderService orderservice;

	private SessionCreator sc = new SessionCreator();
	@Autowired
	private UserDAOImpl userdaoimpl;
	
	@PostMapping("/products/placeorder")
	public void addOrderData(OrderModel ordermodel) {
		HttpSession session = sc.getSession();
		List<Product> products = (List<Product>) session.getAttribute("products");
		ShippingOptionModel model = (ShippingOptionModel) session.getAttribute("delivery");
		UserModel usermodel = (UserModel)SessionCreator.getSession().getAttribute("user");
		System.out.println(usermodel);
		DecimalFormat df = new DecimalFormat("#.##");
		for(Product product: products) {			
		    ordermodel.setOrder_id((int)Math.round(Math.random() * 100000 + 99999));
			ordermodel.setProduct_id(product.getProduct_id());
			ordermodel.setUser_id(usermodel.getUserId());
			ordermodel.setSession_id(Double.toString(SessionCreator.getOrderSession()));
			ordermodel.setDate(new Date());	
			ordermodel.setQuantity(1);
			ordermodel.setPrice(Double.parseDouble(df.format(product.getProduct_price())));
			ordermodel.setGst(Double.parseDouble(df.format(product.getProduct_price()*0.13)));
			ordermodel.setShipping_price(model.getPrice());
			ordermodel.setShipping_type(model.getDeliveryName());
			orderservice.addOrderData(ordermodel);
		}
		session.removeAttribute("delivery");
		session.removeAttribute("products");
		SessionCreator.setOrderSession();
		sc.setSession(session);
	}
	
	@GetMapping("/getOrders")
	public List<OrderModel> getAllOrders() {
		return orderservice.getAllOrders();
	}
	
	@GetMapping("/orderDetails/{id}")
	public List<ProductModel> getOrderDetails(@PathVariable("id") String session_id){
		return orderservice.getOrderDetails(session_id);
	}
	
	@GetMapping("deliveryrDetails/{id}")
	public List<OrderModel> getDeliveryDetails(@PathVariable("id") String session_id){
		return orderservice.getDeliveryDetails(session_id);
	}
	
}
