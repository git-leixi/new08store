package com.aaa.store08.service;

import com.aaa.store08.entity.Order;
import com.aaa.store08.entity.sDetails;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //查询点餐信息表
    List<Map> findOrder(Map map);
    //查询点餐数据总条数
    int findCount(Order order);

    //查询每个单据的详细信息
    List<sDetails> findDetails(Map map);

    //根据id查询vphone
    String selPhone(double id);
}
