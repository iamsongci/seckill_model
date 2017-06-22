package com.topone.model;

import com.topone.entry.Description;

public interface DescriptionModel {
	/**
	 * 添加一个商品详情
	 * 
	 * @param sd
	 * @return
	 */
	Integer add(Description ds);

	/**
	 * 更新商品详情
	 * 
	 * @param id
	 * @param description
	 * @return
	 */
	Integer update(Description ds);

	/**
	 * 按照ID查询详情
	 * 
	 * @param id
	 * @return
	 */
	Description getById(int id);

}
