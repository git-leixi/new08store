package com.aaa.store08.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatMapper {
    public List<Map>  findOdName();
    public int findMonthCount();
    public List<Map> AreaRanking();
}
