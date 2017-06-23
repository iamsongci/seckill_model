package com.topone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import com.topone.entry.Commodity;

public interface CommodityDAO {

	@SelectKey(statement="call next value for TestSequence", keyProperty="id",keyColumn="id" ,before=false, resultType=int.class)
	int add(Commodity c);

	Integer update(Commodity c);
	
	Integer countByType(int type);

	List<Commodity> getByType(@Param("a") int a, @Param("b") int b, @Param("type") int type);

	Commodity getById(int id);

	List<Commodity> getByAll(@Param("a") int a, @Param("b") int b);
	
	List<Commodity> getBySellerId(int sellerId);
}
