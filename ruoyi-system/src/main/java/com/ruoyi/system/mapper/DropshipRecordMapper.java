package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.DropshipRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DropshipRecordMapper {
    List<DropshipRecord> selectAllDropshipRecords(@Param("dropshipRecord") DropshipRecord dropshipRecord);

    DropshipRecord selectDropshipRecordById(@Param("recordId") Long recordId);

    int insertDropshipRecord(@Param("dropshipRecord") DropshipRecord dropshipRecord);

    int updateDropshipRecord(@Param("dropshipRecord") DropshipRecord dropshipRecord);

    int deleteDropshipRecordById(@Param("recordId") Long recordId);

    int deleteDropshipRecordsByIds(@Param("recordIds") Long[] recordIds);
    @Select("SELECT orderNumber FROM dropship_records WHERE orderNumber LIKE CONCAT('DF_', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String findTopBianHaoByDate(@Param("date") String date);
}
