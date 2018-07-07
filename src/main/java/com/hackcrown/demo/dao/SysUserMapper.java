package com.hackcrown.demo.dao;

import com.hackcrown.demo.domain.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser sysUser);

    int insertSelective(SysUser sysUser);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);

    List<SysUser> getList();
}