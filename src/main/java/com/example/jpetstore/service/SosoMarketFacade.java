package com.example.jpetstore.service;

import java.util.List;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Wish;

public interface SosoMarketFacade {

	Account getAccount(String accountId);

	Account getAccount(String accountId, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	void deleteAccount(String accountId);

	void updateWithdraw(String accountId);

	List<Category> getCategoryList();

	Category getCategory(int categoryId);

	List<Product> getProductListByUser(String accountId);

	List<Product> getProductListByCategory(int categoryId);

	List<Product> searchProductList(String keyword);

	Product getProduct(int productId);

	List<Product> getProductByUserAndTitle(String accountId, String title);

	List<Product> getAllProduct();

	void updateProduct(Product product);

	void insertProduct(Product product);

	void deleteProduct(int productId);

	void updateProductStatus(Product product);

	List<Auction> getAuctionListByUser(String accountId);

	List<Auction> getAuctionListByCategory(int categoryId);

	List<Auction> searchAuctionList(String keyword);

	Auction getAuction(int auctionId);

	List<Auction> getAllAuction();

	void insertAuction(Auction auction);

	void deleteAuction(int auctionId);

	void updateAuctionCurrentPriceAndBuyerId(Bidding bidding);

	void insertBidding(Bidding bidding);

	Bidding getBidding(int biddingId);

	void deleteBidding(int auctionId);

	List<Bidding> getBiddingsByUser(String accountId);

	List<Bidding> getBiddingsByAuction(int auctionId);

	void insertOrder(Order order);

	Order getOrder(int orderId);

	Order getOrderByBuyer(int orderId);

	Order getOrderBySeller(int orderId);

	List<Order> getOrderListByBuyer(String accountId);

	List<Order> getOrderListBySeller(String accountId);

	void updateOrderStatus(Order order);

	Wish getWish(int productId);

	Wish getWish(String accountId, int productId);

	List<Wish> getWishListByUser(String accountId);

	List<Wish> getWishListAuctionByUser(String accountId);

	void insertWish(Wish wish);

	void deleteWish(int productId);
}