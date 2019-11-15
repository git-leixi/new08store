package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.VipType;
import com.aaa.store08.mapper.VipTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VipTypeServiceImpl implements VipTypeService{
    @Autowired
    private VipTypeMapper vtm;

    @Override
    public int findCount() {
        return vtm.findCount();
    }

    @Override
    public List<Map> VipTypeAll(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        return vtm.VipTypeAll(map);
    }

    @Override
    public int AddVType(VipType vipType) {
        return vtm.AddVType(vipType);
    }

    @Override
    public int DelVType(int vIdc) {
        return vtm.DelVType(vIdc);
    }

    @Override
    public int UpdVType(VipType vipType) {
        return vtm.UpdVType(vipType);
    }

    @Override
    public VipType SelVType(int vIdc) {
        return vtm.SelVType(vIdc);
    }

    @Override
    public List<VipType> Seltype(VipType vipType) {
        return vtm.Seltype(vipType);
    }

}
