package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.AccountForm;
import com.example.jpetstore.domain.Account;

@Component
public class AccountFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {

		AccountForm accountForm = (AccountForm) obj;
		Account account = accountForm.getAccount();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.password", "PASSWORD_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatedPassword", "REPEATED_PASSWORD_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.nickname", "NICKNAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_ADDRESS_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phoneNumber", "PHONE_NUMBER_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address", "ADDRESS_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.zipcode", "ZIPCODE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.bankName", "BANK_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.bankNumber", "BANK_NUMBER_REQUIRED");

		if (account.getPassword().length() < 6 && account.getPassword() != null && account.getPassword().length() > 0)
			errors.rejectValue("account.password", "PASSWORD_LENGTH");

		if (account.getZipcode().length() != 5 && account.getZipcode() != null && account.getZipcode().length() > 0)
			errors.rejectValue("account.zipcode", "ZIPCODE_LENGTH");

		if (account.getEmail() != null && account.getEmail().length() > 0)
			if (!account.getEmail().matches("(.*)@(.*)") || !account.getEmail().matches("(.*)\\.(.*)"))
				errors.rejectValue("account.email", "EMAIL_MISMATCH");

		if (!account.getPhoneNumber().matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
				&& account.getPhoneNumber() != null && account.getPhoneNumber().length() > 0)
			errors.rejectValue("account.phoneNumber", "PHONE_NUMBER_MISMATCH");

		if (accountForm.isNewAccount()) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.accountId", "ACCOUNT_ID_REQUIRED");

			if (account.getPassword() == null || account.getPassword().length() < 1
					|| accountForm.getRepeatedPassword() == null || accountForm.getRepeatedPassword().length() < 1) {
				errors.reject("PASSWORD_WRONG");
			} else if (!account.getPassword().equals(accountForm.getRepeatedPassword())) {
				errors.rejectValue("repeatedPassword", "PASSWORD_MISMATCH");
			}

		} else if (account.getPassword() != null && account.getPassword().length() > 0) {

			if (!account.getPassword().equals(accountForm.getRepeatedPassword()))
				errors.rejectValue("repeatedPassword", "PASSWORD_MISMATCH");

		}

		if (errors.hasFieldErrors() && !errors.hasGlobalErrors())
			errors.reject("ERRORS_OCCURED");

	}
}