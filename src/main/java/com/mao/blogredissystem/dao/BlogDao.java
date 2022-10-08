package com.mao.blogredissystem.dao;

import com.mao.blogredissystem.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname BlogDao
 * @Date 2022/10/8 14:17
 * @Created by mao
 * @Description
 */
public interface BlogDao extends JpaRepository<Blog, Long> {

    @Transactional
    @Modifying
    @Query("update Blog set likeCount = likeCount + 1 where id = ?1")
    Integer updateLikeCount(Long blogId);

}
