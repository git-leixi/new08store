package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.StatService;
import com.aaa.store08.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private WindService ts;
   //跳转到CKStat页面
    @RequestMapping("toCKStat")
    public String toCKStat(Model model){
        String prefix = "page/stat/CKstat";
        List<Map> areaKing = as.findAreaKing();
        model.addAttribute("area",areaKing);
        return prefix;
    }
   //跳转Stat页面
    @RequestMapping("toStat")
    public String toStat(Model model){
        String prefix = "page/stat/stat";
        List<Map> areaKing = as.findAreaKing();
        model.addAttribute("area",areaKing);
        return prefix;
    }
    //查询出绑定窗口的所有信息
    @RequestMapping("findaIdOdName")
    @ResponseBody
    public Object aIdfindOdName(HttpSession httpSession){
        String aName="";
        String username = String.valueOf(httpSession.getAttribute("username"));
        int aId = ts.findUsersaId(username);
        //查询出窗口的名称
        List<Map> anames = ss.SelectaName(aId);
        aName = (String) anames.get(0).get("aName");
        DataGrid dg = new DataGrid();
        List<Map> list = ss.findOdName(aName);
        dg.setCode(0);
        dg.setData(list);
        dg.setMsg("");
        return dg;
    }
    //根据下拉框信息刷新数据
    @RequestMapping("findOdName")
    @ResponseBody
    public Object findOdName(Integer aId){
        String aName="";
         if(aId!=null){
             if(aId==-1){
                 aName="全部";
             }else {
                 List<Map> anames = ss.SelectaName(aId);
                 aName = (String) anames.get(0).get("aName");
             }
        } else {
            aName="全部";
        }
        DataGrid dg = new DataGrid();
        List<Map> list = ss.findOdName(aName);
        dg.setCode(0);
        dg.setData(list);
        dg.setMsg("");
        return dg;
    }
    //本月销售量查询
    @RequestMapping("findMonthCount")
    @ResponseBody
    public Map findMonthCount(){
         int num = ss.findMonthCount();
         Map map=new HashMap();
         map.put("num",num);
        return map;
    }
    //本月销售量查询
    @RequestMapping("newMonthCount")
    @ResponseBody
    public Map newMonthCount(){
        int num = ss.findMonthCount();
        Map map=new HashMap();
        map.put("num",num);
        return map;
    }
    //菜品销量查询
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
