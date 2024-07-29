package com.example.jpetstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.SosoMarketFacade;

@Controller
@SessionAttributes({ "category", "productList" })
public class DeleteProductController {

	private SosoMarketFacade sosomarket;

	@Autowired
	public void setPetStore(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	@RequestMapping("/shop/deleteProduct.do")
	public ModelAndView deleteProduct(HttpSession session, @RequestParam("productId") int productId, ModelMap model) throws Exception {
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		Product product = sosomarket.getProduct(productId);

		if (!userSession.getAccount().getAccountId().equals(product.getSellerId()))
			return new ModelAndView("Error", "message", "占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占  占쏙옙품占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쌍쏙옙占싹댐옙.");
		if (product.getProductStatus().equals("done"))
			return new ModelAndView("Error", "message", "占쌍뱄옙占쏙옙 占쏙옙품占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
		else {
			this.sosomarket.deleteProduct(productId);

			return new ModelAndView("index");
		}
	}

	@RequestMapping("/shop/deleteAuctionProduct.do")
	public ModelAndView deleteAuctionProduct(HttpSession session, @RequestParam("productId") int productId, ModelMap model) throws Exception {

		UserSession userSession = (UserSession) session.getAttribute("userSession");
		Auction auction = sosomarket.getAuction(productId);
		String loginId = userSession.getAccount().getAccountId();

		if (!loginId.equals(auction.getProduct().getSellerId()))
			return new ModelAndView("Error", "message", "������ ����� ��ǰ�� ������ �� �ֽ��ϴ�.");
		if (auction.getProduct().getProductStatus().equals("done"))
			return new ModelAndView("Error", "message", "�ֹ��� ��ǰ�� ������ �� �����ϴ�.");
		else {
			this.sosomarket.updateWithdraw(loginId);
			this.sosomarket.deleteProduct(productId);
			this.sosomarket.deleteAuction(productId);

			return new ModelAndView("index");
		}
	}
}