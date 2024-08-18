package com.example.jpetstore.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.scheduler.dao.EventDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

@Service
@Transactional
public class SchedulerService {

	@Autowired
	private EventDao eventDao;

	@Autowired
	private TaskScheduler scheduler;

	@Autowired
	private SosoMarketFacade sosomarket;

	public void setSosomarket(SosoMarketFacade sosomarket) {
		this.sosomarket = sosomarket;
	}

	public void taskScheduler(Date closingTime, int auctionId) {

		Runnable updateTableRunner = new Runnable() {
			
			@Override
			public void run() {
			
				Date curTime = new Date();
				Order order = new Order();

				Auction auction = sosomarket.getAuction(auctionId);
				Product product = sosomarket.getProduct(auctionId);
				
				String currentPriceBuyerId = auction.getCurrentPriceBuyerId();
				Account account = sosomarket.getAccount(currentPriceBuyerId);

				
				product.setProductStatus("done");
				sosomarket.updateProductStatus(product);
				
				order.setProductId(auction.getAuctionId());
				order.initOrder(account);
				order.setBuyerId(currentPriceBuyerId);
				
				sosomarket.insertOrder(order);
				sosomarket.deleteBidding(auction.getAuctionId());

				eventDao.closeEvent(curTime);
			}
		};

		HashMap<String, Date> hashMap = new HashMap<String, Date>();
		hashMap.put("curTime", new Date());
		hashMap.put("closingTime", closingTime); 
		
		eventDao.insertNewEvent(hashMap); 
		
		scheduler.schedule(updateTableRunner, closingTime);
	}
}

// test text