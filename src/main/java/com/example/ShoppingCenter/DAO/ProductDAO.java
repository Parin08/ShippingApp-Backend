package com.example.ShoppingCenter.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ShoppingCenter.models.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("FROM Product WHERE LOWER(product_name) LIKE %:productName% ")
	List<Product> findProductByName(@Param("productName") String productName);

}
