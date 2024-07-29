package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Bidding;

public interface BiddingMapper {

	Bidding getBidding(int biddingId);

	void insertBidding(Bidding bidding);

	void updateBidding(Bidding bidding);

	List<Bidding> getBiddingsByUser(String accountId);

	List<Bidding> getBiddingsByAuction(int auctionId);
}
