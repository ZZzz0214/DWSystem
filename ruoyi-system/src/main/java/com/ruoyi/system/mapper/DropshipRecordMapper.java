package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.DropshipRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DropshipRecordMapper {
    List<DropshipRecord> selectAllDropshipRecords( DropshipRecord dropshipRecord);

    DropshipRecord selectDropshipRecordById( Long recordId);

    int insertDropshipRecord( DropshipRecord dropshipRecord);

    int updateDropshipRecord( DropshipRecord dropshipRecord);

    int deleteDropshipRecordById( Long recordId);

    int deleteDropshipRecordsByIds( Long[] recordIds);
    @Select("SELECT orderNumber FROM dropship_records WHERE orderNumber LIKE CONCAT('DF_', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String findTopBianHaoByDate(@Param("date") String date);
}
