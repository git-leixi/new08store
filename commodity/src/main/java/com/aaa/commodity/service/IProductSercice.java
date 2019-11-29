package com.aaa.commodity.service;

import com.aaa.commodity.entity.CatagoryVO;
import com.aaa.commodity.entity.PageVo;
import com.aaa.commodity.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductSercice {
        List<Map> findall(PageVo pageVo);
        //查询总数据
        int countfind();
        //查询类型表
        List<CatagoryVO> selCatafory();
        //添加商品
        int insProduct(Product product);
        //删除商品
        int commodityDel(Integer id);
        //查询要修改的商品
        List<Product> selCommodity(Integer id);
        int editProduct(Product product);
}
