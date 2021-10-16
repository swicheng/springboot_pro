package com.atguigu.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;

import com.atguigu.admin.bean.User;

/**
 * @author 孙
 * @data 2021-10-5
 * 
 */
public class Main {

	
	public static void main(String[] args) {
		
		AsyncRestTemplate template = new AsyncRestTemplate();
		
		ListenableFuture<ResponseEntity<User>> future = template.getForEntity("http://localhost:8080/api", User.class);
	   
		future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {

			@Override
			public void onSuccess(ResponseEntity<User> result) {
				// TODO Auto-generated method stub
				System.out.println("================= cllient get result:"+result.getBody());
			}

			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				System.out.println("========= client failure : "+ex);
			}
			
			
		});
		
		System.out.println("=== no wait");
	}
	
}
