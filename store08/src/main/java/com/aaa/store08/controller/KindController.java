package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private AreaService areaService;

    @RequestMapping("toKind")
    public Object toKind(){

        return "page/area/Kind";
    }

    //添加种类到窗口
    @RequestMapping("toAddKName")
    public String toAddKName(){
        return "page/area/AddKName";
    }


    //添加种类到窗口
    @RequestMapping("toAddKind")
    public String toAddKind(Model model){
        List<Area> areas = areaService.SelArea();
        List<Kind> kinds = kindService.SelKind();
        model.addAttribute("as",areas);
        model.addAttribute("ks",kinds);
        return "page/area/AddKind";
    }


    //查询所有餐饮类别信息
    @ResponseBody
    @RequestMapping("selKind")
    public Object SelFood(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        int count = kindService.findCount();
        List<Map> maps = kindService.SelKindAll(pageVo);
        for (int i=0;i<maps.size();i++){
            Integer kId= (Integer) maps.get(i).get("kId");
            List<Map> aNames = kindService.SelKindId(kId);
            String aName="";
            for (int j=0;j<aNames.size();j++){
                if (j==aNames.size()-1){
                    aName=aName+aNames.get(j).get("aName");
                }else {
                    aName=aName+aNames.get(j).get("aName")+",";
                }
            }
            maps.get(i).put("aName",aName);
        }
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;

    }

    //添加餐饮类别信息
    @RequestMapping("InsertKind")
    public String InsertKind(Kind kind){
        System.out.println(kind);

        kindService.InsertKind(kind);
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
