package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.ProductFormValidator;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@RequestMapping({ "/shop/updateProductForm.do", "/shop/updateProduct.do" })
@SessionAttributes("productForm")
public class UpdateController {

	@Value("NewProductForm")
	private String formViewName;

	@Value("index")
	private String successViewName;

	@Autowired
	private SosoMarketFacade sosomarket;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@Autowired
	private ProductFormValidator validator;

	public void setValidator(ProductFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("productForm")
	public ProductForm formBackingObject(HttpServletRequest request, @RequestParam("productId") String productId) throws Exception {

		if (productId != null) {
			
			int int_productId = Integer.parseInt(productId);
			Product product = sosomarket.getProduct(int_productId);

			ProductForm pf = new ProductForm();
			pf.setProductForm(product);

			return pf;
		}

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		ProductForm pf = new ProductForm();
		pf.setSellerId(userSession.getAccount().getAccountId());

		return pf;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("productForm") ProductForm productForm, BindingResult result) throws Exception {
		
		validator.validate(productForm, result);
		
		if (result.hasErrors())
			return formViewName;

		sosomarket.updateProduct(productForm.getProduct());
		
		return successViewName;
	}
}