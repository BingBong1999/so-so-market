package com.example.jpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
public class ViewProductController {

	private SosoMarketFacade petStore;

	@Autowired
	public void setPetStore(SosoMarketFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/viewProduct.do")
	public ModelAndView handleRequest(@RequestParam("productId") String productId, ModelMap model) throws Exception {
		
		Product product = this.petStore.getProduct(Integer.parseInt(productId));
		
		return new ModelAndView("ViewProduct", "product", product);
	}
}
