package com.topone.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import com.topone.cache.AbstractBaseRedisDao;
import com.topone.cache.CommodityCache;
import com.topone.entry.Commodity;
import com.topone.util.SerializaUtil;

public class CommodityCacheImpl extends AbstractBaseRedisDao<String, Object> implements CommodityCache {

	/**
	 * 新增 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(final Commodity commodity) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {

				connection.setEx(SerializaUtil.serialize("commodity:" + commodity.getId()), 1800000L,
						SerializaUtil.serialize(commodity));
				return null;
			}
		});
		return result;
	}

	/**
	 * 删除 <br>
	 * ------------------------------<br>
	 * 
	 * @param key
	 */
	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}

	/**
	 * 删除多个 <br>
	 * ------------------------------<br>
	 * 
	 * @param keys
	 */
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 修改 <br>
	 * ------------------------------<br>
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(final Commodity commodity) {

		if (commodity.getId() == 0) {
			throw new NullPointerException("数据行不存在, key = " + commodity.getId());
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.setEx(SerializaUtil.serialize("commodity" + commodity.getId()), 1800000L,
						SerializaUtil.serialize(commodity));
				return true;
			}
		});
		return result;
	}

	/**
	 * 通过key获取 <br>
	 * ------------------------------<br>
	 * 
	 * @param keyId
	 * @return
	 */
	public Commodity get(final int keyId) {
		Commodity result = redisTemplate.execute(new RedisCallback<Commodity>() {
			public Commodity doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] value = connection.get(SerializaUtil.serialize("commodity" + keyId));
				if (value == null) {
					return null;
				}
				return (Commodity) SerializaUtil.unserialize(value);
			}
		});
		return result;
	}
}