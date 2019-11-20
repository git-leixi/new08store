package com.aaa.store08.mapper;

import com.aaa.store08.entity.Food;
import com.aaa.store08.entity.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface KindMapper {
    //查询餐饮种类
    public List<Kind> SelKind();
    public List<Map> SelKindId(Integer kId);
    //查询编号总数
    public int findCount();
    //分页查询
    public List<Map> SelKindAll(Map<String, Object> map);
    //添加餐饮类别
    public int InsertKind(Kind kind);
    //删除 餐饮类别
    int delKind(int kid);
    //修改  餐饮类别名称
    int updKind(Map map);
}
