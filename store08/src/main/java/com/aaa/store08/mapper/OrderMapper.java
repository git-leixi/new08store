package com.aaa.store08.mapper;


import com.aaa.store08.entity.Vip;
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


    //修改订单付款状态
    int updateOrder(Integer id);
    //会员支付，修改余额
    int updateBalance(Vip vip);


    //根据id查询vphone
    String selPhone(double id);

    List<Map> OdoIdDetails(int id);
    //查询  odoid
    int selodoid(Integer id);
    //顾客退餐服务
    int delOdt(int id);
    //修改总价
    int updPrice(Map map);
    //根据id  修改 优惠价格   优惠后的价格
    int updoDetails(int id);
}
