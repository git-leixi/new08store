package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatMapper {
    public List<Map>  findOdName(Map map);
    public int findMonthCount();
    public List<Map> AreaRanking();
    public List<Map> SelectaName(Integer aId);
}
