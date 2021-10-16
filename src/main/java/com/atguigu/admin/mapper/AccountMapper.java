package com.atguigu.admin.mapper;

import java.util.List;

import com.atguigu.admin.bean.Account;

/**
 * @author 孙
 * @data 2021-8-19
 * 
 */

public interface AccountMapper {
  
	int updateAccountDevBalance(Account account);
 	
	int updateAccountAddBalance(Account account);
	
	double QueryBalanceById(Integer id);
	
	int addAccount(Account account);
	
	List<Account> QueryAllAccount();

    int deleteAccountByid(Integer id);
}
