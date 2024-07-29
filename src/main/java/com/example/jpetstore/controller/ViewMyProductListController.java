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

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({ "userSession", "productList", "auctionList" })
public class ViewMyProductListController {

	@Autowired
	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/user/viewMyProductList.do")
	public String getMyProductList(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();
		
		PagedListHolder<Product> productList = new PagedListHolder<Product>(
				this.sosomarket.getProductListByUser(accountId));
		productList.setPageSize(6);
		
		model.put("productList", productList);

		return "ListSells";
	}

	@RequestMapping("/user/viewMyProductList2.do")
	public String productHandleRequest2(@RequestParam("page") String page,
			@ModelAttribute("productList") PagedListHolder<Product> productList, BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			productList.nextPage();
		} else if ("previous".equals(page)) {
			productList.previousPage();
		}
		
		return "ListSells";
	}

	@RequestMapping("/user/viewMyAuctionProductList.do")
	public String getMyAuctionProductList(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();
		
		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(
				this.sosomarket.getAuctionListByUser(accountId));
		auctionList.setPageSize(6);
		
		model.put("auctionList", auctionList);

		return "ListAuctionSells";
	}

	@RequestMapping("/user/viewMyAuctionProductList2.do")
	public String getMyAuctionProductList2(@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList, BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			auctionList.nextPage();
		} else if ("previous".equals(page)) {
			auctionList.previousPage();
		}
		
		return "ListAuctionSells";
	}
}