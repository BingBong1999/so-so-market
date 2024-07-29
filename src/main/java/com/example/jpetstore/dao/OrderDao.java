package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Order;

public interface OrderDao {

	Order getOrder(int orderId) throws DataAccessException;

	Order getOrderBySeller(int orderId) throws DataAccessException;

	Order getOrderByBuyer(int orderId) throws DataAccessException;

	void insertOrder(Order order) throws DataAccessException;

	void updateOrderStatus(Order order) throws DataAccessException;

	List<Order> getOrderListBySeller(String accountId) throws DataAccessException;

	List<Order> getOrderListByBuyer(String accountId) throws DataAccessException;

}