package com.aaa.store08.service;

import com.aaa.store08.entity.Food;
import com.aaa.store08.entity.PageVo;

import java.util.List;
import java.util.Map;

public interface FoodService {
    public List<Food> SelFoods();
    public List<Food> SelFoodId(Integer tArea);
    public int DelAll(Integer[] ids);
    public int DelFood(Integer mId);
    public int findCount();
    public List<Map> SelFoodAll(PageVo pageVo);
    public int InsertFood(Food food);
    public int InsertFoods(Food food);
    public int UpdateFood(Food food);
    public Food UpdFoodId(int mId);
    //根据session  查询username
    int selAName(String username);
    //新增
    //查询菜品类别
    public List<Map> findTemptKind(Integer aId);
    //新增类别
    public int insertKind(String kName);
    public int insertTempt(Integer tArea);
    //删除
    public int deleteTempt(Integer aId);
    //修改
    public int UpdKind(Integer tId,String kName);
    //查询该账号绑定的aid
    public int selAidArea(String username);
}
