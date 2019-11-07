package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.Vip;
import com.aaa.store08.entity.VipVO;

import java.util.List;
import java.util.Map;

public interface IVipService {
    //查看会员信息
    List<Map> findall(PageVo pageVo);
    int vipFindall();
    //查看会员类型
    List<VipVO> typeFindall();
    //注册会员
    int  addVip(VipVO vipVO);
    //修改会员
    int updateVip(VipVO vipVO);
    //查询要修改的会员信息
    List<VipVO> vipOne(Integer id);
    //查看会员消费记录
    List<Map> billsFindall(PageVo pageVo, VipVO vipVO);
    int countBills();
    //查询金额
    public VipVO vipTwo(Integer id);
    Vip selectVip(Integer id);
    //修改金额
    int editVip(Vip vip);
    //修改会员等级
    public int UpdVip(VipVO vipVO);
    public int UpdVipOne(VipVO vipVO);
    public int UpdVipTwo(VipVO vipVO);
    public int UpdVipThree(VipVO vipVO);
    public int UpdVipFour(VipVO vipVO);
}
