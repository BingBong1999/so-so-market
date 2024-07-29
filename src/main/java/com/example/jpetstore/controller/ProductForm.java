package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Product;

@SuppressWarnings("serial")
public class ProductForm implements Serializable {

	private Product product;

	public ProductForm(Product product) {
		this.product = product;
	}

	public void setProductForm(Product product) {
		this.product = product;
	}

	public ProductForm() {
		this.product = new Product();
	}

	public Product getProduct() {
		return product;
	}

	public void setSellerId(String sellerId) {
		product.setSellerId(sellerId);
	}

	@Override
	public String toString() {
		return "ProductForm [product=" + product + "]";
	}
}