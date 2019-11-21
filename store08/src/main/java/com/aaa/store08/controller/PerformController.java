package com.aaa.store08.controller;


import com.aaa.store08.entity.Employee;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.entity.sDetails;
import com.aaa.store08.entity.vIn;
import com.aaa.store08.service.FoodService;
import com.aaa.store08.service.OrderService;
import com.aaa.store08.service.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private FoodService fs;
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

    //查询详细  信息
    @RequestMapping("tfindDetails")
    public String tfindDetails(Integer id, Model model, HttpSession session){
        if(oids==null){
            oids = id;
        }else{
            oids = id;
        }
        Integer aId=null;
        String vphone = orderService.selPhone(id);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("oid",aId);
        map.put("oid",id);
        map.put("vphone",vphone);
        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        model.addAttribute("id",id);
        return "page/orders/oPperform";
    }
    @RequestMapping("nfindDetails")
    public String nfindDetails(Integer id, Model model, HttpSession session){
        if(oids==null){
            oids = id;
        }else{
            oids = id;
        }
        String username = String.valueOf(session.getAttribute("username"));
        int aid = fs.selAidArea(username);
        String vphone = orderService.selPhone(id);
        Map<Object,Object> map = new HashMap<Object,Object>();
        System.out.println("查看"+aid);
        map.put("aId",aid);
        map.put("oid",id);
        map.put("vphone",vphone);
        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        model.addAttribute("id",id);
        return "page/orders/oPperform";
    }

    //查询员工集合 并传值
    @ResponseBody
    @RequestMapping("updME")
    public Object updME(int odid){
        performService.updMenu(odid);
        List<Employee> elist = performService.selEmp(odid);
        return elist;
    }

    /*
    *  会员等级条件变更后  更新老会员等级
    * 查询得到 vidc vsum vid   根据vsum得到相应的vidc   两个vidc比对 如果不等 则根据vid修改vidc的值
     */
    @ResponseBody
    @RequestMapping("updGrade")
    public int updGrade(){
        List<vIn> vlist = performService.selVip();
        // System.out.println("vlist:"+vlist);
        //拿list的 vsum  去vtype中查询等级得到vidc1    若vidc不等于vidc1 则vidc为vidc1 若等 则继续执行下一个
        Map map = new HashMap();//  把值放入map中 根据map去修改
        for (int i=0;i<vlist.size();i++){
            if (performService.selVidc(vlist.get(i).getvSum()) != vlist.get(i).getvIdc()){
                map.put("vid",vlist.get(i).getVid());
                map.put("vidc",performService.selVidc(vlist.get(i).getvSum()));
                performService.updVidc(map);
               // System.out.println("id"+vlist.get(i).getVid()+"修改为"+performService.selVidc(vlist.get(i).getvSum())+"修改"+vlist.get(i).getvIdc());
            }
            //System.out.println("等级无需改变"+performService.selVidc(vlist.get(i).getvSum()));
        }
        return 0;
    }
}
