package com.hackcrown.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.hackcrown.demo.enums.ResultEnum;
import com.hackcrown.demo.exception.DemoException;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Value("$(login-intercepter-switch)")
    private String LoginSwitch;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	if("on".equals(LoginSwitch)) {
    		logger.info("登录拦截！");
    		HttpSession session = request.getSession(true);
            // 判断用户ID是否存在，不存在就跳转到登录界面
            if (session.getAttribute("userId") == null) {
                throw new DemoException(ResultEnum.NOT_LOGIN);
            } else {
                return true;
            }
    	} else {
    		return true;
    	}
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
