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
public class UpdateOrderStatusController {

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/user/updateOrder.do")
	public ModelAndView getSellerOrder(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId, @RequestParam("orderStatus") String orderStatus) throws Exception {
		
		Order order = this.sosomarket.getOrderBySeller(orderId);
		
		if (userSession.getAccount().getAccountId().equals(order.getSellerId())) {
			
			order.setOrderStatus(orderStatus);
			this.sosomarket.updateOrderStatus(order);
			
			return new ModelAndView("ViewSellerOrder", "order", order);
		} else {
			return new ModelAndView("Error", "message", "You may only view your own orders.");
		}
	}
}