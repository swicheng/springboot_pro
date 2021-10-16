package com.atguigu.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;





/**
 * @author ��
 * @data 2021-8-12
 * 
 */

//@ServletComponentScan(basePackageClasses = {MyServlet.class , MyFilter.class , MyListener.class})
@SpringBootApplication
@MapperScan("com.atguigu.admin.mapper")
public class MainApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext  context = SpringApplication.run(MainApplication.class, args);
//        System.out.println(context.getBean("userTwo") == context.getBean("userOne"));
        //System.out.println(context.getBean(User.class));
		//JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		
	    System.out.println(context.getBean("redisConnectionFactory"));
	
		
//		System.err.println(context.getBean("accountMapper"));
//		System.err.println(context.getBean("personMapper"));
//		System.err.println(context.getBean(SqlSession.class));
//		System.out.println(context.getBean(HandlerMapping.class));
	//	System.out.println(context.getBean(AccountController.class).getClass());
	//	System.out.println(context.getBean("transactionManager"));
	//	System.out.println(context.getBean("objectFactoryBean"));
	//	System.out.println(context.getBean(TransactionManager.class));
		
//		System.out.println(context.getBean(DruidDataSource.class).getProperties());
		//System.out.println(context.getBean(JdbcTemplate.class).getQueryTimeout());
	   // System.out.println(context.getBean(DataSource.class));
 		// System.out.println(context.getBean(JdbcTemplate.class).queryForList("select * from person"));
	}
	
}
