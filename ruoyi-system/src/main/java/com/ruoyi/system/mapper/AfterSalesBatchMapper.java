package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.AfterSalesBatch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AfterSalesBatchMapper {

    List<AfterSalesBatch> selectAllAfterSalesBatchs( AfterSalesBatch afterSalesBatch);

    AfterSalesBatch selectAfterSalesBatchById( Long afterSalesBatchId);

    int insertAfterSalesBatch( AfterSalesBatch afterSalesBatch);

    int updateAfterSalesBatch( AfterSalesBatch afterSalesBatch);

    int deleteAfterSalesBatchById( Long afterSalesBatchId);

    int deleteAfterSalesBatchsByIds( Long[] afterSalesBatchIds);

    @Select("SELECT orderNumber FROM after_sales_batch WHERE orderNumber LIKE CONCAT('SH_', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String findTopBianHaoByDate(@Param("date") String date);
}
