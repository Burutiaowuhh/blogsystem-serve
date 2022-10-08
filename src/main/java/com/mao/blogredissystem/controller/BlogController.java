package com.mao.blogredissystem.controller;

import com.mao.blogredissystem.core.annotations.UserOperationAnnotation;
import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.entity.User;
import com.mao.blogredissystem.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname BlogController
 * @Date 2022/10/8 15:10
 * @Created by mao
 * @Description
 */
@RestController
@UserOperationAnnotation
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/like/{blogId}", method = RequestMethod.PUT)
    public Object giveLike(User user, @PathVariable("blogId") Long blogId) {
        boolean update = blogService.addLikeCount(user, blogId);
        if (update) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

}
