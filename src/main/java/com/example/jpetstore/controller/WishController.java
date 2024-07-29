package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Wish;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes("wish")
public class WishController {

	private SosoMarketFacade sosomarket;
	public boolean isEmptyWish = true;

	@Autowired
	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@ModelAttribute("wish")
	public Wish createWish() {
		return new Wish();
	}

	@RequestMapping("/user/newWish.do")
	public String handleRequest(@RequestParam("productId") String productId, @ModelAttribute("wish") Wish wish,
			HttpServletRequest request) throws Exception {

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		Wish wish2 = sosomarket.getWish(wish.getProductId());

		if (wish2 == null) {
			wish2 = wish;
			wish2.setAccountId(userSession.getAccount().getAccountId());
			wish2.setProductId(Integer.parseInt(productId));
			sosomarket.insertWish(wish2);
		} else {
			sosomarket.deleteWish(Integer.parseInt(productId));
		}

		return "SearchProductList";
	}
}