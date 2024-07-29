package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import com.example.jpetstore.domain.Order;

public interface OrderMapper {

	Order getOrder(int orderId);

	Order getOrderBySeller(int orderId);

	Order getOrderByBuyer(int orderId);

	void insertOrder(Order order);

	void updateOrderStatus(Order order);

	List<Order> getOrderListBySeller(String accountId);

	List<Order> getOrderListByBuyer(String accountId);

}
