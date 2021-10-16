package com.atguigu.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import com.atguigu.admin.service.AccountService;

/**
 * @author 孙
 * @data 2021-8-19
 * 
 */

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountMapper accountMapper;
	
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public int updateAccountDevBalance(Account account) {
		// TODO Auto-generated method stub
		
		int count = accountMapper.updateAccountDevBalance(account);
		
		return count;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public int updateAccountAddBalance(Account account) {
		// TODO Auto-generated method stub
		int count = accountMapper.updateAccountAddBalance(account);
		
		return count;
	}

	@Override
	public double QueryBalanceById(Integer id) {
		// TODO Auto-generated method stub
		return accountMapper.QueryBalanceById(id);
	}

	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountMapper.addAccount(account);
	}

	@Override
	public List<Account> QueryAllAccount() {
		// TODO Auto-generated method stub
		return accountMapper.QueryAllAccount();
	}

	@Override
	public int deleteAccountByid(Integer id) {
		// TODO Auto-generated method stub
		return accountMapper.deleteAccountByid(id);
	}

}
