package com.aaa.store08.service;

import com.aaa.store08.entity.Employee;
import com.aaa.store08.entity.vIn;
import com.aaa.store08.mapper.PerformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PerformServiceImpl implements PerformService {
    @Resource
    private PerformMapper performMapper;
    // 菜完成  改变这个菜的状态
    @Override
    public int updMenu(int odid) {
        return performMapper.updMenu(odid);
    }
    //根据菜品菜品id  找到区域名字 去查询所属区域  然后找到 负责这个区域并在职的员工
    @Override
    public List<Employee> selEmp(int odid) {
        return performMapper.selEmp(odid);
    }
    //查询所有会员信息
    @Override
    public List<vIn> selVip() {
        return performMapper.selVip();
    }
    //根据vsum 查询vtype 的vidc
    @Override
    public int selVidc(double vsum) {
        return performMapper.selVidc(vsum);
    }
    //根据vidc1 修改 会员等级
    @Override
    public int updVidc(Map map) {
        return performMapper.updVidc(map);
    }
}
