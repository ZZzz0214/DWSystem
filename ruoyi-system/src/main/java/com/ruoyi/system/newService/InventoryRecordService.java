package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.InventoryRecord;

import java.util.List;

public interface InventoryRecordService {
    /**
     * 查询所有InventoryRecord
     * @param inventoryRecord 查询条件
     * @return InventoryRecord列表
     */
    List<InventoryRecord> selectAllInventoryRecords(InventoryRecord inventoryRecord);

    /**
     * 根据ID查询单个InventoryRecord
     * @param inventoryRecordId InventoryRecord ID
     * @return InventoryRecord对象
     */
    InventoryRecord selectInventoryRecordById(Long inventoryRecordId);

    /**
     * 插入InventoryRecord
     * @param inventoryRecord InventoryRecord对象
     * @return 插入结果
     */
    int insertInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 更新InventoryRecord
     * @param inventoryRecord InventoryRecord对象
     * @return 更新结果
     */
    int updateInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 根据ID删除单个InventoryRecord
     * @param inventoryRecordId InventoryRecord ID
     * @return 删除结果
     */
    int deleteInventoryRecordById(Long inventoryRecordId);

    /**
     * 根据多个ID删除InventoryRecord
     * @param inventoryRecordIds InventoryRecord ID数组
     * @return 删除结果
     */
    int deleteInventoryRecordsByIds(Long[] inventoryRecordIds);
}
