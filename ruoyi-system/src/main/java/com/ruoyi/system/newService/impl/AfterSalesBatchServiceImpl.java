package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.AfterSalesBatch;
import com.ruoyi.system.mapper.AfterSalesBatchMapper;
import com.ruoyi.system.newService.AfterSalesBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class AfterSalesBatchServiceImpl implements AfterSalesBatchService {
    @Autowired
    private AfterSalesBatchMapper afterSalesBatchMapper;

    @Override
    public List<AfterSalesBatch> selectAllAfterSalesBatchs(AfterSalesBatch afterSalesBatch) {
        return afterSalesBatchMapper.selectAllAfterSalesBatchs(afterSalesBatch);
    }

    public  String generateBianHao() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String date = now.format(dateFormatter);
        String time = now.format(timeFormatter);

        String lastBianHao = afterSalesBatchMapper.findTopBianHaoByDate(date);
        long nextSequenceNumber;

        if (lastBianHao != null) {
            // Extract the sequence number from the last bian_hao
            String lastSequenceNumberStr = lastBianHao.substring(lastBianHao.lastIndexOf('_') + 1);
            nextSequenceNumber = Long.parseLong(lastSequenceNumberStr) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        return String.format("SH_%s_%s_%07d", date, time, nextSequenceNumber);
    }
    @Override
    public AfterSalesBatch selectAfterSalesBatchById(Long afterSalesBatchId) {
        return afterSalesBatchMapper.selectAfterSalesBatchById(afterSalesBatchId);
    }

    @Override
    public int insertAfterSalesBatch(AfterSalesBatch afterSalesBatch) {
        String bianHao = generateBianHao();
        afterSalesBatch.setOrderNumber(bianHao);
        return afterSalesBatchMapper.insertAfterSalesBatch(afterSalesBatch);
    }

    @Override
    public int updateAfterSalesBatch(AfterSalesBatch afterSalesBatch) {
        return afterSalesBatchMapper.updateAfterSalesBatch(afterSalesBatch);
    }

    @Override
    public int deleteAfterSalesBatchById(Long afterSalesBatchId) {
        return afterSalesBatchMapper.deleteAfterSalesBatchById(afterSalesBatchId);
    }

    @Override
    public int deleteAfterSalesBatchsByIds(Long[] afterSalesBatchIds) {
        return afterSalesBatchMapper.deleteAfterSalesBatchsByIds(afterSalesBatchIds);
    }
}
