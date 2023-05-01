package com.example.ShoppingCenter.DAO;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ShoppingCenter.models.Product;

public class ProductDAOImpl {
	@Autowired
	private ProductDAO productdao;

	public List<Product> getProducts() {
		return productdao.findAll();
	}

	public Product getProduct(int id) {
		return productdao.findById(id).get();
	}

	public void addProduct(Product product) {
		productdao.save(product);
	}

	public void deleteProduct(int id) {
		productdao.deleteById(id);
	}

	public void updateProduct(Product product, int id) {
		
		Product p = productdao.findById(id).get();
		p.setProduct_name(product.getProduct_name());
		p.setProduct_price(product.getProduct_price());
		p.setProduct_description(product.getProduct_description());
		p.setProduct_pic(product.getProduct_pic());
		productdao.save(p);
	}
	
	
	public List<Product> getProduct(String name) {
		return productdao.findProductByName(name.toLowerCase());
	}
}
