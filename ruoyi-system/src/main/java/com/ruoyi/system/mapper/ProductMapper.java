package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    // 查询所有产品信息，并支持可选的过滤条件
    List<Product> selectAll(Product product);

    // 根据产品ID查询产品信息
    Product selectById(Long productId);

    // 插入新产品记录
    int insert(Product product);

    // 更新产品记录
    int update(Product product);

    // 根据产品ID删除记录
    int deleteById(Long productId);

    // 根据多个产品ID删除记录
    int deleteByIds(Long[] productIds);

    @Select("SELECT MAX(CONVERT(SUBSTRING_INDEX(internalProductCode, 'DW', -1), UNSIGNED)) FROM product_information")
    String findMaxBianHao();
}
