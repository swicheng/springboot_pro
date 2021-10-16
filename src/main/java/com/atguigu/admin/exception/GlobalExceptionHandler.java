package com.atguigu.admin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ÀÔ
 * @data 2021-8-14
 * 
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
   
	
	@ExceptionHandler({ArithmeticException.class , NullPointerException.class})
	public String handlerException(Exception e) {
		
		log.info("“Ï≥£ «:{ }",e);
		return "login";
	}
	
}





