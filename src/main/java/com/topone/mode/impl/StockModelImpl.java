package com.topone.mode.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.StockDAO;
import com.topone.entry.Stock;
import com.topone.model.StockModel;

public class StockModelImpl implements StockModel {
	@Autowired
	private StockDAO stockDAO;

	public Integer add(Stock ss) {
		return this.stockDAO.add(ss);
	}

	public Integer update(int id, int count) {
		return this.stockDAO.update(id, count);
	}

	public Stock getById(int id) {
		return this.stockDAO.getById(id);
	}

	public Integer buyCommodity(int id, int count) {
		return this.stockDAO.buyCommodity(id, count);
	}

}
