package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
//@SessionAttributes({"category", "productList"})
public class ViewAuctionController { 

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("shop/viewAuction.do")
	public String handleRequest(
			@RequestParam("auctionId") String auctionId,
			ModelMap model,
			HttpServletRequest request) throws Exception {
		List<Bidding> biddingList = new ArrayList<Bidding>();
		biddingList = this.sosomarket.getBiddingsByAuction(Integer.parseInt(auctionId));

		Auction auction = this.sosomarket.getAuction(Integer.parseInt(auctionId));
		model.put("biddingList", biddingList);
		model.put("auction", auction);
		
		return "ViewAuctionProduct";
	}
}
