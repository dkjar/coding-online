package com.dragon.codingol.web.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
 

@Component
public class CacheInterceptor {

	@Autowired
	private RedisTemplate redisTemplate;
	
	

}
