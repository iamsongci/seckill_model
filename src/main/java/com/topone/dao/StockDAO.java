package com.topone.dao;

import org.apache.ibatis.annotations.Param;

import com.topone.entry.Stock;

public interface StockDAO {

	Integer add(Stock ss);

	Integer update(@Param("id") int id, @Param("count") int count);

	Stock getById(int id);

	Integer buyCommodity(@Param("id") int id, @Param("count") int count);
}
