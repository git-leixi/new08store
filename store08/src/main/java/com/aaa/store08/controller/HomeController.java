package com.aaa.store08.controller;
import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.Home;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.service.HomeService;
import com.aaa.store08.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("Test")
public class HomeController {
    @Autowired
    private HomeService ts;
    @Autowired
    private OrdersDetailsService ods;

    @RequestMapping("findTest")
    @ResponseBody
    public List<Map> findTest(String oDate) {//传过来的值int型是可以的
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
//其余的行不变只加入这一行即可，设定每周的起始日。
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTimeInMillis(System.currentTimeMillis());//当前时间
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        if(oDate==null){
            oDate=format.format(calendar.getTime());
        }else {
            oDate=year + "-" + month + "-" +oDate;
        }

        List<Map> maps=ts.findArea();
        for (int i=0;i<maps.size();i++){
            Home test=new Home();
            test.setaName((String) maps.get(i).get("aName"));
            test.setoDate(oDate);
            Map map = ts.findTest(test);
            if (map==null) {
                maps.get(i).put("oprice",0);
            }else {
                maps.get(i).put("oprice",map.get("oprice"));
            }
        }
        return maps;
    }
    @RequestMapping("monthly")
    @ResponseBody
    public List<Map> monthly() {//传过来的值int型是可以的
        System.out.println("运行了1");
        List<Map> maps = ts.monthly();
        System.out.println(maps);
        return maps;
    }
    @RequestMapping("findOrders")
    @ResponseBody
    public List<Map> findOrders(String payment) {//传过来的值int型是可以的
        List<Map> maps = ts.findOrders(payment);
        return maps;
    }
    @RequestMapping("findMonth")
    @ResponseBody
    public List<Map> findMonth() {//传过来的值int型是可以的
        List<Map> maps = ts.findMonth();
        return maps;
    }
    @RequestMapping("MonthTest")
    @ResponseBody
    public List<Map> MonthTest() {//传过来的值int型是可以的
        List<Map> maps = ts.MonthTest();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        // System.out.println(maps.size());
        for (int i = 0; i < maps.size(); i++) {
            String days = year + "-" + month + "-" + maps.get(i).get("days");
            Home to = ts.OpriceTest(days);
            if (to==null) {
                maps.get(i).put("oprice", 0);
            } else {
                maps.get(i).put("oprice", to.getOprice());
            }
           // System.out.println(maps);
        }
        //每天的收入
        return maps;
    }
    //已完成订单查询
    @RequestMapping("ToFinally")
    public String ToFinally(){
        return "page/Finally";
    }

    @ResponseBody
    @RequestMapping("SelOrdersDetails")
    public Object SelFood(PageVo pageVo) {
        System.out.println("测试");
        DataGrid dg = new DataGrid();
        int count = ods.findCount();
        System.out.println("测试1"+count);
        List<Map> maps = ods.SelOrdersAll(pageVo);
        System.out.println(maps);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;

    }
    @ResponseBody
    @RequestMapping("indexFindOrders")
    public Object indexFindOrders(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        List<Map> list = ts.selOrders();
        dg.setCode(0);
        dg.setData(list);
        dg.setMsg("");
        return dg;
    }

}
