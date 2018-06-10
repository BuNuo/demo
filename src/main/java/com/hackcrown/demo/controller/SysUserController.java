package com.hackcrown.demo.controller;

import com.hackcrown.demo.domain.SysUser;
import com.hackcrown.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: bunuo
 * @Date: 2018/6/9 12:26
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/get/{id}")
    public SysUser getById(@PathVariable("id") Integer id) {
        System.out.println(id);
        System.out.println(sysUserService.getById(id));
        return sysUserService.getById(id);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public List<SysUser> getUserList() {
        return sysUserService.getList();
    }

    @PostMapping(value = "/addUser")
    public void insert(@RequestBody SysUser sysUser) {
        System.out.print(sysUser);
        sysUserService.insert(sysUser);
    }

    @PostMapping(value = "/updateUser")
    public void update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        sysUserService.delete(id);
    }
}
