package com.aaa.commodity.controller;

import com.aaa.commodity.entity.CatagoryVO;
import com.aaa.commodity.entity.DataGrid;
import com.aaa.commodity.entity.PageVo;
import com.aaa.commodity.entity.Product;
import com.aaa.commodity.service.IProductSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test")
public class CommodityController extends BaseController{
    @Autowired
    private IProductSercice iProductSercice;

    @RequestMapping("hello")
    public String index(){
        return "page/index";
    }

    @ResponseBody
    @RequestMapping("findall")
    public Object findall(PageVo pageVo){
        DataGrid dg = new DataGrid();
        List<Map> findall = iProductSercice.findall(pageVo);
        int countfind = iProductSercice.countfind();
        dg.setCode(0);
        dg.setCount(countfind);
        dg.setData(findall);
        dg.setMsg("");
        return dg;
    }
    //添加数据
    @RequestMapping("/commodityadd")
    public String commdityAdd(Model model){
        List<CatagoryVO> catagoryVOS = iProductSercice.selCatafory();
        model.addAttribute("cs",catagoryVOS);
        return "page/add";
    }
    //添加商品
    @ResponseBody
    @RequestMapping("/addProduct")
    public Object addProduct(Product product){
        int success = iProductSercice.insProduct(product);
        return success;
    }
    //删除商品
    @RequestMapping("/commodityDel")
    public String commodityDel(Integer id){
        iProductSercice.commodityDel(id);
        return "redirect:hello";
    }
    //修改商品
    @RequestMapping("editCommodity")
    public String editCommodity(Integer id,Model model){
        System.out.println(id);
        List<Product> products = iProductSercice.selCommodity(id);
        List<CatagoryVO> catagoryVOS = iProductSercice.selCatafory();
        model.addAttribute("ps",products);
        model.addAttribute("cs",catagoryVOS);
        return "page/edit";
    }
    @ResponseBody
    @RequestMapping("editProduct")
    public Object editProduct(Product product){
        int success = iProductSercice.editProduct(product);
        return success;
    }


}
