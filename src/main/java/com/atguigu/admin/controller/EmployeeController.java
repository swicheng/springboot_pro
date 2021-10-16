package com.atguigu.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.atguigu.admin.bean.Employee;

/**
 * @author 孙
 * @data 2021-8-22
 * 
 */

@Controller
public class EmployeeController {

	
	@GetMapping("/employee")
	public String employeeUrl() {
	

		return "form/form_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid Employee employee , BindingResult bind , Model model) {
	
		System.out.println(bind.hasErrors()); 
		
		if (bind.hasErrors()) {
			
		   bind.getFieldErrors().forEach((item)->{
			   
			   String message = item.getDefaultMessage();
			   String field = item.getField();
			   model.addAttribute(field, message);
			   
		   });;
		   
		   return "form/form_employee";
		}
				
		return "success/success";
	}
	
}
