package com.example.jpetstore.controller;

import java.io.Serializable;
import com.example.jpetstore.domain.Bidding;

@SuppressWarnings("serial")
public class BiddingForm implements Serializable {

	private Bidding bidding;

	public BiddingForm(Bidding bidding) {
		this.bidding = bidding;
	}

	public void setBiddingForm(Bidding bidding) {
		this.bidding = bidding;
	}

	public BiddingForm() {
		this.bidding = new Bidding();
	}

	public Bidding getBidding() {
		return bidding;
	}

	public void setProductId(int productId) {
		bidding.setProductId(productId);
	}

	public void setBuyerId(String buyerId) {
		bidding.setBuyerId(buyerId);
	}

	@Override
	public String toString() {
		return "BiddingForm [bidding=" + bidding + "]";
	}
}