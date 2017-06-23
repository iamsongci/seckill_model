package com.topone.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topone.util.SerializaUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class DescriptionResdisCache implements Cache {
	private static Logger logger = LoggerFactory.getLogger(DescriptionResdisCache.class);
	private Jedis redisClient = createReids();
	/** The ReadWriteLock. */
	private static JedisPool pool=new JedisPool("45.76.216.116");
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
		int i = Integer.valueOf(redisClient.dbSize().toString());
		return i;

	}

	@Override
	public void putObject(Object key, Object value) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
		redisClient.set(SerializaUtil.serialize(this.getClass().getName() + key.toString()),
				SerializaUtil.serialize(value));
		redisClient.expire(SerializaUtil.serialize(this.getClass().getName() + key.toString()), 70000);
	}

	@Override
	public Object getObject(Object key) {
		Object value = SerializaUtil
				.unserialize(redisClient.get(SerializaUtil.serialize(this.getClass().getName() + key.toString())));
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
		return pool.getResource();
	}

}
