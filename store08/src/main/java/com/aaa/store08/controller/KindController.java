package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.Kind;
import com.aaa.store08.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Kind")
public class KindController {
    @Autowired
    private KindService kindService;

    @RequestMapping("toKind")
    public Object toKind(){

        return "page/area/Kind";
    }

    //查询所有餐饮类别信息
    @ResponseBody
    @RequestMapping("selKind")
    public Object selKind(){
        List<Kind> kinds = kindService.SelKind();
        DataGrid dg=new DataGrid();
        dg.setCode(0);
        dg.setData(kinds);
        dg.setCount(0);
        dg.setMsg("");
        return dg;
    }

    //添加餐饮类别信息
    @RequestMapping("InsertKind")
    public String InsertKind(String kname){
        kindService.InsertKind(kname);
        return "redirect: selKind";
    }

    //删除餐饮类别信息
     @RequestMapping("delKind")
    public String delKind(int kId){
        kindService.delKind(kId);
        return "redirect: selKind";
     }
     // 修改餐饮类别信息
     @ResponseBody
     @RequestMapping("updKind")
    public String updKind(int kId,String kName){
        System.out.println(kId);
        System.out.println(kName);
        Map map = new HashMap();
        map.put("kId",kId);
        map.put("kName",kName);
        kindService.updKind(map);
        return "page/area/Kind";
     }
}
