package com.mao.blogredissystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.mao.blogredissystem.dao.BlogDao;
import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void saveBlog(Blog blog) {
        Blog newBlog = blogDao.save(blog);
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
}
