package com.lhs.rzBlog;

import com.lhs.rzBlog.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-05
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void loadUserByUsernameTest() {
        String expectedPassword = "202cb962ac59075b964b07152d234b70";
        UserDetails user = userService.loadUserByUsername("fengqingyang");
        String actualPassword = user.getPassword();
        Assert.assertEquals(expectedPassword, actualPassword);
    }
}
