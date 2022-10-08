package com.mao.blogredissystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.mao.blogredissystem.dao.BlogDao;
import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.entity.User;
import com.mao.blogredissystem.model.Constants;
import com.mao.blogredissystem.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Classname BlogService
 * @Date 2022/10/8 14:20
 * @Created by mao
 * @Description
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveBlog(Blog blog) {
        Blog newBlog = blogDao.save(blog);
        redisTemplate.opsForHash().put(Constants.BLOG_LIKE_COUNT_HASH, String.valueOf(newBlog.getId()), 0);
        log.info("保存博客，newBlog:{}", JSON.toJSONString(newBlog));
    }

    @Override
    public Blog getBlogById(Long id) {
        Optional<Blog> optional = blogDao.findById(id);
        boolean present = optional.isPresent();
        if (present) {
            return optional.get();
        }
        return null;
    }

    @Override
    public boolean addLikeCount(User user, Long blogId) {
        Long count = redisTemplate.opsForHash().increment(Constants.BLOG_LIKE_COUNT_HASH, String.valueOf(blogId), 1);
        if (count > 0) {
            Integer addCount = blogDao.updateLikeCount(blogId);
            return true;
        }
        return false;
    }

}
