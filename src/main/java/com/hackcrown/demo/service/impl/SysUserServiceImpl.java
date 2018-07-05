package com.hackcrown.demo.service.impl;

import com.hackcrown.demo.dao.SysUserMapper;
import com.hackcrown.demo.domain.SysUser;
import com.hackcrown.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserDao;

    @Transactional
    @Override
    public void insert(SysUser sysUser) {
        sysUserDao.insert(sysUser);
    }

    @Override
    public List<SysUser> getList() {
        return sysUserDao.getList();
    }

    @Override
    public SysUser getById(Integer id) {
        return null;
    }

    @Override
    public void update(SysUser sysUser) {
    }

    @Override
    public void delete(Integer id) {

    }

}
