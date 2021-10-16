package com.atguigu.admin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 孙
 * @data 2021-8-18
 * 
 */


//@Component
//@Aspect
@Slf4j
public class AopLogController {

	
	@Pointcut("execution(public * com.atguigu.admin.controller.*.*(..))")
	public void log() {
		
	}
	
	@Before(value = "log()")
	public void beforeLog(JoinPoint join) {
		
		log.info("执行 {}  方法",join.getSignature().getName());
	
	}
	
	@After(value  = "log()")
	public void afterLog(JoinPoint join) {
		
		log.info("执行 {}  方法完毕",join.getSignature().getName());
	
	}
	
	@Around(value  = "log()")
	public Object aroundLog(ProceedingJoinPoint join) {
		
		Object reuslt = null;
		
		try {
		 reuslt =	join.proceed();
		
		log.info("执行结果 {} ",reuslt);
		
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reuslt;
	}
	
	
	@AfterReturning(pointcut  = "log()" , returning = "result")
    public void doAfterReturning(JoinPoint join, Object result) {
      
		log.info("执行 {}  方法完毕",join.getSignature().getName());
		log.info("执行结果为 {} ",result);
		
		System.out.println("1"+join.getTarget());  // 执行的目标方法的对象
		System.out.println("2"+join.getThis());  // 执行的目标方法的对象
		System.out.print("3"); 
		
		for (Object object :join.getArgs()) {
			System.out.println(object);
		}
		
		System.out.println("4"+join.getSourceLocation());
		System.out.println("5"+join.getStaticPart().getSourceLocation()); 
		
    }
	
	
}
