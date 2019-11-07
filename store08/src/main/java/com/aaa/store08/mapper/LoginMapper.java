package com.aaa.store08.mapper;


import com.aaa.store08.entity.UJob;
import com.aaa.store08.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface LoginMapper {
     //根据输入的账户密码 去数据库进行判断是否存在
     Users findUP(String username,String password);
     //根据用户名查询该用户职位名称
     UJob findJob(String username);



     List<Map> findall();
}
