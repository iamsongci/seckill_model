package com.topone.model;

import java.util.List;

import com.topone.entry.Shopping;

public interface ShoppingModel {
	/**
	 * 添加一个购物车
	 * 
	 * @param s
	 * @return
	 */
	Integer add(Shopping s);

	/**
	 * 获取一个账户的购物车
	 * 
	 * @param buyId
	 * @return
	 */
	List<Shopping> getByBuy(int buyId);

	/**
	 * 按照ID获取购物车信息
	 * 
	 * @param id
	 * @return
	 */
	Shopping getById(int id);

	/**
	 * 删除一个购物车，用于购物车付款
	 * 
	 * @param id
	 * @return
	 */
	Integer delect(int id);
}
