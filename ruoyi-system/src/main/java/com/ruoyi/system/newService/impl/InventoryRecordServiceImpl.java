package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.InventoryRecord;
import com.ruoyi.system.mapper.InventoryRecordMapper;
import com.ruoyi.system.newService.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryRecordServiceImpl implements InventoryRecordService {
    @Autowired
    private InventoryRecordMapper inventoryRecordMapper;

    @Override
    public List<InventoryRecord> selectAllInventoryRecords(InventoryRecord inventoryRecord) {
        return inventoryRecordMapper.selectAllInventoryRecords(inventoryRecord);
    }

    @Override
    public InventoryRecord selectInventoryRecordById(Long inventoryRecordId) {
        return inventoryRecordMapper.selectInventoryRecordById(inventoryRecordId);
    }

    @Override
    public int insertInventoryRecord(InventoryRecord inventoryRecord) {
        return inventoryRecordMapper.insertInventoryRecord(inventoryRecord);
    }

    @Override
    public int updateInventoryRecord(InventoryRecord inventoryRecord) {
        return inventoryRecordMapper.updateInventoryRecord(inventoryRecord);
    }

    @Override
    public int deleteInventoryRecordById(Long inventoryRecordId) {
        return inventoryRecordMapper.deleteInventoryRecordById(inventoryRecordId);
    }

    @Override
    public int deleteInventoryRecordsByIds(Long[] inventoryRecordIds) {
        return inventoryRecordMapper.deleteInventoryRecordsByIds(inventoryRecordIds);
    }
}
