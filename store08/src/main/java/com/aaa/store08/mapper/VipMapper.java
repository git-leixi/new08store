package com.aaa.store08.mapper;

import com.aaa.store08.entity.Vip;
import com.aaa.store08.entity.VipVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VipMapper {
    //查看会员
    List<Map> findall(Map<String, Object> map);
    int vipFindall(Map<String, Object> map);
    //查看会员类型
    List<VipVO> typeFindall();
    //注册会员账户
    int addVip(VipVO vipVO);
    //修改会员
    int updateVip(VipVO vipVO);
    //查询要修改的会员信息
    List<VipVO> vipOne(Integer id);
    //查看会员消费记录
    List<Map> billsFindall(Map<String, Object> map);
    int countBills();
    //查询金额
    Vip selectVip(Integer id);
    //修改金额
    int editVip(Vip vip);
    //修改会员等级
    public int SelUpdVidc(VipVO vipVO);
    public int UpdVips(VipVO vipVO);
    public VipVO vipTwo(Integer id);
    public int UpdVip(VipVO vipVO);
    //查询会员信息表
    List<Map> findVip(Map<String, Object> map);
    //根据充值金额 查询等级id
    List<VipVO> selVid(Integer vlimit);

}
