package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.OrdersDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrdersDetailsServiceImpl implements OrdersDetailsService{
    @Autowired
    private OrdersDetailsMapper odm;

    @Override
    public int findCount() {
        return odm.findCount();
    }

    @Override
    public List<Map> SelOrdersAll(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        return odm.SelOrdersAll(map);
    }
}
