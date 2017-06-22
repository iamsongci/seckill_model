package com.topone.model;

import com.topone.entry.Stock;

public interface StockModel {
	/**
	 * 添加一个库存
	 * 
	 * @param ss
	 * @return
	 */
	Integer add(Stock ss);

	/**
	 * 更新库存
	 * 
	 * @param ss
	 * @return
	 */
	Integer update(int id, int count);

	/**
	 * 获取一个库存
	 * 
	 * @param id
	 * @return
	 */
	Stock getById(int id);

	/**
	 * 减库存操作
	 * 
	 * @param id
	 * @param count
	 * @return
	 */
	Integer buyCommodity(int id, int count);

}
