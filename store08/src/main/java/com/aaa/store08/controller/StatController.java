package com.aaa.store08.controller;

import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private AreaService as;
    private String prefix = "page/stat/stat";
    @RequestMapping("toStat")
    public String toStat(Model model){
        List<Map> areaKing = as.findAreaKing();
        model.addAttribute("area",areaKing);
        return prefix;
    }
    @RequestMapping("findOdName")
    @ResponseBody
    public Object findOdName(Integer aId){
        System.out.println("测试aId"+aId);
        String aName="";
         if(aId!=null){
             if(aId==-1){
                 System.out.println("运行这一句了1");
                 aName="全部";
             }else {
                 List<Map> anames = ss.SelectaName(aId);
                 aName = (String) anames.get(0).get("aName");
             }
        } else {
            System.out.println("运行这一句了2");
            aName="全部";
        }
        System.out.println("测试aName"+aName);
        DataGrid dg = new DataGrid();
        List<Map> list = ss.findOdName(aName);
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
