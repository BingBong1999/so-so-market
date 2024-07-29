package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Wish;

public interface WishDao {

	Wish getWish(int productId) throws DataAccessException;

	Wish getWish(String accountId, int productId) throws DataAccessException;

	List<Wish> getWishListByUser(String accountId) throws DataAccessException;

	List<Wish> getWishListAuctionByUser(String accountId) throws DataAccessException;

	void insertWish(Wish wish) throws DataAccessException;

	void deleteWish(int productId) throws DataAccessException;

}