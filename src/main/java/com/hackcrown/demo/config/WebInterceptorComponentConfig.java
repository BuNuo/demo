package com.hackcrown.demo.config;

import com.hackcrown.demo.config.interceptor.InjectionAttackInterceptor;
import com.hackcrown.demo.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebInterceptorComponentConfig implements WebMvcConfigurer {

    public WebInterceptorComponentConfig(){
        super();
    }

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	/****************************start*****************************/
    	// 登录拦截器，添加拦截路径和排除拦截路径
    	InterceptorRegistration injectionAttackInterceptorRegistration = registry.addInterceptor(injectionAttackInterceptor());
    	
    	//排除的路径
    	
    	//需要拦截的路径
    	injectionAttackInterceptorRegistration.addPathPatterns("/**");
    	/****************************end*****************************/
    	
    	/****************************start*****************************/
		// 登录拦截器，添加拦截路径和排除拦截路径
    	InterceptorRegistration loginInterceptorRegistration = registry.addInterceptor(loginInterceptor());
    	
    	//排除的路径
    	loginInterceptorRegistration.excludePathPatterns("/");
    	loginInterceptorRegistration.excludePathPatterns("/login");
    	loginInterceptorRegistration.excludePathPatterns("/static/*");
    	
    	//需要拦截的路径
    	loginInterceptorRegistration.addPathPatterns("/**");
    	/****************************end*****************************/
	}
    
    @Bean
    public LoginInterceptor loginInterceptor() {
    	return new LoginInterceptor();
    } 
    
    @Bean
    public InjectionAttackInterceptor injectionAttackInterceptor() {
    	return new InjectionAttackInterceptor();
    }

}
