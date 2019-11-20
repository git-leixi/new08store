package com.aaa.store08.service;

import com.aaa.store08.mapper.AreaMapper;
import com.aaa.store08.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper am;


    @Override
    public List<Map> findOrders(Integer oArea) {
        return am.findOrders(oArea);
    }

    @Override
    public int findOrdersCount(Integer aId) {
        return am.findOrdersCount(aId);
    }

    @Override
    public int findUsersaId(String username) {
        Map map=new HashMap();
        map.put("username",username);
        return am.findUsersaId(map);
    }
}


