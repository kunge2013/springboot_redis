package com.fangkun.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @RequestMapping("/sayHello")
    public String hello(){
        String obj = (String)redisTemplate.opsForValue().get("test00000");
        System.out.println(obj);
        return "hello world !";
    }

}
