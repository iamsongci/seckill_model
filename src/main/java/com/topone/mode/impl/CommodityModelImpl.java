package com.topone.mode.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.CommodityDAO;
import com.topone.entry.Commodity;
import com.topone.model.CommodityModel;

public class CommodityModelImpl implements CommodityModel {
	@Autowired
	private CommodityDAO commodityDAO;

	public int add(Commodity c) {
		return this.commodityDAO.add(c);
	}

	public Integer update(Commodity c) {
		return this.commodityDAO.update(c);
	}

	public List<Commodity> getByType(int a, int b, int type) {
		return this.commodityDAO.getByType(a, b, type);
	}

	public Commodity getById(int id) {

		return this.commodityDAO.getById(id);
	}

	public List<Commodity> getByAll(int a, int b) {
		return this.commodityDAO.getByAll(a, b);
	}

	public Integer countByType(boolean type) {
		int i = type ? 1 : 0;
		return this.commodityDAO.countByType(i);
	}

	public List<Commodity> getBySellerId(int sellerId) {
		return this.commodityDAO.getBySellerId(sellerId);
	}

}
