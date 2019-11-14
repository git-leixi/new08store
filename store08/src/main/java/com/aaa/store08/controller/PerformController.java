package com.aaa.store08.controller;


import com.aaa.store08.entity.Employee;
import com.aaa.store08.entity.sDetails;
import com.aaa.store08.service.OrderService;
import com.aaa.store08.service.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("perform")
public class PerformController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PerformService performService;
    private Integer oids;

    //查询详细  信息
    @RequestMapping("findDetails")
    public String findDetails(Integer id, Model model){
        if(oids==null){
            oids = id;
        }else{
            oids = id;
        }
        String vphone = orderService.selPhone(id);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("oid",id);
        map.put("vphone",vphone);
        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        model.addAttribute("id",id);
        return "page/orders/oPerform";
    }

    @ResponseBody
    @RequestMapping("updME")
    public Object updME(int odid){
        System.out.println("修改 进来了");
        System.out.println(odid);
        performService.updMenu(odid);
        List<Employee> elist = performService.selEmp(odid);
        return elist;
    }
}
