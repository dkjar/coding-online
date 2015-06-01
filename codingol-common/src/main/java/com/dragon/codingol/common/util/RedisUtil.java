package com.dragon.codingol.common.util;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {
	
	@Autowired
	private JedisPool jedisPool;
	 
	public boolean saveObject(String key, Object o){
		Jedis jedis = jedisPool.getResource();
		jedis.set(key.getBytes(), SerializingUtil.serialize(o));  
		jedisPool.returnResource(jedis);
		return true;
	}
	
	public Object findObject(String key){
		Jedis jedis = jedisPool.getResource();
		Object o =  SerializingUtil.deserialize(jedis.get(key.getBytes()));  
		jedisPool.returnResource(jedis);
		return o;
	}
}
