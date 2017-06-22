package com.topone.dao;

import java.util.List;

import com.topone.entry.Shopping;

public interface ShoppingDAO {

	Integer add(Shopping s);

	List<Shopping> getByBuy(int buyId);

	Shopping getById(int id);

	Integer delete(int id);
}
