package com.aaa.store08.service;


import com.aaa.store08.entity.UJob;
import com.aaa.store08.entity.Users;
import com.aaa.store08.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    //根据输入的账户密码 去数据库进行判断是否存在
    @Override
    public Users findUP(String username, String password) {
        Map<Object,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return loginMapper.findUP(map);
    }

    //根据用户名查询该用户职位名称
    @Override
    public UJob findJob(String username) {
        return loginMapper.findJob(username);
    }

    @Override
    public List<Map> findall() {
        return loginMapper.findall();
    }
}
