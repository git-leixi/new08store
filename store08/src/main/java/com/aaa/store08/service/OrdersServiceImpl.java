package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.OrdersMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper om;
    @Override
    public List<Map> findOrders(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        return om.findOrders(map);
    }

    @Override
    public int findOrdersCount() {
        return om.findOrdersCount();
    }

    @Override
    public List<Map> findOrdersMonth(PageVo pageVo,String oDate) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        map.put("oDate",oDate);
        return om.findOrdersMonth(map);
    }

    @Override
    public int findMonthCount(String oDate){
       Map map=new HashMap();
       map.put("oDate",oDate);
    return om.findMonthCount(map);
    }

    @Override
    public List<Map> findInvoice(Integer oId) {
        return om.findInvoice(oId);
    }

    @Override
    public int findOdoId(Integer odId) {
        return om.findOdoId(odId);
    }

    @Override
    public int UpdDetails(Integer odNum, Integer odId) {
        System.out.println("147--"+odNum+"--"+odId);
        Map map=new HashMap();
        map.put("odNum",odNum);
        map.put("odId",odId);
        return om.UpdDetails(map);
    }

    @Override
    public List<Map> OdoIdDetails(Integer odoId) {
        return om.OdoIdDetails(odoId);
    }

    @Override
    public int UpdOrders(double oPrice, Integer oId) {
        Map map=new HashMap();
        map.put("oPrice",oPrice);
        map.put("oId",oId);
        return om.UpdOrders(map);
    }
}
