package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WindMapper {
    //查看本账户订单
    public List<Map> findOrders(Integer oArea);
    //查看订单数据量
    public int findOrdersCount(Integer aId);
    //查看aId
    public int findUsersaId(Map map);
}
