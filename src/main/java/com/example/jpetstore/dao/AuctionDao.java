package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;

public interface AuctionDao {

	Auction getAuction(int productId) throws DataAccessException;

	void insertAuction(Auction auction) throws DataAccessException;

	void deleteAuction(int productId) throws DataAccessException;

	void updateAuctionCurrentPriceAndBuyerId(Bidding bidding) throws DataAccessException;

	List<Auction> getAuctionListByUser(String accountId) throws DataAccessException;

	List<Auction> getAuctionListByCategory(int categoryId) throws DataAccessException;

	List<Auction> searchAuctionList(String keywords) throws DataAccessException;

	List<Auction> getAllAuctionList() throws DataAccessException;

}