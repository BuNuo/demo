package com.hackcrown.demo.service;

import com.hackcrown.demo.domain.SysUser;

import java.util.List;


public interface SysUserService {

	SysUser insert(SysUser sysUser);

    List<SysUser> getList();

    SysUser getById(Integer id);

    void update(SysUser sysUser);

    void delete(Integer id);
    
    int insertTwo() throws Exception;

}
