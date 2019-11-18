package com.aaa.store08.mapper;

import com.aaa.store08.entity.Employee;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.entity.vIn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PerformMapper {
    // 菜完成  改变这个菜的状态
    int updMenu(int odid);
    //根据菜品菜品id  找到区域名字 去查询所属区域  然后找到 负责这个区域并在职的员工
    List<Employee> selEmp(int odid);
    //查询所有会员信息
    List<vIn> selVip();
    //根据vsum 查询vtype 的vidc
    int selVidc(double vsum);
    //根据vidc1 修改 会员等级
    int updVidc(Map map);
}
