package com.atguigu.admin.config;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author ��
 * @data 2021-8-15
 * 
 */
@Deprecated
@Configuration
public class DataSourceConfig {

	
//	@ConfigurationProperties("spring.datasource")
//	@Bean
	public DataSource dataSource() {
		
		DruidDataSource druidDataSource = new DruidDataSource();
	
	    try {
			druidDataSource.setFilters("stat,wall");  // ��������ǽ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return druidDataSource;
		
	}
	
	
	/*
	 *   ����druif�ļ��ҳ����
	 * 
	 * */
	
//	@Bean
	public ServletRegistrationBean<Servlet> statViewServlet(){
		
		StatViewServlet statViewServlet = new StatViewServlet();
		
		ServletRegistrationBean<Servlet> servlet = new ServletRegistrationBean<Servlet>(statViewServlet , "/druid/*");
		
		Map<String, String> map = new LinkedHashMap<String, String>();
 		map.put("loginUsername", "admin");
 		map.put("loginPassword", "123456");   /// ���õ�½����
		servlet.setInitParameters(map);
		
		return servlet; 		
	}
	
//	@Bean
	public FilterRegistrationBean<Filter> webStatFilter(){
		
		WebStatFilter webStatFilter = new WebStatFilter();
		
		
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<Filter>(webStatFilter);
		filter.setUrlPatterns(Arrays.asList("/*"));
		filter.addInitParameter("exclusion", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");  // ���˷���
		
		return filter;
		
	}
	
}
