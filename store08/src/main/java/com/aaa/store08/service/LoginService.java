package com.aaa.store08.service;

import com.aaa.store08.entity.UJob;
import com.aaa.store08.entity.Users;

import java.util.List;
import java.util.Map;

public interface LoginService {
    //根据输入的账户密码 去数据库进行判断是否存在
    Users findUP(String username,String password);
    //根据用户名查询该用户职位名称
    UJob findJob(String username);


    List<Map> findall();
}
