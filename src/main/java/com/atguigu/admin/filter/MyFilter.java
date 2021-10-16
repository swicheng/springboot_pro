package com.atguigu.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;

/**
 * @author Ëï
 * @data 2021-8-14
 * 
 */

//@WebFilter(urlPatterns = {"/*"} , initParams={@WebInitParam(name="test", value="true")})
public class MyFilter implements Filter{

	 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---->"+filterConfig.getInitParameter("test"));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("-------->Ïú»Ù");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 System.out.println("¹ıÂËÆ÷");
		 chain.doFilter(request, response);
	}

	
	
	
}
