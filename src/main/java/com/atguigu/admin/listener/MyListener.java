package com.atguigu.admin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;

/**
 * @author ��
 * @data 2021-8-14
 * 
 */

//@WebListener
public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("��Ŀ����......");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("��Ŀֹͣ.......");
	}

  
	
}
