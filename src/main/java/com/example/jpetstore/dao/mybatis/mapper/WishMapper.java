package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Wish;

public interface WishMapper {

	Wish getWish(int wishId);

	Wish getWishByAccountAndProduct(String accountId, int productId);

	List<Wish> getWishListByUser(String accountId);

	List<Wish> getWishListAuctionByUser(String accountId);

	void insertWish(Wish wish);

	void deleteWish(int wishId);

}