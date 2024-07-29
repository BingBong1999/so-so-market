package com.example.jpetstore.controller;

import java.io.File;
import java.io.IOException;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.service.ProductFormValidator;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@RequestMapping({ "/shop/newProduct.do", "/shop/newProductForm.do" })
@SessionAttributes({ "userSession", "categoryList" })
public class NewProductController implements ApplicationContextAware {

	@Value("NewProductForm")
	private String formViewName;

	@Value("index")
	private String successViewName;

	@Autowired
	private SosoMarketFacade sosomarket;

	@Autowired
	private ProductFormValidator validator;

	public void setValidator(ProductFormValidator validator) {
		this.validator = validator;
	}

	@Value("/upload/")
	private String uploadDirLocal;

	private WebApplicationContext context;
	private String uploadDir;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath(this.uploadDirLocal);
	}

	@ModelAttribute("productForm")
	public ProductForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		ProductForm pf = new ProductForm();
		pf.setSellerId(userSession.getAccount().getAccountId());

		return pf;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(ModelMap model) {
		model.put("categoryList", sosomarket.getCategoryList());
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userSession") UserSession userSession, MultipartHttpServletRequest multiRequest,
			@ModelAttribute("productForm") ProductForm productForm, BindingResult result) throws Exception {

		validator.validate(productForm, result);
		
		if (result.hasErrors())
			return formViewName;

		MultipartFile imageFile = multiRequest.getFile("imageFile");
		String filename = uploadFile(imageFile);
		productForm.getProduct().setImage(this.uploadDirLocal + filename);
		sosomarket.insertProduct(productForm.getProduct());
		
		return successViewName;
	}

	private String uploadFile(MultipartFile imageFile) {
		String filename = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
		File file = new File(this.uploadDir + filename);
		try {
			imageFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return filename;
	}
}