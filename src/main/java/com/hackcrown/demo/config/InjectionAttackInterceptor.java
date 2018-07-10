package com.hackcrown.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thymeleaf.util.MapUtils;
import com.hackcrown.demo.aspect.HttpAspect;
import com.hackcrown.demo.utils.RequestUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * 注入攻击拦截器
 */
public class InjectionAttackInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


	private InjectionAttackHandler injectionAttackHandler = DefaultInjectionAttackHandler.getInstance();

	@Override
	public boolean preHandle ( HttpServletRequest request , 
			HttpServletResponse response , Object handler ) throws	Exception {
		if ( ! ( handler instanceof HandlerMethod ) ) {
			return false;
		}

		String[] ignoreStrings = null;

		final String parameters = RequestUtils.getRequestParameters( request );
		logger.info( "请求参数 : {} " , parameters );
		logger.info( "ignoreStrings : {} " , Arrays.toString( ignoreStrings ) );


		// 参数注入攻击处理
		if ( this.injectionAttackHandler.isInjectionAttack( parameters , ignoreStrings ) ) {
			logger.info( "参数 {} 被判断为注入攻击" , parameters );
			this.injectionAttackHandler.attackHandle( request , response , parameters );
			return false;
		}

		final Map< String, String > decodedUriVariables = ( Map< String, String > ) request.getAttribute( HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE );

		if ( MapUtils.isEmpty( decodedUriVariables ) ) {
			return true;
		}

		// URI PATH 注入攻击处理
		for ( String decodedUriVariable : decodedUriVariables.values() ) {
			if ( this.injectionAttackHandler.isInjectionAttack( decodedUriVariable , ignoreStrings ) ) {
				logger.info( "URI {} 被判断为注入攻击" , parameters );
				this.injectionAttackHandler.attackHandle( request , response , decodedUriVariable );
				return false;
			}
		}
		return true;
	}
}
