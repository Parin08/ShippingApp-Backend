package com.example.ShoppingCenter.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCenter.Utils.ProductModel;
import com.example.ShoppingCenter.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productservice;

	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getProducts() {
		productservice.getProducts();
		return ResponseEntity.status(Response.SC_ACCEPTED).body(productservice.getProducts());
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductModel> getProduct(@PathVariable("id") int id) {
		return ResponseEntity.status(Response.SC_OK).body(productservice.getProduct(id));
	}

	@PostMapping("/product")
	public void addProduct(@RequestBody ProductModel product) {
		product.setProduct_id((int) Math.round(Math.random() * 100000 + 99999));
		if (product.getProduct_name() != null || product.getProduct_description() != null
				|| product.getProduct_pic() != null || product.getProduct_price() != 0) {
			productservice.addProduct(product);
		}

	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productservice.deleteProduct(id);

	}

	@PatchMapping("/product/{id}")
	public void updateProduct(@RequestBody ProductModel product, @PathVariable("id") int id) {
		if (product.getProduct_name() != null && product.getProduct_description() != null
				&& product.getProduct_pic() != null && product.getProduct_price() != 0) {
			productservice.updateProduct(product, id);
		}
	}

	@GetMapping("/product/search/{name}")
	public ResponseEntity<List<ProductModel>> getProductByName(@PathVariable("name") String name) {

		return ResponseEntity.status(Response.SC_ACCEPTED).body(productservice.getProductByName(name));
	}

}
