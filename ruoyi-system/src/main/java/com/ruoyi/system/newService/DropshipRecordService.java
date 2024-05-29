package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.DropshipRecord;

import java.util.List;

public interface DropshipRecordService {
    List<DropshipRecord> selectAllDropshipRecords(DropshipRecord dropshipRecord);

    DropshipRecord selectDropshipRecordById(Long recordId);

    int insertDropshipRecord(DropshipRecord dropshipRecord);

    int updateDropshipRecord(DropshipRecord dropshipRecord);

    int deleteDropshipRecordById(Long recordId);

    int deleteDropshipRecordsByIds(Long[] recordIds);
}
