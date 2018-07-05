package com.hackcrown.demo.dao;

import com.hackcrown.demo.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser sysUser);

    int insertSelective(SysUser sysUser);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);

    List<SysUser> getList();
}