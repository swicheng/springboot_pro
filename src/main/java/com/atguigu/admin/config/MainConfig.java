package com.atguigu.admin.config;



import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.atguigu.admin.bean.Tomcat;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.factory.ObjectFactoryBean;
import com.atguigu.admin.filter.MyFilter;
import com.atguigu.admin.handler.MyWebSocketHandler;
import com.atguigu.admin.interceptor.RedisUrlCountInterceptor;
import com.atguigu.admin.listener.MyListener;
import com.atguigu.admin.servlet.MyServlet;

import ch.qos.logback.core.joran.event.stax.StaxEventRecorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author ��
 * @data 2021-8-12
 * 
 */

@Configuration(proxyBeanMethods = true)
@EnableWebSocket
//@Import(Ngix.class)
public class MainConfig {
	
	
	@Autowired
	private RedisUrlCountInterceptor interceptor;
	
	
//	@Bean
	public ServerEndpointExporter ServerEndpointExporter() {
		
		return new ServerEndpointExporter();
	}
	
	@Bean
	public User userOne() {
		userTwo();
		return new User();
	}
	
	@Bean
	public User userTwo() {
		
		return new User();
	}
   
	@Bean
	public WebSocketConfigurer WebSocketConfigurer() {
		
		return new WebSocketConfigurer() {



			@Override
			public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
				// TODO Auto-generated method stub
				registry.addHandler(new MyWebSocketHandler(), "/websocket/{userId}").setAllowedOrigins("*");
			}
			
		};
		
	}
	
	@Bean
	public ObjectFactoryBean objectFactoryBean() {
		
		return new ObjectFactoryBean();
	}
	
//	@Bean
	public ServletRegistrationBean<MyServlet> myServlet(){
		
		return new ServletRegistrationBean<MyServlet>(new MyServlet(), "/myservlet");
	}
	
	
//	@Bean
	public FilterRegistrationBean<Filter> myFilter(){
		
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<Filter>(new MyFilter());
		
		filter.addUrlPatterns("/*");
		/* new FilterRegistrationBean<MyFilter>(new MyFilter() , myServlet()) */
		return  filter;
	}
	
//	@Bean
	public ServletListenerRegistrationBean<MyListener> myListener(){
		
		
		return new ServletListenerRegistrationBean<MyListener>(new MyListener());
	}
	
	
    @Bean
	public Tomcat tomcat() {
	
		return new Tomcat();
	}
	
 
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {



//			@Override
//			public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//
//				SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
//
//				Properties proEx = new Properties();
//				proEx.put("java.lang.ArithmeticException","/error/500");
//				proEx.put("java.lang.Exception","/error/500");
//
//				exceptionResolver.setExceptionMappings(proEx);
//
//				resolvers.add(exceptionResolver);
//			}

			@Override
			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

				HashMap<String, MediaType> map = new HashMap<>();
				map.put("json", MediaType.APPLICATION_JSON);
				map.put("xml", MediaType.APPLICATION_XML);
				map.put("swic", MediaType.parseMediaType("application/swic"));


				ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(map);
				parameterStrategy.setParameterName("for");

				configurer.strategies(Arrays.asList(parameterStrategy));

			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				InterceptorRegistration register =registry.addInterceptor(interceptor);

				register.excludePathPatterns("/","/login","/css/**","/js/**");

				// TODO Auto-generated method stub
//				InterceptorRegistration register = registry.addInterceptor(new LoginInterceptor());
//			    // �������·��
//				register.addPathPatterns("/**"); // �������󶼻ᱻ���� ������̬��Դ
//				// ��ӷ���·��
//				register.excludePathPatterns("/","/login","/css/**","/js/**" , "/transfer" , "/transfer/**" , "/readData","/readData/*")
			}


			
			
			
		};		
	}
}
