package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Auction;

import com.example.jpetstore.service.BiddingFormValidator;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@RequestMapping({ "/shop/newBidding.do", "/shop/insertBidding.do" })
@SessionAttributes("biddingForm")
public class BiddingController {

	@Value("BiddingForm")
	private String formViewName;

	@Value("index")
	private String successViewName;

	@Autowired
	private SosoMarketFacade sosomarket;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	UserSession userSession;
	BiddingForm bf;

	@Autowired
	private BiddingFormValidator validator;

	public void setValidator(BiddingFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("biddingForm")
	public BiddingForm formBackingObject(HttpServletRequest request) throws Exception {
		userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		bf = new BiddingForm();
		bf.setBuyerId(userSession.getAccount().getAccountId());
		
		return bf;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@RequestParam("productId") String auctionId,			
			@ModelAttribute("biddingForm") BiddingForm biddingForm, BindingResult result) throws Exception {
		
		Auction auction = sosomarket.getAuction(Integer.parseInt(auctionId));
		int highestBid = auction.getCurrentPrice();
		
		validator.validate(biddingForm, result);
		validator.validateHighestBid(biddingForm, result, highestBid);
		
		if (result.hasErrors())
			return formViewName;

		biddingForm.setProductId(Integer.parseInt(auctionId));
		
		sosomarket.insertBidding(biddingForm.getBidding());
		sosomarket.updateAuctionCurrentPriceAndBuyerId(biddingForm.getBidding());

		return successViewName;
	}
}