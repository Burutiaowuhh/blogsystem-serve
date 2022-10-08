package com.mao.blogredissystem.dao;

import com.mao.blogredissystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @Classname UserDao
 * @Date 2022/10/8 15:46
 * @Created by mao
 * @Description
 */
public interface UserDao extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    User findByToken(String token);

}
