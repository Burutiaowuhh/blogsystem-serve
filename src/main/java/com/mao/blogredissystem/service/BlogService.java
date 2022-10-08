package com.mao.blogredissystem.service;

import com.mao.blogredissystem.entity.Blog;

/**
 * @Classname BlogService
 * @Date 2022/10/8 14:21
 * @Created by mao
 * @Description
 */
public interface BlogService {

    void saveBlog(Blog blog);

    Blog getBlogById(Long id);

}
