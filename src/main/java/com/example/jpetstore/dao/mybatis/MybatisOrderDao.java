package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.mybatis.mapper.OrderMapper;
import com.example.jpetstore.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {

	@Autowired
	protected OrderMapper orderMapper;

	public Order getOrder(int orderId) throws DataAccessException {
		return orderMapper.getOrder(orderId);
	}

	public Order getOrderBySeller(int orderId) throws DataAccessException {
		return orderMapper.getOrderBySeller(orderId);
	}

	public Order getOrderByBuyer(int orderId) throws DataAccessException {
		return orderMapper.getOrderByBuyer(orderId);
	}

	public void insertOrder(Order order) throws DataAccessException {
		orderMapper.insertOrder(order);
	}

	public void updateOrderStatus(Order order) throws DataAccessException {
		orderMapper.updateOrderStatus(order);
	}

	public List<Order> getOrderListBySeller(String accountId) throws DataAccessException {
		return orderMapper.getOrderListBySeller(accountId);
	}

	public List<Order> getOrderListByBuyer(String accountId) throws DataAccessException {
		return orderMapper.getOrderListByBuyer(accountId);
	}
}