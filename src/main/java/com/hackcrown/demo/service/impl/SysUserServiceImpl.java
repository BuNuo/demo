package com.hackcrown.demo.service.impl;

import com.hackcrown.demo.dao.SysUserMapper;
import com.hackcrown.demo.domain.SysUser;
import com.hackcrown.demo.enums.ResultEnum;
import com.hackcrown.demo.exception.DemoException;
import com.hackcrown.demo.service.SysUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
	
	private final static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserDao;

    @Transactional
    @Override
    public SysUser insert(SysUser sysUser) {
    	int flag = 0;
    	try {
    		flag = sysUserDao.insert(sysUser);
            if(flag < 1) {
            	throw new DemoException(ResultEnum.UNKONW_ERROR);
            } 
			
		} catch (Exception e) {
			sysUser = null;
			logger.error(e.getMessage());
		}
        return sysUser;
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
    
    @Transactional
	@Override
	public int insertTwo() throws Exception {
		int flag = 0;
		try {
			SysUser user1 = new SysUser();
	    	user1.setUsername("bunuo");
	    	user1.setPassword("123456");
	    	user1.setSex("1");
	    	user1.setAge(18);
	    	user1.setPhone("13717740306");
	    	flag = sysUserDao.insert(user1);
	    	if(flag < 1) {
	    		throw new DemoException(ResultEnum.SYSTEM_ERROR);
	    	}
	    	
	    	SysUser user2 = new SysUser();
	    	user2.setUsername("hzx");
	    	//user2.setPassword("666666");
	    	user2.setSex("1");
	    	user2.setAge(18);
	    	user2.setPhone("13717740306");
	    	flag = sysUserDao.insert(user2);
	    	if(flag < 1) {
	    		throw new DemoException(ResultEnum.SYSTEM_ERROR);
	    	}
		} catch (Exception e) {
			logger.error(e.getMessage());
			flag = 0;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
    	return flag;
	}

}
