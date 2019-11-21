package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("Orders")
public class OrdersController {
    @Autowired
    private OrdersService os;
    //查询订单数据
    @RequestMapping("findOrders")
    @ResponseBody
    public Object findOrders(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        System.out.println("运行正常");
        int count = os.findOrdersCount();
        System.out.println(count);
        List<Map> maps = os.findOrders(pageVo);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;
    }
    //查看本月订单
    @RequestMapping("findOrdersMonth")
    @ResponseBody
    public Object findOrdersMonth(PageVo pageVo,String oDate) {
        System.out.println("测试"+oDate);
        DataGrid dg = new DataGrid();
        System.out.println("运行正常");
        int count = os.findMonthCount(oDate);
        List<Map> maps = os.findOrdersMonth(pageVo,oDate);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;
    }
    //查看指定订单全部信息
    @RequestMapping("findOrdersDetails")
    public String findOrdersDetails(Integer oId, Model model) {
        System.out.println(oId);
        List<Map> list=os.findInvoice(oId);
        System.out.println(list);
        model.addAttribute("list",list);
        return "page/home/Invoice";
    }
    @RequestMapping("UpdateOrderdetails")
    public String UpdateOrderdetails(Integer odId,Integer odNum, Model model) {
        System.out.println(odId+"--"+odNum);
        //修改
        int oId=os.findOdoId(odId);
        System.out.println(oId);
        os.UpdDetails(odNum,odId);

        List<Map> list =os.OdoIdDetails(oId);

        double oprice=0.0;
        //循环合计订单数量和订单金额
        for (int i=0;i<list.size();i++){
            System.out.println("开始循环");
            Object om=list.get(i).get("odNum");
            Object op=list.get(i).get("odPrice");
            int b = Integer.parseInt(String.valueOf(om));
            double c = Double.parseDouble((String.valueOf(op)));
            double num=b*c;
            oprice+=num++;

        }
        os.UpdOrders(oprice,oId);
        System.out.println(oprice);
        return "redirect:order/findDetails?oId="+oId;
    }
}
