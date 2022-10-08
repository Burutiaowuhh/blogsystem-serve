package com.mao.blogredissystem;

import com.alibaba.fastjson.JSON;
import com.mao.blogredissystem.entity.Blog;
import com.mao.blogredissystem.service.BlogService;
import com.mao.blogredissystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

@SpringBootTest
class BlogredissystemApplicationTests {

    private Logger logger = LoggerFactory.getLogger(BlogredissystemApplicationTests.class);

    @Test
    void contextLoads() {
    }

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
        String name = userService.getObject("name");
        logger.info("name:{}", name);
    }

//    @Test
//    public void saveBlog() {
//        Blog buildBlog = Blog.builder().title("第一条 blog title").author("毛").content("第一条博客内容").build();
//        blogService.saveBlog(buildBlog);
//    }

    @Test
    public void getBlog() {
        Blog blog = blogService.getBlogById(1L);
        logger.info("收到的blog:{}", JSON.toJSONString(blog));
    }

}
