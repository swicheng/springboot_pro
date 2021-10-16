package com.atguigu.admin.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.builder.InitializingObject;
import org.apache.ibatis.cache.Cache;

/**
 * @author 孙
 * @data 2021-8-25
 * 
 */
public class MyCache implements Cache , InitializingObject{

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private SoftReference<Map<Object, Object>> softReference = new SoftReference<Map<Object,Object>>(new HashMap<Object, Object>(10));
	private Map<Object, Object> cache = softReference.get();
    private String id;
	
	public MyCache(String id) {
		// TODO Auto-generated constructor stub

		this.id = id;
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
	   
		return id;
	}

	@Override
	public void putObject(Object key, Object value) {
		
		cache.put(key, value);
	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		
		return cache.get(key);
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		return cache.remove(key);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cache.clear();
		softReference.clear();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cache.size();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
	
		return lock;
	}

	@Override
	public void initialize() throws Exception {
		// TODO Auto-generated method stub
		System.err.println("初始化.......");
	}

	
}
