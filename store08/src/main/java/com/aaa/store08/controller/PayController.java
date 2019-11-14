package com.aaa.store08.controller;

import com.aaa.store08.entity.Vip;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class PayController {
    private Integer aCount =null;

    @Autowired
    private IVipService iVipService;
    @RequestMapping("/pay")
    public String pay(Integer vcount){
        aCount = vcount;
        return "page/vippage/play";
    }
    @RequestMapping("/success")
    public String success(){
        return "page/vippage/success";
    }
    @RequestMapping("/updatevip")
    public String updatevip(Vip vip, String money, VipVO vipVO){
        Vip v = iVipService.selectVip(aCount);
        Double Counts = v.getvSum();
        Double Count = v.getvAcount();  //原来的金额
        System.out.println(Count+Counts);
        Double sum = Double.parseDouble(money); //要充值的金额
        Double sums = Count+sum;  //充值过后的金额
        Double vsums = Counts+sum;
        vip.setVid(aCount);
        vip.setvAcount(sums);
        vip.setvSum(vsums);
        iVipService.editVip(vip);
        System.out.println(vsums);
        System.out.println(sums);
        vipVO.setvAcount(sums);
        vipVO.setvSum(vsums);
        iVipService.UpdVip(vipVO);
        return "page/index";
    }
}
