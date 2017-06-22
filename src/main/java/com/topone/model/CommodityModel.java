package com.topone.model;

import java.util.List;

import com.topone.entry.Commodity;

public interface CommodityModel {
	/**
	 * 添加一个商品
	 * 
	 * @param c
	 * @return
	 */
	Integer add(Commodity c);

	/**
	 * 更新商品详情
	 * 
	 * @param c
	 * @return
	 */
	Integer update(Commodity c);

	/**
	 * 按照类型获取分页获取商品
	 * 
	 * @param a
	 * @param b
	 * @param type
	 * @return
	 */
	List<Commodity> getByType(int a, int b, int type);

	/**
	 * 按照ID获取商品
	 * 
	 * @param id
	 * @return
	 */
	Commodity getById(int id);

	/**
	 * 获取全部的商品（分页）
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	List<Commodity> getByAll(int a, int b);
	/**
	 * 按照类型获取商品数量
	 * @param type true秒杀，false非秒杀
	 * @return
	 */
	Integer countByType(boolean type);
	/**
	 * 获取店铺商品
	 * @param sellerId
	 * @return
	 */
	List<Commodity> getBySellerId(int sellerId);

}
