package com.example.jpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Order;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes("userSession")
public class ViewOrderController {

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/user/viewSellerOrder.do")
	public ModelAndView getSellerOrder(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId) throws Exception {
		
		Order order = this.sosomarket.getOrderBySeller(orderId);

		if (userSession.getAccount().getAccountId().equals(order.getSellerId()))
			return new ModelAndView("ViewSellerOrder", "order", order);
		else
			return new ModelAndView("Error", "message", "You may only view your own orders.");
	}

	@RequestMapping("/user/viewBuyerOrder.do")
	public ModelAndView getBuyerOrder(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId) throws Exception {
		
		Order order = this.sosomarket.getOrderByBuyer(orderId);

		if (userSession.getAccount().getAccountId().equals(order.getBuyerId()))
			return new ModelAndView("ViewBuyerOrder", "order", order);
		else
			return new ModelAndView("Error", "message", "You may only view your own orders.");
	}
}