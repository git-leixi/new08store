package com.aaa.store08.mapper;


import com.aaa.store08.entity.sDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface OrderMapper {
    //查询点餐信息表
    List<Map> findOrder(Map<String,Object> map);
    //查询点餐数据总条数
    int findCount(Map<String, Object> map);

    //查询每个单据的详细信息
    List<sDetails> findDetails(Map map);

    //根据id查询vphone
    String selPhone(double id);
}
