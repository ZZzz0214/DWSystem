package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.KttShipment;
import com.ruoyi.system.mapper.KttShipmentMapper;
import com.ruoyi.system.newService.KttShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KttShipmentServiceImpl implements KttShipmentService {
    @Autowired
    private KttShipmentMapper kttShipmentMapper;

    @Override
    public List<KttShipment> selectAllKttShipments(KttShipment kttShipment) {
        return kttShipmentMapper.selectAllKttShipments(kttShipment);
    }

    public  String generateBianHao() {


//        String lastBianHao = kttShipmentMapper.findMaxBianHao();
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
//        return String.format("NO.AH%06d", nextSequenceNumber);
        String lastBianHao = kttShipmentMapper.findMaxBianHao();
        long nextSequenceNumber;

        if (lastBianHao != null) {
            nextSequenceNumber = Long.parseLong(lastBianHao) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        return String.format("NO.AH%06d", nextSequenceNumber);
    }
    @Override
    public KttShipment selectKttShipmentById(Long recordId) {
        return kttShipmentMapper.selectKttShipmentById(recordId);
    }

    @Override
    public int insertKttShipment(KttShipment kttShipment) {
        String bianHao = generateBianHao();
        kttShipment.setProductCode(bianHao);
        return kttShipmentMapper.insertKttShipment(kttShipment);
    }

    @Override
    public int updateKttShipment(KttShipment kttShipment) {
        return kttShipmentMapper.updateKttShipment(kttShipment);
    }

    @Override
    public int deleteKttShipmentById(Long recordId) {
        return kttShipmentMapper.deleteKttShipmentById(recordId);
    }

    @Override
    public int deleteKttShipmentsByIds(Long[] recordIds) {
        return kttShipmentMapper.deleteKttShipmentsByIds(recordIds);
    }
}
