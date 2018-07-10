package com.hackcrown.demo.config.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.hackcrown.demo.enums.ResultEnum;
import com.hackcrown.demo.exception.DemoException;

public class SessionFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	
	@Value("$(login-filter-switch)")
    private String LoginSwitch;
	
	/**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		patterns.add(Pattern.compile("login/index.html"));
        patterns.add(Pattern.compile("login/login"));
        patterns.add(Pattern.compile(".*[(\\.js)||(\\.css)||(\\.png)]"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if ("on".equals(LoginSwitch)) {
        	if (url.startsWith("/") && url.length() > 1) {
                url = url.substring(1);
            }
            if (isInclude(url)){
                chain.doFilter(httpRequest, httpResponse);
            } else {
                HttpSession session = httpRequest.getSession();
                if (session.getAttribute("user") != null){
                    chain.doFilter(httpRequest, httpResponse);
                } else {
                	logger.info("用户未登录");
                    throw new DemoException(ResultEnum.NOT_LOGIN);
                }
            }
        } else {
        	chain.doFilter(httpRequest, httpResponse);
        }
	}

	@Override
	public void destroy() {
		
	}
	
	/**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}
