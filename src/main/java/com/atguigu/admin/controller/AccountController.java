package com.atguigu.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.service.AccountService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 孙
 * @data 2021-8-19
 * 
 */
@Slf4j
@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	/*
	    *     事务细节:
	 *  isolation-Isolation：事物的隔离级别
	 *  propagation-Propagation 事务的传播行为
	 *  
	 *  noRollbackFor - Class[] 那些异常事务可以不回滚
	 *  nollbackForClassName - String[] (String全类名)
	 *  
	 *  rollbackFor - Class[] 那些异常事务需要回滚
	 *  rollbackForClassName - String[] 
	 *  
	 *  timeout-int 超时: 事务超出指定执行时长后自动终止并回滚
	 *  readOnly-boolean 设置事务为只读事务
	*/	
	@Transactional()
	@ResponseBody
	@GetMapping("/transfer/{ida}/{idb}/{balance}")
	public Object transferAccount(@PathVariable(value = "ida" ,  required = false) Integer ida , 
			                      @PathVariable(value = "idb" ,  required = false) Integer idb,
			                      @PathVariable(value = "balance" , required = false) Double balance)
	                             {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		accountService.updateAccountDevBalance(new Account(idb, null, balance));
				
		accountService.updateAccountAddBalance(new Account(ida, null, balance));
		
		map.put("msg", "添加成功");
		
		return map;
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	@ResponseBody
	@GetMapping("/updateData/{id}")
	public Object updateData(@PathVariable(value = "id" ,  required = false) Integer id)
	                             {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("开始修改.....updateData");
		
		accountService.updateAccountDevBalance(new Account(id, null,300.));
	    System.err.println(1+"updateData");
	    try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		System.err.println("修改完成.....updateData");
	
		map.put("msg", "修改成功");
		
		 try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 log.info("执行完毕");
		return map;
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	@ResponseBody
	@GetMapping("/updateData1/{id}")
	public Object updateData1(@PathVariable(value = "id" ,  required = false) Integer id)
	                             {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("开始修改....updateData1.");
		
		accountService.updateAccountDevBalance(new Account(id, null,300.));
		 System.err.println(1+"updateData1");
	    
		System.err.println("修改完成....updateData1.");
	
		map.put("msg", "修改成功");
		
		return map;
	}
	
	@Transactional(readOnly = true , isolation = Isolation.REPEATABLE_READ)
	@ResponseBody
	@GetMapping("/readData/{id}")
	public Object readData(@PathVariable(value = "id" ,  required = false) Integer id){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
	
		Double balance = accountService.QueryBalanceById(id);
		
		map.put("balance", balance);
		
		return map;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@ResponseBody
	@GetMapping("/addData/{id}/{username}/{balance}")
	public Object addData(@PathVariable(value = "id" ,  required = false) Integer id,
			              @PathVariable(value = "username" ,  required = false) String username,
			              @PathVariable(value = "balance" ,  required = false) Double balance
			 ){
		
		
		System.err.println("开始执行............"+id);
		
		Map<String, Object> map = new HashMap<String, Object>();
         List<Account> list = accountService.QueryAllAccount();
		
		System.err.println(list);
	
		int count = accountService.addAccount(new Account(id, username, balance));
		
		System.err.println("插入完成...."+id);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         list = accountService.QueryAllAccount();
		
         System.err.println("查询结束............."+id);
		System.err.println(list);
	
		
		map.put("count", list);
		
		return map;
	}
	
	@Transactional(readOnly = true , isolation = Isolation.READ_COMMITTED)
	@ResponseBody
	@GetMapping("/QueryAllData")
	public Object QueryAllData(){
		
		Map<String, Object> map = new HashMap<String, Object>();
				
		map.put("accounts",accountService.QueryAllAccount() );
		
		List<Account> list = accountService.QueryAllAccount();
	
		
        list = accountService.QueryAllAccount();
	
		return map;
	}
	
	
	@GetMapping("/queryaccount/{pageN}/{pageS}")
	public String queryaccount(@PathVariable("pageN") Integer pn ,
			                   @PathVariable("pageS") Integer ps ,
			                   Model model){
		
	
		Page<Object> page = PageHelper.startPage(pn, ps);	
		List<Account> list = accountService.QueryAllAccount();
		model.addAttribute("rows" ,list);
	
		return "account/user";
	}
}
