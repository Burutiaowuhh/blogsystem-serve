package com.mao.blogredissystem.service;

import com.mao.blogredissystem.dao.UserDao;
import com.mao.blogredissystem.entity.User;
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
    @Autowired
    private UserDao userDao;

    public void addObject(String name) {
        redisTemplate.opsForValue().set("name", name);
    }

    public User getUserByToken(String token) {
        Object user = redisTemplate.opsForValue().get(token);
        if (null == user) {
            User user1 = userDao.findByToken(token);
            return user1;
        }
        return null;
    }

}
