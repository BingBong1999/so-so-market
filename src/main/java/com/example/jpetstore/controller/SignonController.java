package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes("userSession")
public class SignonController {

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/main/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request, @RequestParam("accountId") String accountId,
			@RequestParam("password") String password,
			@RequestParam(value = "forwardAction", required = false) String forwardAction, Model model) throws Exception {
		
		Account account = sosomarket.getAccount(accountId, password);
		if (account == null) {
			return new ModelAndView("Error", "message", "Invalid username or password.  Signon failed.");
		} else {
			UserSession userSession = new UserSession(account);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null)
				return new ModelAndView("redirect:" + forwardAction);
			else
				return new ModelAndView("index");
		}
	}
}