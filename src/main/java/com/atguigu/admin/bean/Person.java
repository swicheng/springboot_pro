package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ��
 * @data 2021-8-15
 * 
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private String address;

}
