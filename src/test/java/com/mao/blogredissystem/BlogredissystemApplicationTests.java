package com.mao.blogredissystem;

import com.alibaba.fastjson.JSON;
import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.entity.User;
import com.mao.blogredissystem.service.BlogService;
import com.mao.blogredissystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BlogredissystemApplicationTests {

    private Logger logger = LoggerFactory.getLogger(BlogredissystemApplicationTests.class);


    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Test
    public void test() {
        userService.addObject("mao");
    }


    @Test
    public void getTest() {
        User user = userService.getUserByToken("name");
        logger.info("name:{}", user);
    }

    @Test
    public void saveBlog() {
        Blog buildBlog = Blog.builder().title("第四条 blog title").author("毛").content("第四条博客内容").likeCount(0).build();
        blogService.saveBlog(buildBlog);
    }

    @Test
    public void getBlog() {
        Blog blog = blogService.getBlogById(1L);
        logger.info("收到的blog:{}", JSON.toJSONString(blog));
    }

    @Test
    public void addLikeCount() {
        boolean update = blogService.addLikeCount(new User(), 4L);
        logger.info("update:{}", update);
    }

}
