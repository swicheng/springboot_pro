package com.atguigu.admin.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.*;

import com.atguigu.admin.bean.Person;
import com.atguigu.admin.bean.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 孙
 * @data 2021-10-5
 * 
 */


@RestController
public class UserController {

	
	@ResponseBody
	@GetMapping("/person/{id}")
	public Person person(@PathVariable("id") String id){


       Person person = new Person(1001, "swic", 22, "深圳");
		System.out.println(1/0);
		return person;
		
	}
	
	
	
	@RequestMapping("/api")
	public Callable<User> api(){



		return new Callable<User>() {

			@Override
			public User call() throws Exception {
				// TODO Auto-generated method stub
				
			    Thread.sleep(1L*1000); // 暂停10秒
				
				User user = new User();
				user.setUsername("666");
				user.setPassword("888");
				
				return user;
			}
			
			
		};
		
	}
	
}
