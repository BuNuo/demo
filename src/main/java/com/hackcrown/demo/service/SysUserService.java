package com.hackcrown.demo.service;

import com.hackcrown.demo.domain.SysUser;

import java.util.List;


public interface SysUserService {

    void insert(SysUser sysUser);

    List<SysUser> getList();

    SysUser getById(Integer id);

    void update(SysUser sysUser);

    void delete(Integer id);

}
