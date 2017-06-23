package com.topone.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topone.util.SerializaUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class DescriptionResdisCache implements Cache{
	private static Logger logger = LoggerFactory.getLogger(DescriptionResdisCache	.class);
	private Jedis redisClient = createReids();
	/** The ReadWriteLock. */
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public DescriptionResdisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID未空");
		}
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {

		return Integer.valueOf(redisClient.dbSize().toString());
	}

	@Override
	public void putObject(Object key, Object value) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
		System.out.println("set");
		redisClient.set(SerializaUtil.serialize(this.getClass().getName()+key.toString()), SerializaUtil.serialize(value));
	}

	@Override
	public Object getObject(Object key) {
		Object value = SerializaUtil.unserialize(redisClient.get(SerializaUtil.serialize(this.getClass().getName()+key.toString())));
		System.out.println("get");
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value);
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		return redisClient.expire(SerializaUtil.serialize(key.toString()), 0);
	}

	@Override
	public void clear() {
		redisClient.flushDB();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	protected static Jedis createReids() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "45.76.216.116");
		return pool.getResource();
	}

}
