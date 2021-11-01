package com.atguigu.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ??
 * @data 2021-8-14
 * 
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN , reason = "??????????")
public class UserTooManyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserTooManyException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserTooManyException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
