package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.SupplierInfo;
import com.ruoyi.system.mapper.SupplierInfoMapper;
import com.ruoyi.system.newService.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {
    @Autowired
    private SupplierInfoMapper supplierInfoMapper;

    @Override
    public List<SupplierInfo> getAllSupplierInfos(SupplierInfo supplierInfo) {
        return supplierInfoMapper.selectAllSupplierInfos(supplierInfo);
    }

    @Override
    public SupplierInfo getSupplierInfoById(Long supplierId) {
        return supplierInfoMapper.selectSupplierInfoById(supplierId);
    }

    public  String generateBianHao() {


        String lastBianHao = supplierInfoMapper.findMaxBianHao();
        long nextSequenceNumber;

        if (lastBianHao != null) {
            // 提取最后编号中的序列号部分
            String lastSequenceNumberStr = lastBianHao.substring(lastBianHao.lastIndexOf('-') + 1);
            nextSequenceNumber = Long.parseLong(lastSequenceNumberStr) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        // 返回新的编号
        return String.format("G-%07d", nextSequenceNumber);
    }
    @Override
    public int addSupplierInfo(SupplierInfo supplierInfo) {
        String bianHao = generateBianHao();
        supplierInfo.setSupplierNumber(bianHao);

        return supplierInfoMapper.insertSupplierInfo(supplierInfo);
    }

    @Override
    public int updateSupplierInfo(SupplierInfo supplierInfo) {
        return supplierInfoMapper.updateSupplierInfo(supplierInfo);
    }

    @Override
    public int deleteSupplierInfoById(Long supplierId) {
        return supplierInfoMapper.deleteSupplierInfoById(supplierId);
    }

    @Override
    public int deleteSupplierInfosByIds(Long[] supplierIds) {
        return supplierInfoMapper.deleteSupplierInfosByIds(supplierIds);
    }
}
