package com.aaa.store08.service;

import com.aaa.store08.entity.Kind;
import com.aaa.store08.mapper.KindMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KindServiceImpl implements KindService {
    @Resource
    private KindMapper km;


    //查询餐饮种类
    @Override
    public List<Kind> SelKind() {
        return km.SelKind();
    }
    //添加餐饮类别
    @Override
    public int InsertKind(String kind) {
        return km.InsertKind(kind);
    }
    //删除 餐饮类别
    @Override
    public int delKind(int kid) {
        return km.delKind(kid);
    }
    //修改  餐饮类别名称
    @Override
    public int updKind(Map map) {
        return km.updKind(map);
    }
}
