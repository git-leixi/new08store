package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("newTest")
public class WindController {
    @Autowired
    private WindService ts;
    @RequestMapping("toCkHome")
    public String toHome(){
        return "page/ckHome";
    }
    @RequestMapping("OrdersSelect")
    @ResponseBody
    public Object OrdersSelect(String username) {
        DataGrid dg = new DataGrid();
        int usersaId = ts.findUsersaId(username);
        List<Map> orders = ts.findOrders(usersaId);
        System.out.println(orders);
        dg.setCode(0);
        dg.setData(orders);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("findOrdersCount")
    @ResponseBody
    public Object findOrdersCount(String username) {
        int usersaId = ts.findUsersaId(username);
       int num = ts.findOrdersCount(usersaId);
        return num;
    }
}
