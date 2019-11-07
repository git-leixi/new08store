package com.aaa.store08.service;

import com.aaa.store08.entity.Area;
import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IAreaService implements AreaService {
    @Resource
    private AreaMapper am;
    @Override
    public List<AreaVo> findArea() {
        return am.findArea();
    }

    @Override
    public List<Area> SelArea() {
        return am.SelArea();
    }

    @Override
    public int findCount(AreaVo areaVo) {
        return am.findCount(areaVo);
    }
    @Override
    public List<Map> SelDeskAll(PageVo pageVo, String aName) {

        if (aName!=null){
        }else {
            aName="全部";
        }
        if (aName.equals("全部")){
            aName=null;
        }

            Map<String,Object> map = new HashMap<String,Object>();
            int count = pageVo.getLimit();
            int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
            map.put("count",count);
            map.put("begin",begin);
            map.put("aName",aName);
            return am.SelDeskAll(map);
        }

    @Override
    public int AddDesk(AreaVo areaVo) {
        return am.AddDesk(areaVo);
    }

    @Override
    public int DelDesk(Integer dId) {
        return am.DelDesk(dId);
    }

    @Override
    public int UpdDsort(AreaVo areaVo) {
        return am.UpdDsort(areaVo);
    }

    @Override
    public int UpdDesk(AreaVo areaVo) {
        return am.UpdDesk(areaVo);
    }

}


