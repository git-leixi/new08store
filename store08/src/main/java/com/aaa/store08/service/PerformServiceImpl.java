package com.aaa.store08.service;

import com.aaa.store08.entity.Employee;
import com.aaa.store08.mapper.PerformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PerformServiceImpl implements PerformService {
    @Resource
    private PerformMapper performMapper;

    @Override
    public int updMenu(int odid) {
        return performMapper.updMenu(odid);
    }

    @Override
    public List<Employee> selEmp(int odid) {
        return performMapper.selEmp(odid);
    }
}
