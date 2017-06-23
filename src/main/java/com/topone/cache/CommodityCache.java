package com.topone.cache;

import com.topone.entry.Commodity;

public interface CommodityCache {
	boolean add(Commodity c);

	void delete(String key);

	boolean update(Commodity c);

	Commodity get(int key);

	

}
