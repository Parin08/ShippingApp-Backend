package com.example.ShoppingCenter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingCenter.DAO.ProductDAOImpl;
import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.models.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAOImpl productdaoimpl;
	@Autowired
	private ModelMapper mm;

	public List<ProductModel> getProducts() {
		List<Product> products = productdaoimpl.getProducts();
		List<ProductModel> productModels = products.stream().map(i -> mm.map(i, ProductModel.class)).collect(Collectors.toList());
		return productModels;
	}

	public ProductModel getProduct(int id) {
		ProductModel pm = mm.map(productdaoimpl.getProduct(id), ProductModel.class);
		return pm;
	}

	public void addProduct(ProductModel product) {
		Product p = mm.map(product, Product.class);
		productdaoimpl.addProduct(p);
	}

	public void deleteProduct(int id) {
		productdaoimpl.deleteProduct(id);
	}

	public void updateProduct(ProductModel product, int id) {
		if (id == product.getProduct_id()) {
			Product p = mm.map(product, Product.class);
			productdaoimpl.updateProduct(p, id);
		}
	}
	
	public List<ProductModel> getProductByName(String name){
		
		List<Product> p = productdaoimpl.getProduct(name);
		List<ProductModel>  pm = p.stream().map(item ->  mm.map(item, ProductModel.class)).collect(Collectors.toList());
		return pm;
	}

}
