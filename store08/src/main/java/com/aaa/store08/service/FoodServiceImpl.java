package com.aaa.store08.service;

import com.aaa.store08.entity.Food;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.FoodMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodMapper fm;

    @Override
    public List<Food> SelFood() {
        return fm.SelFood();
    }

    @Override
    public int DelAll(Integer[] ids) {
        return fm.DelAll(ids);
    }

    @Override
    public int DelFood(Integer mId) {
        return fm.DelFood(mId);
    }

    @Override
    public int findCount() {
        return fm.findCount();
    }

    @Override
    public List<Map> SelFoodAll(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        return fm.SelFoodAll(map);
    }

    @Override
    public int InsertFood(Food food) {
        return fm.InsertFood(food);
    }

    @Override
    public int UpdateFood(Food food) {
        return fm.UpdateFood(food);
    }

    @Override
    public Food UpdFoodId(int mId) {
        return fm.UpdFoodId(mId);
    }

}
