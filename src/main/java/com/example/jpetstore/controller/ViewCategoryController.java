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

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({ "category", "productList", "auctionList" })
public class ViewCategoryController {
	
	private SosoMarketFacade sosomarket;

	@Autowired
	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/shop/viewCategory.do")
	public String productHandleRequest(@RequestParam("categoryId") int categoryId, ModelMap model) throws Exception {
		
		Category category = this.sosomarket.getCategory(categoryId);
		
		PagedListHolder<Product> productList = new PagedListHolder<Product>(
				this.sosomarket.getProductListByCategory(categoryId));
		productList.setPageSize(4);
		
		model.put("category", category);
		model.put("productList", productList);
		
		return "SearchProductList";
	}

	@RequestMapping("/shop/viewCategory2.do")
	public String productHandleRequest2(@RequestParam("categoryId") int categoryId, ModelMap model) throws Exception {
		
		Category category = this.sosomarket.getCategory(categoryId);
		
		PagedListHolder<Product> productList = new PagedListHolder<Product>(
				this.sosomarket.getProductListByCategory(categoryId));
		productList.setPageSize(4);
		
		model.put("category", category);
		model.put("productList", productList);
		
		return "SearchProductList";
	}

	@RequestMapping("/shop/viewAuctionCategory.do")
	public String auctionHandleRequest(@RequestParam("categoryId") int categoryId, ModelMap model) throws Exception {
		
		Category category = this.sosomarket.getCategory(categoryId);
		
		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(
				this.sosomarket.getAuctionListByCategory(categoryId));
		auctionList.setPageSize(4);
		
		model.put("category", category);
		model.put("auctionList", auctionList);
		
		return "SearchAuctionList";
	}

	@RequestMapping("/shop/viewAuctionCategory2.do")
	public String auctionHandleRequest2(@RequestParam("page") String page,
			@ModelAttribute("category") Category category,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList, BindingResult result) throws Exception {
		
		if (category == null || auctionList == null)
			throw new IllegalStateException("Cannot find pre-loaded category and product list");
		
		if ("next".equals(page)) {
			auctionList.nextPage();
		} else if ("previous".equals(page)) {
			auctionList.previousPage();
		}
		
		return "SearchAuctionList";
	}
}