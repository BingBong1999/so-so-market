package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
public class SearchProductsController {

	private SosoMarketFacade sosoMarket;

	@Autowired
	public void setSoSoMarket(SosoMarketFacade sosoMarket) {
		this.sosoMarket = sosoMarket;
	}

	@RequestMapping("/shop/searchProducts.do")
	public String handleRequest(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "type", required = false) String type, ModelMap model) throws Exception {
		
		if (keyword != null) {
			if (!StringUtils.hasLength(keyword)) {
				model.put("message", "Please enter a keyword to search for, then press the search button.");
				return "Error";
			}

			model.put("keyword", keyword);

			if (type.equals("product")) {
				PagedListHolder<Product> productList = new PagedListHolder<Product>(
						this.sosoMarket.searchProductList(keyword.toLowerCase()));
				productList.setPageSize(4);
				request.getSession().setAttribute("SearchProductsController_productList", productList);
				model.put("productList", productList);
				return "SearchProductList";
			} else {
				PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(
						this.sosoMarket.searchAuctionList(keyword.toLowerCase()));
				auctionList.setPageSize(4);
				request.getSession().setAttribute("SearchProductsController_auctionList", auctionList);
				model.put("auctionList", auctionList);
				return "SearchAuctionList";
			}

		} else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Product> productList = (PagedListHolder<Product>) request.getSession()
					.getAttribute("SearchProductsController_productList");
			@SuppressWarnings("unchecked")
			PagedListHolder<Auction> auctionList = (PagedListHolder<Auction>) request.getSession()
					.getAttribute("SearchProductsController_auctionList");
			model.put("keyword", keyword);

			if (productList == null && auctionList == null) {
				model.put("message", "Your session has timed out. Please start over again.");
				
				return "Error";
			} else if (productList != null && auctionList == null) {
				if ("next".equals(page)) {
					productList.nextPage();
				} else if ("previous".equals(page)) {
					productList.previousPage();
				}
				model.put("productList", productList);
				
				return "SearchProductList";
			} else {
				if ("next".equals(page)) {
					auctionList.nextPage();
				} else if ("previous".equals(page)) {
					auctionList.previousPage();
				}
				model.put("auctionList", auctionList);
				
				return "SearchAuctionList";
			}
		}
	}
}