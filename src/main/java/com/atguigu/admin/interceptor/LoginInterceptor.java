package com.atguigu.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ��
 * @data 2021-8-12
 * 
    *   ��½���
    1. ���ú�������Ҫ������Щ����
    2. ����Щ���÷���������
 * 
 */

public class LoginInterceptor implements HandlerInterceptor{

	// Ŀ�귽��ִ��ǰִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
     
	    HttpSession session = request.getSession();
	    
	    Object loginUser = session.getAttribute("loginUser");
	
	    if (loginUser != null) {
			return true;
		}else {
			session.setAttribute("msg", "�û�δ��½");
			response.sendRedirect("/login");
			return false;
		}
	}

	// Ŀ�귽��ִ��֮��ִ��
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub


	}
	
	
	
    // Ŀ�귽����Ⱦ֮��ִ�� Ҳ������Ӧ��ǰ��֮��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}

	
	
	
}
