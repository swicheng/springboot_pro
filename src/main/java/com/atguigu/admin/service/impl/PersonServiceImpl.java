package com.atguigu.admin.service.impl;

import org.springframework.stereotype.Service;

import com.atguigu.admin.bean.Person;
import com.atguigu.admin.mapper.PersonMapper;
import com.atguigu.admin.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author 孙
 * @data 2021-8-16
 * 
 */

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService{

}
