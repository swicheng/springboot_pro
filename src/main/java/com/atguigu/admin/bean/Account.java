package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 孙
 * @data 2021-8-19
 * 
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Account {

	private Integer id;
	private String username;
	private Double balance;
	
}
