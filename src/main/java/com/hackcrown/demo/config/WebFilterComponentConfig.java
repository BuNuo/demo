package com.hackcrown.demo.config;

import javax.servlet.Filter;

import com.hackcrown.demo.config.filter.InjectionAttackFilter;
import com.hackcrown.demo.config.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFilterComponentConfig {
	
	@Bean
	public FilterRegistrationBean<SessionFilter> sessionFilterRegistration() {
	    FilterRegistrationBean<SessionFilter> registration = new FilterRegistrationBean<SessionFilter>();
	    registration.setFilter(new SessionFilter());
	    registration.addUrlPatterns("/*");
	    registration.addInitParameter("paramName", "paramValue");
	    registration.setName("sessionFilter");
	    registration.setOrder(2);
	    return registration;
	}
	
	@Bean
	public FilterRegistrationBean<InjectionAttackFilter> injectionAttackFilterRegistration() {
	    FilterRegistrationBean<InjectionAttackFilter> registration = new FilterRegistrationBean<InjectionAttackFilter>();
	    registration.setFilter(new InjectionAttackFilter());
	    registration.addUrlPatterns("/*");
	    registration.setName("injectionAttackFilter");
	    registration.setOrder(1);
	    return registration;
	}
	
	@Bean(name = "sessionFilter")
    public Filter sessionFilter() {
        return new SessionFilter();
    }

}
