package com.mao.blogredissystem.dao;

import com.mao.blogredissystem.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname BlogDao
 * @Date 2022/10/8 14:17
 * @Created by mao
 * @Description
 */
public interface BlogDao extends JpaRepository<Blog, Long> {


}
