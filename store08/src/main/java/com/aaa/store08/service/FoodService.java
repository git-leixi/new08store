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
}
