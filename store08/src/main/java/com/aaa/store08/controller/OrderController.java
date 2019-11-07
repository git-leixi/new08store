package com.aaa.store08.controller;


import com.aaa.store08.entity.*;
import com.aaa.store08.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("findorder")
    public String findorder(){
        return "page/orders/order";
    }

    //查询点餐表
    @ResponseBody
    @RequestMapping("findOrder")
    public Object findOrder(PageVo pageVo, Order order,String value){
        System.out.println(value);
        String date1 = null;
        String date2 = null;
       if(value != null){
           date1 = value.substring(0,value.indexOf('~'));
           date2 = value.substring(value.indexOf('~')+1);
           System.out.println(date1);
           System.out.println(date2);
       }
        DataGrid dg = new DataGrid();
       Map<Object,Object> map = new HashMap<Object,Object>();
       map.put("limit",pageVo.getLimit());
       map.put("page",pageVo.getPage());
       map.put("date1",date1);
       map.put("date2",date2);
        //查询点餐信息
        List<Map> orderList = orderService.findOrder(map);
        //查询点餐信息总数
        int count = orderService.findCount(order);

        for(Map m:orderList){
            m.put("count",count);
        }
        System.out.println(orderList);
        dg.setCount(count);
        dg.setCode(0);
        dg.setMsg("");
        dg.setData(orderList);
        return dg;
    }
    @ResponseBody
    @RequestMapping("findOrder2")
    public Object f(Order order, HttpServletRequest request){
        //查询点餐信息总数
        int count = orderService.findCount(order);
        HttpSession session = request.getSession();
        int a=0;
        System.out.println(session.getAttribute("count"));
        if(session==null){
            session.setAttribute("count",count);
            System.out.println(session.getAttribute("count"));
            a= (int) session.getAttribute("count");
        }else if(session!=null&&a!=count){
            session.setAttribute("count",count);
        }

        return count;
    }


    @RequestMapping("findDetails")
    public String findDetails(sDetails sDetails, String id, Model model){
        Integer oid = Integer.parseInt(id) ;
        System.out.println(oid);

        String vphone = orderService.selPhone(oid);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("oid",oid);
        map.put("vphone",vphone);

        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        System.out.println(slist.toString());
        return "page/orders/oDetails";
    }


}
