package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

	private String categoryId;
	private String name;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return getCategoryId();
	}
}