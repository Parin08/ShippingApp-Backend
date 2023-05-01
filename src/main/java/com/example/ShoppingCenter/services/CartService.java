package com.example.ShoppingCenter.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.Utils.ShippingOptionModel;
import com.example.ShoppingCenter.models.Product;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

	@Autowired
	private ModelMapper mm;

	private List<Product> products;

	public void addToCart(ProductModel product, HttpSession session) {
		Product p = mm.map(product, Product.class);	
		boolean check = false;
		int position = 0;
		
		if (session.getAttribute("products") != null) {
			products = (List<Product>) session.getAttribute("products");

		} else {
			products = new ArrayList<>();
		}
		
		for(int i=0; i < products.size() ;i++) {
			if(products.get(i).getProduct_id() == p.getProduct_id()) {
				position = i;
				check = true;			
			}
		}
		
		if(check) {
			
			products.remove(position);
		}else {
			products.add(p);
		
		}
		session.setAttribute("products", products);
		
		
	}

	public List<ProductModel> getCartProducts(HttpSession session) {

		if(session.getAttribute("products") != null) {
		products = (List<Product>) session.getAttribute("products");
		
		List<ProductModel> prductmodels = new ArrayList<>();

		for (Product prod : products) {
			prductmodels.add(mm.map(prod, ProductModel.class));
		}
	
		return prductmodels;
	
		}else {
			return null;
		}
	}
	
	public void addDeliveryOption(HttpSession session, ShippingOptionModel shippingoptions) {
		if (session != null)
			session.setAttribute("delivery", shippingoptions);
	}
	
	public ShippingOptionModel getDeliveryOption(HttpSession session) {
		
		return (ShippingOptionModel) session.getAttribute("delivery");
	}

}
