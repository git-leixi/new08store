package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.OrdersMapper;
import com.aaa.store08.mapper.StatMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StatServiceImpl implements StatService {
    @Resource
    private StatMapper sm;


    @Override
    public List<Map> findOdName() {
        return sm.findOdName();
    }

    @Override
    public int findMonthCount() {
        return sm.findMonthCount();
    }

    @Override
    public List<Map> AreaRanking() {

        return sm.AreaRanking();
    }
}
