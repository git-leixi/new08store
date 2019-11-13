package com.aaa.store08.controller;


import com.aaa.store08.entity.*;
import com.aaa.store08.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Integer oids;
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
    public String findDetails(int id, Model model){
        oids = id;
        String vphone = orderService.selPhone(oids);
        System.out.println(vphone);
        System.out.println(oids);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("oid",oids);
        map.put("vphone",vphone);
        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        model.addAttribute("id",id);
        return "page/orders/oDetails";
    }

    @RequestMapping("/success")
    public String success(){
        return "page/orders/success";
    }
    @RequestMapping("/alipay")
    public String alipay(String money,Model model){
        model.addAttribute("money",money);
        return "page/orders/alipay";
    }
    //结账成功以后修改付款状态
    @RequestMapping("/updateOrder")
    public String updateOrder(){
        orderService.updateOrder(oids);
        return "page/index";
    }
    //会员结账，修改余额
    @RequestMapping("/balance")
    public String updateBalance(String balance,Integer vid,Integer vipid,Vip vip){
        System.out.println("测试"+vid+"--"+balance);
        Double after = Double.parseDouble(balance);
        vip.setvAcount(after);
        vip.setVid(vid);
        orderService.updateBalance(vip);//修改会员余额
        orderService.updateOrder(oids);//修改订单状态
        return "page/index";
    }
    //李
    @RequestMapping("cbOrder")
    public String cbOrder(sDetails sDetails, int id, Model model){

        System.out.println(id);
        String vphone = orderService.selPhone(id);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("oid",id);
        map.put("vphone",vphone);
        List<sDetails> slist = orderService.findDetails(map);
        model.addAttribute("slist",slist);
        System.out.println(slist.toString());
        return "page/orders/cbOrder";
    }


    @RequestMapping("delOdt")
    @ResponseBody
    public Map delOdt(int id){
        //根据id查询 odoid
        int selodoid = orderService.selodoid(id);
        System.out.println(selodoid);
        //根据odid去删除  orderdetails表中的信息   查到删除单品菜的单价    更改 总价 显示
        int j = orderService.delOdt(id);
        Map maps=new HashMap();
        if (j == 1){
            //修改 ocprice 总价    得到 新的总价后 修改
            List<Map> list = orderService.OdoIdDetails(selodoid);
            System.out.println(list);
            double oprice=0.0;
            for (int i=0;i<list.size();i++){
                System.out.println("开始循环");
                Object om=list.get(i).get("odNum");
                Object op=list.get(i).get("odPrice");
                int b = Integer.parseInt(String.valueOf(om));
                double c = Double.parseDouble((String.valueOf(op)));
                double num=b*c;
                oprice+=num++;

            }
            System.out.println(oprice);
            int sss = orderService.updPrice(oprice, selodoid);
            System.out.println(sss);
            //根据id  修改 优惠价格   优惠后的价格
            orderService.updoDetails(selodoid);
            System.out.println("12121");
            maps.put("result",1);
        }else{
            maps.put("result",0);
        }
        return  maps;
    }


}
