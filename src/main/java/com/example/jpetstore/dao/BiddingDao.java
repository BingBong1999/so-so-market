package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Bidding;

public interface BiddingDao {

	Bidding getBidding(int biddingId) throws DataAccessException;

	void insertBidding(Bidding bidding) throws DataAccessException;

	void updateBidding(Bidding bidding) throws DataAccessException;

	List<Bidding> getBiddingsByUser(String accountId) throws DataAccessException;

	List<Bidding> getBiddingsByAuction(int auctionId) throws DataAccessException;

}