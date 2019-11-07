package com.aaa.store08.service;

import com.aaa.store08.entity.*;
import com.aaa.store08.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IEmployeeServiceImpl implements IEmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    //查询员工信息
    @Override
    public List<Map> findall(PageVo pageVo) {
        //开始的数据信息
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("begin", begin);
        map.put("end", end);
        return employeeMapper.findall(map);
    }
    //修改员工信息
    @Override
    public int staffUpdate(EmployeeVO employeeVO) {
        return employeeMapper.staffUpdate(employeeVO);
    }
    //查询员工状态
    @Override
    public List<State> stateAll() {
        return employeeMapper.stateAll();
    }
    //查询员工职位
    @Override
    public List<Job> jobAll() {
        return employeeMapper.jobAll();
    }
    //查询要修改的员工信息
    @Override
    public List<EmployeeVO> findone(Integer id) {
        return employeeMapper.findone(id);
    }

    //删除一行数据
    @Override
    public int staffDelect(Integer id) {
        return employeeMapper.staffDelect(id);
    }

    //查询区域
    @Override
    public List<Area> areaSelect() {
        return employeeMapper.areaSelect();
    }
    //添加员工信息
    @Override
    public int addStaff(Employee employee) {
        return employeeMapper.addStaff(employee);
    }

    //修改员工信息
    @Override
    public int editStaff(Employee employee) {
        return employeeMapper.editStaff(employee);
    }

    //员工调动
    @Override
    public int editEmployee(Employee employee) {
        return employeeMapper.editEmployee(employee);
    }

    @Override
    public int selEmployee() {
        return employeeMapper.selEmployee();
    }

}
