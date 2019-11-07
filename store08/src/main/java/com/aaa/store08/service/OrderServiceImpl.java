package com.aaa.store08.service;


import com.aaa.store08.entity.Order;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.oDetails;
import com.aaa.store08.entity.sDetails;
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

    //根据id查询vphone
    @Override
    public String selPhone(double id) {
        return orderMapper.selPhone(id);
    }


}
