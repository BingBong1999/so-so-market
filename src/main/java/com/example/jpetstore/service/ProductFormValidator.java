package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.ProductForm;
import com.example.jpetstore.domain.Product;

@Component
public class ProductFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		ProductForm productForm = (ProductForm) obj;
		Product product = productForm.getProduct();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.title", "PRODUCT_TITLE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.description", "DESCRIPTION_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.shipping", "SHIPPING_REQUIRED");

		if (product.getPrice() < 1000) {
			errors.rejectValue("product.price", "PRICE_TOO_LOW");
		}

		if (errors.hasFieldErrors() && !errors.hasGlobalErrors()) {
			errors.reject("ERRORS_OCCURED");
		}
	}
}