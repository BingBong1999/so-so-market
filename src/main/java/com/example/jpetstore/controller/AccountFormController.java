package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@RequestMapping({ "/user/newAccount.do", "/user/editAccount.do" })
public class AccountFormController {

	@Value("EditAccountForm")
	private String formViewName;

	@Value("index")
	private String successViewName;
	private static final String[] LANGUAGES = { "english", "japanese" };

	@Autowired
	private SosoMarketFacade sosomarket;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@Autowired
	private AccountFormValidator validator;

	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) { // edit an existing account
			return new AccountForm(sosomarket.getAccount(userSession.getAccount().getAccountId()));
		} else { // create a new account
			return new AccountForm();
		}
	}

	@ModelAttribute("languages")
	public String[] getLanguages() {
		return LANGUAGES;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm") AccountForm accountForm, BindingResult result) throws Exception {

		validator.validate(accountForm, result);
		
		if (result.hasErrors())
			return formViewName;

		try {
			if (accountForm.isNewAccount())
				sosomarket.insertAccount(accountForm.getAccount());
			else
				sosomarket.updateAccount(accountForm.getAccount());
		} catch (DataIntegrityViolationException ex) {
			result.reject("USER_ID_ALREADY_EXISTS");
			return formViewName;
		}

		UserSession userSession = new UserSession(sosomarket.getAccount(accountForm.getAccount().getAccountId()));
		session.setAttribute("userSession", userSession);
		
		return successViewName;
	}
}