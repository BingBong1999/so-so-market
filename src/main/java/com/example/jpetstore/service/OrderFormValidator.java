package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.OrderForm;
import com.example.jpetstore.domain.Order;

@Component
public class OrderFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Order.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		OrderForm orderForm = (OrderForm) obj;
		Order order = orderForm.getOrder();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.bankName", "BANK_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.bankNumber", "BANK_NUMBER_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shippingZipCode", "ZIPCODE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.shippingAddress", "ADDRESS_REQUIRED");

		if (order.getShippingZipCode().length() != 5 && order.getShippingZipCode() != null
				&& order.getShippingZipCode().length() > 0) {
			errors.rejectValue("order.shippingZipCode", "ZIPCODE_LENGTH");
		}

		if (errors.hasFieldErrors() && !errors.hasGlobalErrors()) {
			errors.reject("ERRORS_OCCURED");
		}
	}
}