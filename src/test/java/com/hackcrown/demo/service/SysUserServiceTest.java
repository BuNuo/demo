package com.hackcrown.demo.service;

import com.hackcrown.demo.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;


    @Test
    public void insert() {
        SysUser user = new SysUser();
        user.setUsername("bunuo");
        user.setPassword("123456");
        user.setAge(18);
        user.setSex("1");
        user.setPhone("123456789");
        sysUserService.insert(user);
    }

    @Test
    public void getList() {
        System.out.print(sysUserService.getList());
    }
}