package com.example.ShoppingCenter.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ShoppingCenter.models.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {
	
		@Query(  value = "SELECT COUNT(*) AS number_of_product, ROUND(SUM(price)+SUM(gst) + shipping_price, 2) AS total_price, date,shipping_type,session_id  FROM orders o WHERE o.user_id = :user_id GROUP BY session_id;", 
				  nativeQuery = true)
		public List<Object[]> getAllOrders(@Param("user_id") int user_id);
		
		@Query("SELECT o, p FROM Order o JOIN Product p ON o.product_id = p.product_id WHERE o.session_id = :session_id")
		public List<Object[]> getOrderDetails(@Param("session_id") String session__id);

	
}
