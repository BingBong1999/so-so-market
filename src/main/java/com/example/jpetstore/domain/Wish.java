package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Wish implements Serializable {

	private int wishId;
	private int productId;
	private String accountId;
	private Product product;

	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Wish [wishId=" + wishId + ", productId=" + productId + ", accountId=" + accountId + ", product="
				+ product + "]";
	}

}