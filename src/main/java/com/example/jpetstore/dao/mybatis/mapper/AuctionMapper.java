package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;

public interface AuctionMapper {

	Auction getAuction(int productId);

	void insertAuction(Auction auction);

	void deleteAuction(int productId);

	void updateAuctionCurrentPrice(Bidding bidding);

	void updateAuctionCurrentPriceAndBuyerId(Bidding bidding);

	List<Auction> getAuctionListByUser(String accountId);

	List<Auction> getAuctionListByCategory(int categoryId);

	List<Auction> searchAuctionList(String keywords);

	List<Auction> getAllAuctionList();

}