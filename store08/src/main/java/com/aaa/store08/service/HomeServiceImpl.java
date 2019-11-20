package com.aaa.store08.service;

import com.aaa.store08.entity.Home;
import com.aaa.store08.mapper.HomeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    @Resource
    private HomeMapper tm;

    @Override
    public List<Map> findArea() {
        return tm.findArea();
    }

    @Override
     public Map findTest(Home home){
        System.out.println("serviceimpl"+home.getaName()+"---"+home.getoDate());
        return tm.findTest(home);
    }

    @Override
    public List<Map> findOrders(String payment) {
        return tm.findOrders(payment);
    }

    @Override
    public List<Map> findMonth() {
        return tm.findMonth();
    }

    @Override
    public List<Map> monthly() {
        return tm.monthly();
    }

    @Override
    public List<Map> MonthTest() {
        return tm.MonthTest();
    }

    @Override
    public Home OpriceTest(String oDate) {
        return tm.OpriceTest(oDate);
    }

    @Override
    public List<Map> selOrders() {
        return tm.selOrders();
    }
}


