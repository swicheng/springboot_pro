package com.atguigu.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 孙
 * @data 2021-9-20
 * 
 */

@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor{

	
	@Autowired
	private StringRedisTemplate template;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		template.opsForValue().increment(request.getRequestURI());
		
		return true;
	}

	
	
}
