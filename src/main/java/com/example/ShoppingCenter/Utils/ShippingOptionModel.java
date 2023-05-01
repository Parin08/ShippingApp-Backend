package com.example.ShoppingCenter.Utils;

public class ShippingOptionModel {
	
	private double price;
	private String deliveryName;
	private String description;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ShippingOptionModel [price=" + price + ", deliveryName=" + deliveryName + ", description=" + description
				+ "]";
	}
	
	
	
	
}
