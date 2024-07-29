package com.example.jpetstore.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Auction implements Serializable {

	private int auctionId;
	private Product product;
	private int currentPrice;
	private int startPrice;
	private String currentPriceBuyerId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date deadLine;
	private List<Bidding> biddingList = new ArrayList<Bidding>();

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public void setBiddingList(List<Bidding> biddingList) {
		this.biddingList = biddingList;
	}

	public List<Bidding> getBiddingList() {
		return biddingList;
	}

	public boolean getPriceValidate(String auctionId, int biddingPrice) {
		return true;
	}

	public String getCurrentPriceBuyerId() {
		return currentPriceBuyerId;
	}

	public void setCurrentPriceBuyerId(String currentPriceBuyerId) {
		this.currentPriceBuyerId = currentPriceBuyerId;
	}

	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", product=" + product + ", currentPrice=" + currentPrice
				+ ", startPrice=" + startPrice + ", currentPriceBuyerId=" + currentPriceBuyerId + ", deadLine="
				+ deadLine + ", biddingList=" + biddingList + "]";
	}

}