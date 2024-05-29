package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.Product;
import com.ruoyi.system.mapper.ProductMapper;
import com.ruoyi.system.newService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectAll(Product product) {
        return productMapper.selectAll(product);
    }

    @Override
    public Product selectById(Long productId) {
        return productMapper.selectById(productId);
    }

    public  String generateBianHao() {


//        String lastBianHao = productMapper.findMaxBianHao();
//        long nextSequenceNumber;
//
//        if (lastBianHao != null) {
//            // 提取最后编号中的序列号部分
//            String lastSequenceNumberStr = lastBianHao.substring(lastBianHao.lastIndexOf('H') + 1);
//            nextSequenceNumber = Long.parseLong(lastSequenceNumberStr) + 1;
//        } else {
//            nextSequenceNumber = 1;
//        }
//
//        // 返回新的编号
//        return String.format("DW%08d", nextSequenceNumber);
        String lastBianHao = productMapper.findMaxBianHao();
        long nextSequenceNumber;

        if (lastBianHao != null) {
            nextSequenceNumber = Long.parseLong(lastBianHao) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        return String.format("DW%08d", nextSequenceNumber);
    }
    @Override
    public int insert(Product product) {
        String bianHao = generateBianHao();
        product.setInternalProductCode(bianHao);
        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int deleteById(Long productId) {
        return productMapper.deleteById(productId);
    }

    @Override
    public int deleteByIds(Long[] productIds) {
        return productMapper.deleteByIds(productIds);
    }

}
