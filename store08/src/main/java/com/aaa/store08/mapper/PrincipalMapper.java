package com.aaa.store08.mapper;

import com.aaa.store08.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrincipalMapper {
    //根据登陆账号名称去查询所绑定的 窗口id
    int selAid(String username);
    //查询uId为0的窗口
    List<Area> selAreaAll();
}
