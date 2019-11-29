package com.aaa.commodity.mapper;

import com.aaa.commodity.entity.CatagoryVO;
import com.aaa.commodity.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    List<Map>  findall(Map<String,Object> map);
    //查询总数据
    int countfind();
    //查询类型表
    List<CatagoryVO> selCatagory();
    //添加商品
    int insProduct(Product product);
    //删除商品
    int commmodityDel(Integer id);
    //查询要修改的商品
    List<Product> selCommodity(Integer id);
    int editProduct(Product product);
}
