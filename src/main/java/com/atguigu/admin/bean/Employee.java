package com.atguigu.admin.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 孙
 * @data 2021-8-22
 * 
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	
	@NotNull(message = "id 不能为空")
	private Integer id;
	
	@NotBlank(message = "用户名不能为空")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@NotBlank
	@Email(message = "邮箱不能为空")
	private String email;

}
