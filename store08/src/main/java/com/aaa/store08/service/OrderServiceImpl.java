package com.aaa.store08.service;


import com.aaa.store08.entity.*;
import com.aaa.store08.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    //查询点餐信息表
    @Override
    public List<Map> findOrder(Map map) {
        //开始的数据信息
        PageVo pageVo = new PageVo();
        Integer limit = (Integer) map.get("limit");
        Integer page = (Integer) map.get("page");
        pageVo.setLimit(limit);
        pageVo.setPage(page);
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        map.put("begin", begin);
        map.put("end", end);
        return orderMapper.findOrder(map);
    }

    //查询点餐数据总条数
    @Override
    public int findCount(Order order) {
        Map<String,Object> map = new HashMap<String,Object>();
        return orderMapper.findCount(map);
    }

    //查询每个单据的详细信息
    @Override
    public List<sDetails> findDetails(Map map) {
        return
                orderMapper.findDetails(map);
    }

    @Override
    public int updateOrder(Integer id) {
        return orderMapper.updateOrder(id);
    }
    //会员支付修改会员的余额
    @Override
    public int updateBalance(Vip vip) {
        return orderMapper.updateBalance(vip);
    }


    //根据id查询vphone
    @Override
    public String selPhone(double id) {
        return orderMapper.selPhone(id);
    }

    //顾客退餐服务
    @Override
    public int delOdt(int id) { return orderMapper.delOdt(id); }
    //查询 数量 单价 计算总价
    @Override
    public List<Map> OdoIdDetails(int id) {
        return orderMapper.OdoIdDetails(id);
    }
    //查询 odoid
    @Override
    public int selodoid(Integer id) {
        return orderMapper.selodoid(id);
    }

    //  修改 总价
    @Override
    public int updPrice(double oprice, int id) {

        Map map = new HashMap();
        map.put("oprice",oprice);
        map.put("id",id);
        return orderMapper.updPrice(map);
    }

    //根据id  修改 优惠价格   优惠后的价格
    @Override
    public int updoDetails(int id) {
        return orderMapper.updoDetails(id);
    }
    //查看会员类型
    @Override
    public int vipType(Integer id) {
        return orderMapper.vipType(id);
    }
    //添加一条会员消费记录
    @Override
    public int insertVbills(Vbills vbills) {
        return orderMapper.insertvBills(vbills);
    }
}
