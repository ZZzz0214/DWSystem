package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.system.mapper.FinancialRecordMapper;
import com.ruoyi.system.newService.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {
    @Autowired
    private FinancialRecordMapper financialRecordMapper;

    // 查询所有记录，并支持可选的过滤条件
    @Override
    public List<FinancialRecord> selectAll(FinancialRecord financialRecord) {
        return financialRecordMapper.selectAll(financialRecord);
    }

    // 根据ID查询记录
    @Override
    public FinancialRecord selectById(Long id) {
        return financialRecordMapper.selectById(id);
    }

    public  String generateBianHao() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String date = now.format(dateFormatter);
        String time = now.format(timeFormatter);

        String lastBianHao = financialRecordMapper.findTopBianHaoByDate(date);
        long nextSequenceNumber;

        if (lastBianHao != null) {
            // Extract the sequence number from the last bian_hao
            String lastSequenceNumberStr = lastBianHao.substring(lastBianHao.lastIndexOf('_') + 1);
            nextSequenceNumber = Long.parseLong(lastSequenceNumberStr) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        return String.format("CWJL_%s_%s_%07d", date, time, nextSequenceNumber);
    }
    // 插入新记录
    @Override
    public int insert(FinancialRecord financialRecord) {
        String bianHao = generateBianHao();
        financialRecord.setBianHao(bianHao);
        return financialRecordMapper.insert(financialRecord);
    }

    // 更新记录
    @Override
    public int update(FinancialRecord financialRecord) {
        return financialRecordMapper.update(financialRecord);
    }

    // 根据ID删除记录
    @Override
    public int deleteById(Long id) {
        return financialRecordMapper.deleteById(id);
    }

    // 根据多个ID删除记录
    @Override
    public int deleteByIds(Long[] ids) {
        return financialRecordMapper.deleteByIds(ids);
    }
}
