package com.aaa.store08.service;

public interface PrincipalService {
    //根据登陆账号名称去查询所绑定的 窗口id
    int selAid(String username);
}
