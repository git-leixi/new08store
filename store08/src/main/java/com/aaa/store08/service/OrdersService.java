package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    public List<Map> findOrders(PageVo pageVo);
    //数量
    public int findOrdersCount();
    public List<Map> findOrdersMonth(PageVo pageVo, String oDate);

    public int findMonthCount(String oDate);

    public  List<Map> findInvoice(Integer oId);
    public int findOdoId(Integer odId);

    public int UpdDetails(Integer odNum, Integer odId);
    public List<Map> OdoIdDetails(Integer odoId);
    public int  UpdOrders(double oPrice, Integer oId);
}
