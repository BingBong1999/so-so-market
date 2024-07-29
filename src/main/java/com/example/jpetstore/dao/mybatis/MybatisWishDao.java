package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.WishDao;
import com.example.jpetstore.dao.mybatis.mapper.WishMapper;
import com.example.jpetstore.domain.Wish;

@Repository
public class MybatisWishDao implements WishDao {

	@Autowired
	private WishMapper wishMapper;

	public Wish getWish(int wishId) throws DataAccessException {
		return wishMapper.getWish(wishId);
	}

	public Wish getWish(String accountId, int productId) throws DataAccessException {
		return wishMapper.getWishByAccountAndProduct(accountId, productId);
	}

	public List<Wish> getWishListByUser(String accountId) throws DataAccessException {
		return wishMapper.getWishListByUser(accountId);
	}

	public List<Wish> getWishListAuctionByUser(String accountId) throws DataAccessException {
		return wishMapper.getWishListAuctionByUser(accountId);
	}

	public void insertWish(Wish wish) throws DataAccessException {
		wishMapper.insertWish(wish);
	}

	public void deleteWish(int productId) throws DataAccessException {
		wishMapper.deleteWish(productId);
	}
}