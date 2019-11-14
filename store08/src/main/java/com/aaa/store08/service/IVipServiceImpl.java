package com.aaa.store08.service;

import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.Vip;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.mapper.VipMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IVipServiceImpl  implements  IVipService{
    @Resource
    private VipMapper vipMapper;

    @Override
    public List<Map> findVip(Map map) {
        //开始的数据信息
        PageVo pageVo = new PageVo();
        Integer limit = (Integer) map.get("limit");
        Integer page = (Integer) map.get("page");
        pageVo.setLimit(limit);
        pageVo.setPage(page);
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        map.put("begin", begin);
        map.put("end", end);
        return vipMapper.findVip(map);
    }

    //查看会员
    @Override
    public List<Map> findall(PageVo pageVo) {
        //开始的数据信息
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("begin", begin);
        map.put("end", end);
        return vipMapper.findall(map);
    }

    @Override
    public int vipFindall(VipVO vipVO) {
        Map<String,Object> map = new HashMap<String,Object>();
        return vipMapper.vipFindall(map);
    }
    //查看会员类型
    @Override
    public List<VipVO> typeFindall() {
        return vipMapper.typeFindall();
    }
    //注册会员
    @Override
    public int addVip(VipVO vipVO) {
        return vipMapper.addVip(vipVO);
    }
    //修改会员
    @Override
    public int updateVip(VipVO vipVO) {
        return vipMapper.updateVip(vipVO);
    }
    //查询要修改的会员信息
    @Override
    public List<VipVO> vipOne(Integer id) {
        return vipMapper.vipOne(id);
    }
    //查看会员消费记录
    @Override
    public List<Map> billsFindall(PageVo pageVo,VipVO vipVO) {
        //开始的数据信息
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("vName",vipVO.getvName());
        map.put("vCount",vipVO.getvCount());
        map.put("begin", begin);
        map.put("end", end);
        return vipMapper.billsFindall(map);
    }

    @Override
    public int countBills() {
        return vipMapper.countBills();
    }
    //查询金额
    @Override
    public Vip selectVip(Integer id) {
        return vipMapper.selectVip(id);
    }

    //修改金额
    @Override
    public int editVip(Vip vip) {
        return vipMapper.editVip(vip);
    }

    @Override
    public int UpdVip(VipVO vipVO) {
        return vipMapper.UpdVip(vipVO);
    }

    //根据充值金额 查询等级id
    @Override
    public List<VipVO> selVid(Integer vlimit) {
        return vipMapper.selVid(vlimit);
    }
}
