package com.mao.blogredissystem;

import com.mao.blogredissystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogredissystemApplicationTests {

    private Logger logger = LoggerFactory.getLogger(BlogredissystemApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.addObject("mao");
    }


    @Test
    public void getTest() {
        String name = userService.getObject("name");
        logger.info("name:{}", name);
    }

}
