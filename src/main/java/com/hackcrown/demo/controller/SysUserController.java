package com.hackcrown.demo.controller;

import com.hackcrown.demo.domain.Result;
import com.hackcrown.demo.domain.SysUser;
import com.hackcrown.demo.enums.ResultEnum;
import com.hackcrown.demo.exception.DemoException;
import com.hackcrown.demo.service.SysUserService;
import com.hackcrown.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public Result<SysUser> getById(@PathVariable("id") Integer id) {
    	SysUser user = sysUserService.getById(id);
    	if(user == null) {
    		throw new DemoException(ResultEnum.SYSUSER_NULL);
    	}
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<SysUser>> getUserList() {
        return ResultUtil.success(sysUserService.getList());
    }

    @PostMapping(value = "/addUser")
    public Result<?> insert(@RequestBody SysUser sysUser) throws Exception{
        SysUser user = sysUserService.insert(sysUser);
        if(user == null) {
        	throw new DemoException(ResultEnum.UNKONW_ERROR);
        }
        return ResultUtil.success(user);
    }
    
    @PostMapping(value = "/addTwo")
    public Result<?> insertTwo(@RequestBody SysUser sysUser) throws Exception {
        int result = sysUserService.insertTwo();
        if(result < 1) {
        	throw new DemoException(ResultEnum.UNKONW_ERROR);
        }
        return ResultUtil.success();
    }

    @PostMapping(value = "/updateUser")
    public void update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        sysUserService.delete(id);
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
    	return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
    	return new ModelAndView("index");
    }
}
