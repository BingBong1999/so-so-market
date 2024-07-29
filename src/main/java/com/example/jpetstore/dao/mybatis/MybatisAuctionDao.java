package com.example.jpetstore.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AuctionDao;
import com.example.jpetstore.dao.mybatis.mapper.AuctionMapper;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Bidding;

@Repository
public class MybatisAuctionDao implements AuctionDao {

	@Autowired
	private AuctionMapper auctionMapper;

	public Auction getAuction(int productId) throws DataAccessException {
		return auctionMapper.getAuction(productId);
	}

	public void insertAuction(Auction auction) throws DataAccessException {
		auctionMapper.insertAuction(auction);
	}

	public void deleteAuction(int productId) throws DataAccessException {
		auctionMapper.deleteAuction(productId);
	}

	public void updateAuctionCurrentPrice(Bidding bidding) throws DataAccessException {
		auctionMapper.updateAuctionCurrentPrice(bidding);
	}

	public void updateAuctionCurrentPriceAndBuyerId(Bidding bidding) {
		auctionMapper.updateAuctionCurrentPriceAndBuyerId(bidding);
	}

	public List<Auction> getAuctionListByUser(String accountId) throws DataAccessException {
		return auctionMapper.getAuctionListByUser(accountId);
	}

	public List<Auction> getAuctionListByCategory(int categoryId) throws DataAccessException {
		return auctionMapper.getAuctionListByCategory(categoryId);
	}

	public List<Auction> searchAuctionList(String keywords) throws DataAccessException {
		return auctionMapper.searchAuctionList("%" + keywords.toLowerCase() + "%");
	}

	public List<Auction> getAllAuctionList() throws DataAccessException {
		return auctionMapper.getAllAuctionList();
	}

	/* Inner Classes */
	public static class AuctionSearch {

		private List<String> keywordList = new ArrayList<String>();

		public AuctionSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords, " ", false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}

		public List<String> getKeywordList() {
			return keywordList;
		}
	}
}