package com.atguigu.admin.bean;

/**
 * @author ��
 * @data 2021-8-13
 * 
 */
public class Ngix implements Server{

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 8888;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ngix 8.5";
	}

}
