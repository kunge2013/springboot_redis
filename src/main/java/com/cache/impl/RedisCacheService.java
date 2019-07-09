package com.cache.impl;

import com.cache.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheService implements ICacheService {

   final int limit = 10;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void watch(Object key) {
        redisTemplate.watch(key);
       int threoad = Integer.parseInt(redisTemplate.opsForValue().get("key").toString());
       if (threoad < limit) {
           redisTemplate.multi();
           redisTemplate.opsForValue().increment(key);
           redisTemplate.exec();
       } else {
           System.out.println("limit has arrval !");
       }

    }
}
