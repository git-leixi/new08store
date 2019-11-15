package com.aaa.store08.service;

import com.aaa.store08.entity.Order;
import com.aaa.store08.entity.Vbills;
import com.aaa.store08.entity.Vip;
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

    //修改订单付款状态
    int updateOrder(Integer id);
    //会员支付，修改会员余额
    int updateBalance(Vip vip);

    //根据id查询vphone
    String selPhone(double id);
    List<Map> OdoIdDetails(int id);

    //查询  odoid
    int selodoid(Integer id);
    //顾客退餐服务
    int delOdt(int id);
    //修改总价
    int updPrice(double oprice,int id );
    //根据id  修改 优惠价格   优惠后的价格
    int updoDetails(int id);
    //查看会员类型
    int vipType(Integer id);
    //添加一条会员消费记录
    int insertVbills(Vbills vbills);
}
