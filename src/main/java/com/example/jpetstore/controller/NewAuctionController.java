package com.example.jpetstore.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AuctionFormValidator;
import com.example.jpetstore.service.SchedulerService;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@RequestMapping({ "/shop/newAuctionForm.do", "/shop/newAuction.do" })
@SessionAttributes({ "userSession", "categoryList" })

public class NewAuctionController implements ApplicationContextAware {

	private SchedulerService service;
	Date date;

	@Value("NewAuctionForm")
	private String formViewName;

	@Value("index")
	private String successViewName;

	@Autowired
	private SosoMarketFacade sosomarket;

	@Value("/upload/")
	private String uploadDirLocal;

	private WebApplicationContext context;
	private String uploadDir;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@Autowired
	public void setService(SchedulerService service) {
		this.service = service;
	}

	UserSession userSession;
	public String sellerId;
	public Product product;

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath(this.uploadDirLocal);
	}

	@Autowired
	private AuctionFormValidator validator;

	public void setValidator(AuctionFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("auctionForm")
	public AuctionForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");

		AuctionForm af = new AuctionForm();
		product = new Product();
		af.setProduct(product);
		sellerId = userSession.getAccount().getAccountId();
		af.setSellerId(sellerId);

		return af;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(ModelMap model) {
		model.put("categoryList", sosomarket.getCategoryList());
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userSession") UserSession userSession, MultipartHttpServletRequest multiRequest,
			ModelMap model, @ModelAttribute("auctionForm") AuctionForm auctionForm, BindingResult result) throws Exception {

		validator.validate(auctionForm, result);
		
		if (result.hasErrors())
			return formViewName;

		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			String formatedNow = now.format(formatter);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date = dateFormat.parse(formatedNow);
			
			if (!auctionForm.getAuction().getDeadLine().after(date)) {
				result.reject("DEADLINE_MISMATCH");
				return formViewName;
			}
		} catch (ParseException e) {
			result.reject("typeMismatch.bidding.biddingPrice");
			return formViewName;
		}

		MultipartFile imageFile = multiRequest.getFile("imageFile");
		String filename = uploadFile(imageFile);
		auctionForm.getAuction().getProduct().setImage(this.uploadDirLocal + filename);

		String accountId = auctionForm.getAuction().getProduct().getSellerId();
		String title = auctionForm.getAuction().getProduct().getTitle();

		sosomarket.insertProduct(auctionForm.getAuction().getProduct());
		List<Product> productList = sosomarket.getProductByUserAndTitle(accountId, title);

		if (productList.size() >= 2) {
			model.put("message", "같은 이름의 상품을 중복하여 등록할 수 없습니다");
			return "Error";
		} else {
			Product product2 = productList.get(0);
			auctionForm.getAuction().setAuctionId(product2.getProductId());
			auctionForm.getAuction().setCurrentPrice(auctionForm.getAuction().getStartPrice());

			sosomarket.insertAuction(auctionForm.getAuction());
			date = auctionForm.getAuction().getDeadLine();

			service.testScheduler(date, auctionForm.getAuction().getAuctionId());

			return successViewName;
		}
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