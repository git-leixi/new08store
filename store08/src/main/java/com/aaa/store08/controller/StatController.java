package com.aaa.store08.controller;

import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Stat")
public class StatController {
    @Autowired
    private StatService ss;
    @RequestMapping("findOdName")
    @ResponseBody
    public Object findOdName(){
        DataGrid dg = new DataGrid();
        List<Map> list = ss.findOdName();
        dg.setCode(0);
        dg.setData(list);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("findMonthCount")
    @ResponseBody
    public Map findMonthCount(){
         int num = ss.findMonthCount();
         Map map=new HashMap();
         map.put("num",num);
        return map;
    }
    @RequestMapping("newMonthCount")
    @ResponseBody
    public Map newMonthCount(){
        int num = ss.findMonthCount();
        Map map=new HashMap();
        map.put("num",num);
        System.out.println("循环"+map);
        return map;
    }
    @RequestMapping("AreaRanking")
    @ResponseBody
    public Object AreaRanking(){
        DataGrid dg = new DataGrid();
        List<Map> list = ss.AreaRanking();
        dg.setCode(0);
        dg.setData(list);
        dg.setMsg("");
        System.out.println("新"+dg);
        return dg;
    }
}
