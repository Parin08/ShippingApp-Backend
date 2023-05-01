package com.example.ShoppingCenter.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	private int order_id;
	private int user_id;
	private int product_id;
	private Date date;
	private String session_id;
	private int quantity;
	private double price;
	private double gst;
	private double shipping_price;
	private String shipping_type;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getShipping_price() {
		return shipping_price;
	}
	public void setShipping_price(double shipping_price) {
		this.shipping_price = shipping_price;
	}
	public String getShipping_type() {
		return shipping_type;
	}
	public void setShipping_type(String shipping_type) {
		this.shipping_type = shipping_type;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", product_id=" + product_id + ", date=" + date
				+ ", session_id=" + session_id + ", quantity=" + quantity + "]";
	}	
	
}
