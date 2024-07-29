package com.example.jpetstore.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.domain.Wish;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({"userSession", "wishList"})
public class ViewWishListController {
	
	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/user/viewWishList.do")
	public String productHandleRequest(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();
		
		PagedListHolder<Wish> wishList = new PagedListHolder<Wish>(this.sosomarket.getWishListByUser(accountId));
		wishList.setPageSize(6);
		
		model.put("wishList", wishList);
		
		return "ListWishs";
	}

	@RequestMapping("/user/viewWishList2.do")
	public String productHandleRequest2(@RequestParam("page") String page, @ModelAttribute("wishList") PagedListHolder<Wish> wishList, 
			BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			wishList.nextPage();
		} else if ("previous".equals(page)) {
			wishList.previousPage();
		}
		
		return "ListWishs";
	}
	
	@RequestMapping("/user/viewAuctionWishList.do")
	public String auctionHandleRequest(@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {
		
		String accountId = userSession.getAccount().getAccountId();

		PagedListHolder<Wish> wishList = new PagedListHolder<Wish>(this.sosomarket.getWishListAuctionByUser(accountId));
		wishList.setPageSize(8);

		model.put("wishList", wishList);
		
		return "ListWishsAuction";
	}

	@RequestMapping("/user/viewAuctionWishList2.do")
	public String auctionHandleRequest2(@RequestParam("page") String page, @ModelAttribute("wishList") PagedListHolder<Wish> wishList, 
			BindingResult result) throws Exception {
		
		if ("next".equals(page)) {
			wishList.nextPage();
		} else if ("previous".equals(page)) {
			wishList.previousPage();
		}
		
		return "ListWishsAuction";
	}
}