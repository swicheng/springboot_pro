package com.atguigu.admin.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.pagehelper.PageInterceptor;

/**
 * @author 孙
 * @data 2021-8-16
 * 
 */

@Configuration
public class MyBatisConfig {

	
	
	@Bean
	public PageInterceptor interceptor() {
	
		return new PageInterceptor();
	}
	
	
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		
		MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
		
		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
		paginationInnerInterceptor.setOverflow(true);
		paginationInnerInterceptor.setMaxLimit(5l);
		
		mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
		
		return mybatisPlusInterceptor;
	}
	
}
