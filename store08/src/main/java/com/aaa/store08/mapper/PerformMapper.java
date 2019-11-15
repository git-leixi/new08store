package com.aaa.store08.mapper;

import com.aaa.store08.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PerformMapper {
    // 菜完成  改变这个菜的状态
    int updMenu(int odid);
    //根据菜品菜品id  找到区域名字 去查询所属区域  然后找到 负责这个区域并在职的员工
    List<Employee> selEmp(int odid);
}
