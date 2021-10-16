package com.atguigu.admin;

import java.util.concurrent.TimeUnit;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author ��
 * @data 2021-8-15
 * 
 */

@DisplayName("junit5 功能测试类")
//@SpringBootTest   // 这个注解具有自动注入的特性
public class BootAdminTest {
	
	
	/**
	 *  断言: 前面断言失败 ，后面的代码都不会执行
	 * 
	 */
	@DisplayName("测试简单断言")
	@Test
	void testSimpleAssertions() {
		int cal = cal(3, 3);
		Assertions.assertEquals(6, cal , "业务逻辑计算失败");
		
		Object obj = new Object();
		Object obj1 = new Object();
		
		Assertions.assertSame(obj, obj1);
	}
	
	
	int cal(int i, int j) {
		
		return i+j;
	}
	
	@Test
	@DisplayName("array assertion")
	void array() {
		Assertions.assertArrayEquals(new int[]{2,1},new int[]{1,2});
	}
	
	
	@DisplayName("测试displayname注解")
	@Test
    void testDisplayName() {
    	System.out.println(1);
    }
	
	
	
	@Disabled
	@DisplayName("测试方法2")
	@Test
	void test2() {
		
		System.out.println(2);
	}

	
	/**
	 * 规定方法超时时间，超出时间测试出异常
	 */
	
	@Timeout(value = 30 , unit = TimeUnit.MILLISECONDS)
	@Test
	void testTimeout() throws InterruptedException {
		Thread.sleep(30);
	}

	@RepeatedTest(5)
	@Test
	void test3() {
		System.out.println(5);
	}
	
	
	@BeforeEach
	void testBeforeEach() {
		System.out.println("测试就要开始了......");
	}
	
	@AfterEach
	void testAfterEach() {
		System.out.println("测试就要结束了......");
	}
	
	@BeforeAll
	static void testBeforeAll() {
		System.out.println("所有测试就要开始了.....");
	}
	
	@AfterAll
	static void testAfterAll() {
		System.out.println("所有测试就要结束了.....");
	}
}
