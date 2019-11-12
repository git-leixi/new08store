package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper {
    public List<Map>  findOrders(Map map);
    public int findOrdersCount();
    public List<Map> findOrdersMonth(Map map);
    public int findMonthCount(Map map);
    public  List<Map> findInvoice(Integer oId);
    public int findOdoId(Integer odId);
    public int UpdDetails(Map map);
    public List<Map> OdoIdDetails(Integer odoId);
    public int  UpdOrders(Map map);
}
