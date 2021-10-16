package com.atguigu.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.PersonMapper;
import com.atguigu.admin.service.PersonService;

/**
 * @author ��
 * @data 2021-8-12
 * 
 */

@Controller
public class IndexController {
    
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Autowired
	PersonService personService;
    
    @Autowired
    PersonMapper personMapper;
	

	
	@ResponseBody
	@GetMapping("/queryP")
	public Object queryPersonByid(Integer id) {
		
		return personMapper.selectById(id);
	}
	
	@ResponseBody
	@GetMapping("/sql")
	public List<Map<String, Object>> sql() {
		
		return jdbcTemplate.queryForList("select * from person");
	}
	
	/* 
	 * 
	 *  ����½ҳ 
	 * */
	
	
	@GetMapping(value = {"/" ,"/login"})
	public String loginPage() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String main(User user , HttpSession session , Model model) {
		
		
		if ("zs".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
			
			session.setAttribute("loginUser", user);
			return "redirect:/main.html";
		}else {
			
			model.addAttribute("msg", "�˺Ż��������");
			return "login";
		}
		// ��½�ɹ��ض���main.html; �ض����ֹ���ظ��ύ
	
	}
	
	
	/* ȥmainҳ�� */
	@GetMapping("/main.html")
	public String mainPage() {
		
	  	
		
	   return "main";		
	}
}
