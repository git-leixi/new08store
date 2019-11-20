package com.aaa.store08.service;

import com.aaa.store08.entity.Food;
import com.aaa.store08.entity.Kind;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.mapper.KindMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KindServiceImpl implements KindService {
    @Resource
    private KindMapper km;


    @Override
    public List<Kind> SelKind() {
        return km.SelKind();
    }

    //查询餐饮种类
    @Override
    public List<Map> SelKindId(Integer kId) {
        return km.SelKindId(kId);
    }
    //查询编号总数
    @Override
    public int findCount() {
        return km.findCount();
    }
    //分页查询
    @Override
    public List<Map> SelKindAll(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = pageVo.getLimit();
        int begin =pageVo.getLimit() * (pageVo.getPage() - 1);
        map.put("count",count);
        map.put("begin",begin);
        return km.SelKindAll(map);
    }
    //添加餐饮类别
    @Override
    public int InsertKind(Kind kind) {
        return km.InsertKind(kind);
    }
    //删除 餐饮类别
    @Override
    public int delKind(int kid) {
        return km.delKind(kid);
    }
    //修改  餐饮类别名称
    @Override
    public int updKind(Map map) {
        return km.updKind(map);
    }
}
