package com.hackcrown.demo.config;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Resource
	private LoginInterceptor loginInterceptor;


    public WebConfig(){
        super();
    }

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 自定义拦截器，添加拦截路径和排除拦截路径
    	InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor);
    	
    	//排除的路径
    	interceptor.excludePathPatterns("/");
    	interceptor.excludePathPatterns("/login");
    	interceptor.excludePathPatterns("/static/*");
    	
    	//需要拦截的路径
    	interceptor.addPathPatterns("/**");
	}

}
