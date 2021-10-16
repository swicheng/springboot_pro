package com.atguigu.admin.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.admin.bean.Person;
import com.atguigu.admin.service.PersonService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author ��
 * @data 2021-8-12
 * 
 */

@Controller
public class TableController {

	
	@Autowired
	PersonService personService;
	
	/*  
	 * @param a ��������������߲������Ͳ��� 400; Bad Request  һ�㶼��������Ĳ���û�д�����ȷ
	 *    
	 * */	
	@GetMapping("/basic_table")
	public String basic_table(@RequestParam("a") int  a) {
		
		 int i = 10/0;
		
		return "table/basic_table";
	}
	
	
	@Transactional
	@GetMapping("/person/delete/{id}")
	public String deletePerson(@PathVariable("id") Long id , 
			                   @RequestParam(value = "pn" , defaultValue = "1") Integer pn,
			                   RedirectAttributes ra) {
		
		personService.removeById(id);
		
		ra.addAttribute("pn", pn);
		
		int i = 1/0;
		
		return "redirect:/dynamic_table";
	}
	
	@GetMapping("/dynamic_table")
	public String dynamic_table(@RequestParam(value = "pn" , defaultValue = "1") Integer pn ,Model model) {
	  

	   List<Person> person = personService.list();
		
	   model.addAttribute("person", person);
	   
//	   分页查询数据
	   Page<Person> Ppage = new Page<Person>(pn , 2l);
	   
//	   分页查询的结果
	   Page<Person> page = personService.page(Ppage,null);
	   
	   model.addAttribute("page", page);
	   
		return "table/dynamic_table";
	}
	
	@ResponseBody
	@GetMapping("/dynamic_tables")
	public Object dynamic_tables(@RequestParam(value = "pn" , defaultValue = "1") Integer pn ,Model model) {
	  
       com.github.pagehelper.Page<Object> page = PageHelper.startPage(pn, 2);
        Map<String, Object> map = new HashMap<String, Object>();
		List<Person> list = personService.list();
		map.put("total", page.getTotal());
		map.put("rows", list);
       
	   
		return map;
	}
	
	
	@GetMapping("/responsive_table")
	public String responsive_table() {
		
		return "table/responsive_table";
	}
	
	
	@GetMapping("/editable_table")
	public String editable_table() {
		
		return "table/editable_table";
	}
}
