package com.hackcrown.demo.dao;

import com.hackcrown.demo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, Integer> {


}
