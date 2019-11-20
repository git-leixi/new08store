package com.aaa.store08.mapper;

import com.aaa.store08.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FoodMapper {
    //查询菜单
    public List<Food> SelFoods();
    public List<Food> SelFoodId(Integer tArea);
    //批量删除
    public int DelAll(Integer[] ids);
    //按编号删除
    public int DelFood(Integer mId);
    //查询编号总数
    public int findCount();
    //分页查询
    public List<Map> SelFoodAll(Map<String, Object> map);
    //添加菜品
    public int InsertFood(Food food);
    public int InsertFoods(Food food);
    //修改菜品
    public int UpdateFood(Food food);
    //查询指定行数据
    public Food UpdFoodId(int mId);
    //根据session  查询username
    int selAName(String username);
    //新增
    //查询菜品类别
    public List<Map> findTemptKind(Integer aId);
    //新增类别
    public int insertKind(Map map);
    public int insertTempt(Map map);
    //删除
    public int deleteTempt(Integer aId);
    //修改
    public int UpdKind(Map map);
    //查询该账号绑定的aid
    public int selAidArea(String username);
}
