package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;

import java.util.List;
import java.util.Map;

public interface OrdersDetailsService {

    //查询会员总数
    public int findCount();
    public List<Map> SelOrdersAll(PageVo pageVo);
}
