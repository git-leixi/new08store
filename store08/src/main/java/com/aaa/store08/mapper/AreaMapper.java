package com.aaa.store08.mapper;

import com.aaa.store08.entity.Area;
import com.aaa.store08.entity.AreaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AreaMapper {
    public List<AreaVo> findArea();

    public List<Area> SelArea();

    public int findCount(AreaVo areaVo);

    public List<Map> SelDeskAll(Map<String, Object> map);
    public int AddDesk(AreaVo areaVo);

    public int DelDesk(Integer dId);

    public int UpdDsort(AreaVo areaVo);

    public int UpdDesk(AreaVo areaVo);

}
