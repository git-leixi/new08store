package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDetailsMapper {

    //查询编号总数
    public int findCount();
    //分页查询
    public List<Map> SelOrdersAll(Map<String, Object> map);
}
