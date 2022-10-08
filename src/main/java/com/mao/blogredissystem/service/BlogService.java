package com.mao.blogredissystem.service;

import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.entity.User;

/**
 * @Classname BlogService
 * @Date 2022/10/8 14:21
 * @Created by mao
 * @Description
 */
public interface BlogService {

    void saveBlog(Blog blog);

    Blog getBlogById(Long id);

    /**
     * 更新点赞数
     *
     * @param user
     * @param blogId
     */
    boolean addLikeCount(User user, Long blogId);
}
