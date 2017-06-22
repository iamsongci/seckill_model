package com.topone.mode.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.OrderDAO;
import com.topone.entry.Order;
import com.topone.model.OrderModel;

public class OrderModelImpl implements OrderModel {
	@Autowired
	private OrderDAO orderDAO;

	public Integer add(Order o) {
		return this.orderDAO.add(o);
	}

	public Integer update(int id, int orderStats) {
		return this.orderDAO.update(id, orderStats);
	}

	public List<Order> getAll(int a, int b, int buyId) {
		return this.orderDAO.getAll(a, b, buyId);
	}

	public Integer countByBuyId(int buyId) {
		return this.orderDAO.countByBuyId(buyId);
	}

	public List<Order> getAllBySheller(int a, int b, int shellerId) {
		return this.orderDAO.getAllBySheller(a, b, shellerId);
	}

	public Integer countByShellerId(int shellerId) {
		return this.orderDAO.countByShellerId(shellerId);
	}

}
