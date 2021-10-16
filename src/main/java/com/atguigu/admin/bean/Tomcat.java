package com.atguigu.admin.bean;

/**
 * @author Ëï
 * @data 2021-8-13
 * 
 */
public class Tomcat implements Server{

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 8080;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "tomcat 8.5";
	}

}
