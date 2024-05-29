package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.DropshipRecord;
import com.ruoyi.system.mapper.DropshipRecordMapper;
import com.ruoyi.system.newService.DropshipRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DropshipRecordServiceImpl implements DropshipRecordService {
    @Autowired
    private DropshipRecordMapper dropshipRecordMapper;

    @Override
    public List<DropshipRecord> selectAllDropshipRecords(DropshipRecord dropshipRecord) {
        return dropshipRecordMapper.selectAllDropshipRecords(dropshipRecord);
    }

    @Override
    public DropshipRecord selectDropshipRecordById(Long recordId) {
        return dropshipRecordMapper.selectDropshipRecordById(recordId);
    }

    public  String generateBianHao() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String date = now.format(dateFormatter);
        String time = now.format(timeFormatter);

        String lastBianHao = dropshipRecordMapper.findTopBianHaoByDate(date);
        long nextSequenceNumber;

        if (lastBianHao != null) {
            // Extract the sequence number from the last bian_hao
            String lastSequenceNumberStr = lastBianHao.substring(lastBianHao.lastIndexOf('_') + 1);
            nextSequenceNumber = Long.parseLong(lastSequenceNumberStr) + 1;
        } else {
            nextSequenceNumber = 1;
        }

        return String.format("DF_%s_%s_%07d", date, time, nextSequenceNumber);
    }
    @Override
    public int insertDropshipRecord(DropshipRecord dropshipRecord) {
        String bianHao = generateBianHao();
        dropshipRecord.setOrderNumber(bianHao);
        return dropshipRecordMapper.insertDropshipRecord(dropshipRecord);
    }

    @Override
    public int updateDropshipRecord(DropshipRecord dropshipRecord) {
        return dropshipRecordMapper.updateDropshipRecord(dropshipRecord);
    }

    @Override
    public int deleteDropshipRecordById(Long recordId) {
        return dropshipRecordMapper.deleteDropshipRecordById(recordId);
    }

    @Override
    public int deleteDropshipRecordsByIds(Long[] recordIds) {
        return dropshipRecordMapper.deleteDropshipRecordsByIds(recordIds);
    }
}
