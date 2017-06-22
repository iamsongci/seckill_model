package com.topone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.topone.entry.Order;

public interface OrderDAO {
	/**
	 * 添加一个订单
	 * 
	 * @param o
	 * @return
	 */
	Integer add(Order o);

	/**
	 * 更新订单状态
	 * 
	 * @param id
	 * @param orderStats
	 * @return
	 */
	Integer update(@Param("id") int id, @Param("orderStats") int orderStats);

	/**
	 * 查询订单列表
	 * 
	 * @param a
	 *            从a条
	 * @param b
	 *            到b条
	 * @param buyId
	 *            买家ID
	 * @return
	 */
	List<Order> getAll(@Param("a") int a, @Param("b") int b, @Param("buyId") int buyId);

	/**
	 * 统计买家的订单
	 * 
	 * @param buyId
	 *            买家Id
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
	List<Order> getAllBySheller(@Param("a") int a, @Param("b") int b, @Param("sellerId") int shellerId);

	/**
	 * 统计卖家订单个数
	 * 
	 * @param shellerId
	 * @return
	 */
	Integer countByShellerId(int shellerId);
}
