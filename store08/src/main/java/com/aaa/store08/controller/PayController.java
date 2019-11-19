package com.aaa.store08.controller;

import com.aaa.store08.entity.Vip;
import com.aaa.store08.entity.VipType;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.service.IVipService;
import com.aaa.store08.service.VipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        VipVO vipVO1 = iVipService.vipTwo(aCount);
        Double Counts = v.getvSum();
        Double Count = v.getvAcount();  //原来的金额
        Double sum = Double.parseDouble(money); //要充值的金额
        Double sums = Count+sum;  //充值过后的金额
        Double vsums = Counts+sum;
        vip.setvSum(vsums);
        vip.setVid(aCount);
        vip.setvAcount(sums);
        iVipService.editVip(vip);
        System.out.println(sums);
        System.out.println(vsums);
        vipVO.setVid(aCount);
        //vipVO.setvSum(vsums);
        vipVO.setvLimit(vipVO1.getvLimit());
        int i = iVipService.SelUpdVidc(vipVO);
        vipVO.setvIdc(i);
        System.out.println(vipVO.getvIdc());
        iVipService.UpdVips(vipVO);

        return "page/index";
    }
}
