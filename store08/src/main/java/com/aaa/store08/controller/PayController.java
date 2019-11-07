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

        Double Count = v.getvAcount();  //原来的金额
        Double sum = Double.parseDouble(money); //要充值的金额
        Double sums = Count+sum;  //充值过后的金额
        vip.setVid(aCount);
        vip.setvAcount(sums);
        iVipService.editVip(vip);
        System.out.println(sums);
        vipVO.setvAcount(sums);
        if (sums<500){

            iVipService.UpdVip(vipVO);
        }else if (sums>=500 && sums < 2000){
                        iVipService.UpdVipOne(vipVO);
        }else if (sums >= 2000 && sums <5000){
            iVipService.UpdVipTwo(vipVO);
        }else if (sums >= 5000){
            iVipService.UpdVipThree(vipVO);
        }else {
            System.out.println("空");
        }

        return "redirect:../login/hello";
    }
}
