package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

@SuppressWarnings("serial")
public class OrderForm implements Serializable {

	private Product product;
	private final Order order = new Order();

	public Order getOrder() {
		return order;
	}

	public void setProductId(int productId) {
		order.setProductId(productId);
	}

	public void setBuyerId(String buyerId) {
		order.setBuyerId(buyerId);
	}

	@Override
	public String toString() {
		return "OrderForm [product=" + product + "order=" + order + "]";
	}
}