package com.aaa.store08.service;

import java.util.List;
import java.util.Map;

public interface WindService {
    //查看本账户订单
    public List<Map> findOrders(Integer oArea);
    //查看订单数据量
    public int findOrdersCount(Integer aId);
    //查看aId
    public int findUsersaId(String username);
}
