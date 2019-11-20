package com.aaa.store08.service;

import com.aaa.store08.entity.Area;

import java.util.List;
import java.util.Map;

public interface PrincipalService {
    //根据登陆账号名称去查询所绑定的 窗口id
    int selAid(String username);
    //查询uId为0的窗口
    List<Area> selAreaAll();
    // 修改登陆账号所绑定的窗口
    int updAid(Map map);
}
