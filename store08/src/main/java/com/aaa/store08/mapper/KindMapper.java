package com.aaa.store08.mapper;

import com.aaa.store08.entity.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface KindMapper {
    //查询餐饮种类
    public List<Kind> SelKind();
    //添加餐饮类别
    public int InsertKind(String kname);
    //删除 餐饮类别
    int delKind(int kid);
    //修改  餐饮类别名称
    int updKind(Map map);
}
