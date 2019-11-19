package com.aaa.store08.service;

import com.aaa.store08.entity.Area;
import com.aaa.store08.mapper.PrincipalMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Area> selAreaAll() {
        return principalMapper.selAreaAll();
    }
}
