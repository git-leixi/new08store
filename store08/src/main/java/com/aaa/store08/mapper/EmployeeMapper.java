package com.aaa.store08.mapper;

import com.aaa.store08.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    //查询所有
    public List<Map> findall(Map<String, Object> map);
    //修改
    public  int staffUpdate(EmployeeVO employeeVO);
    //查询员工状态
    public List<State> stateAll();
    //查询员工职位
    public  List<Job> jobAll();
    //查询要修改的员工信息
    public List<EmployeeVO> findone(Integer id);
    //删除一条数据
    public int staffDelect(Integer id);
    //查询区域信息
    public List<Area> areaSelect();
    //添加员工信息
    public int addStaff(Employee employee);
    //修改员工数据
    public int editStaff(Employee employee);
    //调动员工
    public int editEmployee(Employee employee);
    int selEmployee();
}
