package com.atguigu.admin.factory;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.admin.bean.Ngix;

/**
 * @author 孙
 * @data 2021-8-22
 * 
 */
public class ObjectFactoryBean implements FactoryBean<Ngix>{

	@Override
	public Ngix getObject() throws Exception {
		// TODO Auto-generated method stub
		System.err.println("创建对象.....");
		return new Ngix();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Ngix.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
