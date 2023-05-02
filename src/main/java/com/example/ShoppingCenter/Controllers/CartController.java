package com.example.ShoppingCenter.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCenter.SessionCreator;
import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.Utils.ShippingOptionModel;
import com.example.ShoppingCenter.services.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "https://parin08.github.io", allowCredentials = "true")

public class CartController {
	@Autowired
	private CartService cartservice;


	@PostMapping("/product/addtocart")
	public boolean addToCart(@RequestBody ProductModel product) {

		if (SessionCreator.getSession() == null) {
			return false;
		}
		
		cartservice.addToCart(product, SessionCreator.getSession());
		return true;

	}

	@GetMapping("/product/getfromcart")
	public List<ProductModel> getProductsFromCart() {
		if(SessionCreator.getSession() == null) {
			return null;
		}
		SessionCreator.setSession(SessionCreator.getSession());
		return cartservice.getCartProducts(SessionCreator.getSession());

	}

	@PostMapping("/product/shippingprocess")
	public void addShippingPackage(@RequestBody ShippingOptionModel shippingModel) {
		cartservice.addDeliveryOption(SessionCreator.getSession(), shippingModel);
	}

	@GetMapping("/product/shippingprocess")
	public ResponseEntity<ShippingOptionModel> getShippingPackage() {
		if (SessionCreator.getSession() != null)
			return ResponseEntity.status(Response.SC_ACCEPTED).body(cartservice.getDeliveryOption(SessionCreator.getSession()));
		else
			return null;
	}

}
