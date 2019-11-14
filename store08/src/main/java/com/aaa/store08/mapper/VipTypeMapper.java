package com.aaa.store08.mapper;

import com.aaa.store08.entity.VipType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VipTypeMapper {
    //查询编号总数
    public int findCount();
    //分页查询
    public List<Map> VipTypeAll(Map<String, Object> map);
    //添加会员等级
    public int AddVType(VipType vipType);
    //删除会员等级
    public int DelVType(int vIdc);
    //修改会员等级
    public int UpdVType(VipType vipType);
    //查询指定行数据
    public VipType SelVType(int vIdc);
    public List<VipType> Seltype(VipType vipType);
}
