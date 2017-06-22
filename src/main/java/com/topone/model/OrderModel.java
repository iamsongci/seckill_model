package com.topone.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.topone.entry.Order;

public interface OrderModel {
	/**
	 * 添加一个订单
	 * 
	 * @param o
	 * @return
	 */
	Integer add(Order o);

	/**
	 * 更新订单状态,
	 * 
	 * @param id
	 * @param orderStats
	 *            1为付款
	 * @return
	 */
	Integer update(int id, int orderStats);

	/**
	 * 
	 * @param a
	 * @param b
	 * @param nuyId
	 * @return
	 */
	List<Order> getAll(int a, int b, int nuyId);

	/**
	 * 按照买家统计订单数量
	 * 
	 * @param buyId
	 * @return
	 */
	Integer countByBuyId(int buyId);

	/**
	 * 获取店铺的全部订单
	 * 
	 * @param a
	 *            起始
	 * @param b
	 *            结束
	 * @param shellerId
	 *            卖家ID
	 * @return
	 */
	List<Order> getAllBySheller(@Param("a") int a, @Param("b") int b, @Param("shellerId") int shellerId);

	/**
	 * 统计卖家订单个数
	 * 
	 * @param shellerId
	 * @return
	 */
	Integer countByShellerId(int shellerId);
}
