package com.aaa.store08.service;

import com.aaa.store08.entity.Area;
import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.PageVo;

import java.util.List;
import java.util.Map;

public interface AreaService {
    public List<AreaVo> findArea();

    public List<Area> SelArea();

    public int findCount(AreaVo areaVo);

    public List<Map> SelDeskAll(PageVo pageVo, String aName);

    public int AddDesk(AreaVo areaVo);

    public int DelDesk(Integer dId);

    public int UpdDsort(AreaVo areaVo);

    public int UpdDesk(AreaVo areaVo);

    public List<Map> findAreaKing();

    //添加窗口
    public int AddArea(Map map);
    //查询窗口菜品类别
    public List<Map> findAreaKname(Integer aId);
    //查询所有类别
    public List<Map> findKind();
    //添加tempt
    public int AddTempt(Integer kId);
   //删除窗口
   public int DelArea(Integer aId);
   //修改窗口
   public int UpdArea(Map map);
}
