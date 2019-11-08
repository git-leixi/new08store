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
    private Integer aCount;

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
        System.out.println(vipVO1.getvSum()+"------"+vipVO1.getvLimit());
        Double Count = v.getvAcount();  //原来的金额
        Double Counts = vipVO1.getvSum();
        System.out.println(Counts);
        Double sum = Double.parseDouble(money); //要充值的金额
        Double sums = Count+sum;  //充值过后的金额
        Double vsums = Counts+sum;
        vip.setVid(aCount);
        vip.setvAcount(sums);
        vip.setvSum(vsums);
        iVipService.editVip(vip);
        System.out.println(sums);
        System.out.println(vsums);
        vipVO.setvAcount(sums);
        vipVO.setvSum(vsums);
        if (vsums<800){
            iVipService.UpdVip(vipVO);
        }else if (vsums>=800 && vsums < 1500){
            iVipService.UpdVipOne(vipVO);
        }else if (vsums >= 1500 && vsums <3000){
            iVipService.UpdVipTwo(vipVO);
        }else if (vsums >= 3000 && vsums <5000){
            iVipService.UpdVipThree(vipVO);
        }else if(vsums >=5000){
            iVipService.UpdVipFour(vipVO);

        }else{
            System.out.println("空");
        }

        return "page/index";
    }
}
