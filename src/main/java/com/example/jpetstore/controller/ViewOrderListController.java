package com.example.jpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.domain.Order;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({ "userSession", "buyOrderList", "sellOrderList" })
public class ViewOrderListController {

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/user/viewSellerOrderList.do")
	public String getOrderListBySeller(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();
		
		PagedListHolder<Order> sellOrderList = new PagedListHolder<Order>(
				this.sosomarket.getOrderListBySeller(accountId));
		sellOrderList.setPageSize(4);
		
		model.put("sellOrderList", sellOrderList);
		
		return "ListSellerOrders";
	}

	@RequestMapping("/user/viewSellerOrderList2.do")
	public String getOrderListBySeller2(@RequestParam("page") String page,
			@ModelAttribute("sellOrderList") PagedListHolder<Order> sellOrderList, BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			sellOrderList.nextPage();
		} else if ("previous".equals(page)) {
			sellOrderList.previousPage();
		}
		
		return "ListSellerOrders";
	}

	@RequestMapping("/user/viewBuyerOrderList.do")
	public String getOrderListByBuyer(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();
		
		PagedListHolder<Order> buyOrderList = new PagedListHolder<Order>(
				this.sosomarket.getOrderListByBuyer(accountId));
		buyOrderList.setPageSize(4);
		
		model.put("buyOrderList", buyOrderList);
		
		return "ListBuyerOrders";
	}

	@RequestMapping("/user/viewBuyerOrderList2.do")
	public String getOrderListByBuyer2(@RequestParam("page") String page,
			@ModelAttribute("buyOrderList") PagedListHolder<Order> buyOrderList, BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			buyOrderList.nextPage();
		} else if ("previous".equals(page)) {
			buyOrderList.previousPage();
		}
		
		return "ListBuyerOrders";
	}
}