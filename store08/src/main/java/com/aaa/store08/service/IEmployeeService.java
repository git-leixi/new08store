package com.aaa.store08.service;

import com.aaa.store08.entity.*;

import java.util.List;
import java.util.Map;

public interface IEmployeeService  {
    //查询员工信息
    List<Map> findall(PageVo pageVo);
    //修改
    int staffUpdate(EmployeeVO employeeVO);
    //查询员工状态
    List<State> stateAll();
    //查询员工职位
    List<Job> jobAll();
    //查询要修改的员工信息
    List<EmployeeVO> findone(Integer id);
    //删除一行数据
    int staffDelect(Integer id);
    //查询区域数据
    List<Area> areaSelect();
    //添加员工信息
    int addStaff(Employee employee);
    //修改员工信息
    int editStaff(Employee employee);
    //员工调动
    int editEmployee(Employee employee);
    int selEmployee();
}
