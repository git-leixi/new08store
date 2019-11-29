package com.aaa.commodity.service;

import com.aaa.commodity.entity.CatagoryVO;
import com.aaa.commodity.entity.PageVo;
import com.aaa.commodity.entity.Product;
import com.aaa.commodity.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProducuctServiceImpl implements IProductSercice {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Map> findall(PageVo pageVo) {
        Map<String,Object> map = new HashMap<String,Object>();
        int begin = pageVo.getLimit()*(pageVo.getPage()-1);
        int end = pageVo.getLimit();
        map.put("begin",begin);
        map.put("end",end);
        return productMapper.findall(map);
    }

    @Override
    public int countfind() {
        return productMapper.countfind();
    }
    //查询商品类型表
    @Override
    public List<CatagoryVO> selCatafory() {
        return productMapper.selCatagory();
    }
    //添加商品
    @Override
    public int insProduct(Product product) {
        return productMapper.insProduct(product);
    }
    //删除商品
    @Override
    public int commodityDel(Integer id) {
        return productMapper.commmodityDel(id);
    }
    //查询要修改的商品
    @Override
    public List<Product> selCommodity(Integer id) {
        return productMapper.selCommodity(id);
    }
    @Override
    public int editProduct(Product product) {
        return productMapper.editProduct(product);
    }
}
