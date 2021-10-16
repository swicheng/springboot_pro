package com.atguigu.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author 孙
 * @data 2021-8-12
 * 
    *   登陆检查
    1. 配置好拦截器要拦截那些请求
    2. 把这些配置放在容器中
 * 
 */

public class LoginInterceptor implements HandlerInterceptor{

	// 目标方法执行前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
     
	    HttpSession session = request.getSession();
	    
	    Object loginUser = session.getAttribute("loginUser");
	
	    if (loginUser != null) {
			return true;
		}else {
			session.setAttribute("msg", "用户未登陆");
			response.sendRedirect("/login");
			return false;
		}
	}

	// 目标方法执行之后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub


	}
	
	
	
    // 目标方法渲染之后执行 也就是响应给前端之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}

	
	
	
}
