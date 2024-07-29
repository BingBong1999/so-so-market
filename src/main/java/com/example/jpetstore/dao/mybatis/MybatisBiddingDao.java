package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.BiddingDao;
import com.example.jpetstore.dao.mybatis.mapper.BiddingMapper;
import com.example.jpetstore.domain.Bidding;

@Repository
public class MybatisBiddingDao implements BiddingDao {

	@Autowired
	private BiddingMapper biddingMapper;

	public Bidding getBidding(int biddingId) throws DataAccessException {
		return biddingMapper.getBidding(biddingId);
	}

	public void insertBidding(Bidding bidding) throws DataAccessException {
		biddingMapper.insertBidding(bidding);
	}

	public void updateBidding(Bidding bidding) throws DataAccessException {
		biddingMapper.updateBidding(bidding);
	}

	public List<Bidding> getBiddingsByUser(String accountId) throws DataAccessException {
		return biddingMapper.getBiddingsByUser(accountId);
	}

	public List<Bidding> getBiddingsByAuction(int auctionId) throws DataAccessException {
		return biddingMapper.getBiddingsByAuction(auctionId);
	}
}
