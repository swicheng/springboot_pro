package com.atguigu.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孙
 * @data 2021-9-20
 * 
 */


@RestController
public class RedisController {

	
	@Autowired
	private StringRedisTemplate template;
	
	@GetMapping("/redisTest")
	public String name() {
		
		
		
		ValueOperations<String, String> opsForValue = template.opsForValue();
		
		return  opsForValue.get("person");
		
	}
	
}
