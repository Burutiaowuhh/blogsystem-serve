package com.mao.blogredissystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author mao
 * @Date 2022/10/2 20:16
 * @Desc:
 */
@Service
public class UserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addObject(String name) {
        redisTemplate.opsForValue().set("name", name);
    }

    public String getObject(String name) {
        return String.valueOf(redisTemplate.opsForValue().get(name));
    }

}
