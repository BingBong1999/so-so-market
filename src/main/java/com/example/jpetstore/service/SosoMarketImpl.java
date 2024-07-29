package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.AuctionDao;
import com.example.jpetstore.dao.BiddingDao;
import com.example.jpetstore.dao.CategoryDao;
import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.ProductDao;
import com.example.jpetstore.dao.WishDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Wish;

@Service
@Transactional
public class SosoMarketImpl implements SosoMarketFacade {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private BiddingDao biddingDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private WishDao wishDao;

	public Account getAccount(String accountId) {
		return accountDao.getAccount(accountId);
	}

	public Account getAccount(String accountId, String password) {
		return accountDao.getAccountLogIn(accountId, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public void deleteAccount(String accountId) {
		accountDao.deleteAccount(accountId);
	}

	public void updateWithdraw(String accountId) {
		accountDao.updateWithdraw(accountId);
	}

	public Category getCategory(int categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public List<Product> getProductListByCategory(int categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> getProductListByUser(String accountId) {
		return productDao.getProductListByUser(accountId);
	}

	public List<Product> searchProductList(String keyword) {
		return productDao.searchProductList(keyword);
	}

	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	public List<Product> getProductByUserAndTitle(String accountId, String title) {
		return productDao.getProductByUserAndTitle(accountId, title);
	}

	public List<Product> getAllProduct() {
		return productDao.getAllProductList();
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void insertProduct(Product product) {
		System.out.println(product.toString() + "insertdao 직전");
		productDao.insertProduct(product);
	}

	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}

	public void updateProductStatus(Product product) {
		productDao.updateProductStatus(product);
	}

	public List<Auction> getAuctionListByUser(String accountId) {
		return auctionDao.getAuctionListByUser(accountId);
	}

	public List<Auction> getAuctionListByCategory(int categoryId) {
		return auctionDao.getAuctionListByCategory(categoryId);
	}

	public List<Auction> searchAuctionList(String keyword) {
		return auctionDao.searchAuctionList(keyword);
	}

	public List<Auction> getAllAuction() {
		return auctionDao.getAllAuctionList();
	}

	public Auction getAuction(int auctionId) {
		return auctionDao.getAuction(auctionId);
	}

	public void insertAuction(Auction auction) {
		auctionDao.insertAuction(auction);
	}

	public void deleteAuction(int auctionId) {
		auctionDao.deleteAuction(auctionId);
	}

	public void updateAuctionCurrentPriceAndBuyerId(Bidding bidding) {
		auctionDao.updateAuctionCurrentPriceAndBuyerId(bidding);
	}

	public void insertBidding(Bidding bidding) {
		biddingDao.insertBidding(bidding);
	}

	public Bidding getBidding(int biddingId) {
		return biddingDao.getBidding(biddingId);
	}

	public List<Bidding> getBiddingsByUser(String accountId) {
		return biddingDao.getBiddingsByUser(accountId);
	}

	public List<Bidding> getBiddingsByAuction(int auctionId) {
		return biddingDao.getBiddingsByAuction(auctionId);
	}

	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}

	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public Order getOrderByBuyer(int orderId) {
		return orderDao.getOrderByBuyer(orderId);
	}

	public Order getOrderBySeller(int orderId) {
		return orderDao.getOrderBySeller(orderId);
	}

	public List<Order> getOrderListByBuyer(String accountId) {
		return orderDao.getOrderListByBuyer(accountId);
	}

	public List<Order> getOrderListBySeller(String accountId) {
		return orderDao.getOrderListBySeller(accountId);
	}

	public void updateOrderStatus(Order order) {
		orderDao.updateOrderStatus(order);
	}

	public Wish getWish(int productId) {
		return wishDao.getWish(productId);
	}

	public Wish getWish(String accountId, int productId) {
		return wishDao.getWish(accountId, productId);
	}

	public List<Wish> getWishListByUser(String accountId) {
		return wishDao.getWishListByUser(accountId);
	}

	public List<Wish> getWishListAuctionByUser(String accountId) {
		return wishDao.getWishListAuctionByUser(accountId);
	}

	public void insertWish(Wish wish) {
		wishDao.insertWish(wish);
	}

	public void deleteWish(int productId) {
		wishDao.deleteWish(productId);
	}

	@Override
	public void deleteBidding(int auctionId) {
		// TODO Auto-generated method stub

	}
}