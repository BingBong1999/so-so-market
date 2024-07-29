package com.example.jpetstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.support.PagedListHolder;

import com.example.jpetstore.domain.Bidding;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({ "biddingList" })
public class ViewBiddingListController {
	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/shop/viewMyBiddingList.do")
	public String myBiddingHandleRequest(ModelMap model, HttpSession session) throws Exception {
		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		Account account = userSession.getAccount();
		
		PagedListHolder<Bidding> biddingList = new PagedListHolder<Bidding>(
				this.sosomarket.getBiddingsByUser(account.getAccountId()));
		biddingList.setPageSize(6);
		
		model.put("biddingList", biddingList);
		
		return "ListBiddings";
	}

	@RequestMapping("/shop/viewMyBiddingList2.do")
	public String auctionHandleRequest2(@RequestParam("page") String page,
			@ModelAttribute("biddingList") PagedListHolder<Bidding> biddingList, BindingResult result) throws Exception {
		
		if (biddingList == null)
			throw new IllegalStateException("Cannot find pre-loaded bidding list");
		
		if ("next".equals(page)) {
			biddingList.nextPage();
		} else if ("previous".equals(page)) {
			biddingList.previousPage();
		}
		
		return "ListBiddings";
	}
}