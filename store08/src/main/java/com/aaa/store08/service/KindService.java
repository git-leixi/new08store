package com.aaa.store08.service;

import com.aaa.store08.entity.Kind;

import java.util.List;
import java.util.Map;

public interface KindService {
    //查询餐饮种类
    public List<Kind> SelKind();
    //添加餐饮类别
    public int InsertKind(String kname);
    //删除 餐饮类别
    int delKind(int kid);
    //修改  餐饮类别名称
    int updKind(Map map);
}
