package com.topone.mode.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.ShoppingDAO;
import com.topone.entry.Shopping;
import com.topone.model.ShoppingModel;

public class ShoppingModelImpl implements ShoppingModel {
	@Autowired
	private ShoppingDAO shoppingDAO;

	public Integer add(Shopping s) {
		return this.shoppingDAO.add(s);
	}

	public List<Shopping> getByBuy(int buyId) {
		return this.shoppingDAO.getByBuy(buyId);
	}

	public Shopping getById(int id) {
		return this.shoppingDAO.getById(id);
	}

	public Integer delect(int id) {
		return this.shoppingDAO.delete(id);
	}

}
