package com.aaa.store08.service;

import com.aaa.store08.entity.Area;
import com.aaa.store08.mapper.PrincipalMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PrincipalServiceImpl implements  PrincipalService {
    @Resource
    private PrincipalMapper principalMapper;

    //根据登陆账号名称去查询所绑定的 窗口id
    @Override
    public int selAid(String username) {
        return principalMapper.selAid(username);
    }
    //查询uId为0的窗口
    @Override
    public List<Area> selAreaAll() {
        return principalMapper.selAreaAll();
    }
    // 修改登陆账号所绑定的窗口
    @Override
    public int updAid(Map map) {
        return principalMapper.updAid(map);
    }
}
