package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.InventoryRecord;

import java.util.List;

public interface InventoryRecordMapper {

    List<InventoryRecord> selectAllInventoryRecords(InventoryRecord inventoryRecord);

    InventoryRecord selectInventoryRecordById(Long inventoryRecordId);

    int insertInventoryRecord(InventoryRecord inventoryRecord);

    int updateInventoryRecord(InventoryRecord inventoryRecord);

    int deleteInventoryRecordById(Long inventoryRecordId);

    int deleteInventoryRecordsByIds(Long[] inventoryRecordIds);
}
