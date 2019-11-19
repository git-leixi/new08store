package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrincipalMapper {
    //根据登陆账号名称去查询所绑定的 窗口id
    int selAid(String username);
}
