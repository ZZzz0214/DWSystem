package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.AfterSalesBatch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AfterSalesBatchMapper {

    List<AfterSalesBatch> selectAllAfterSalesBatchs(@Param("afterSalesBatch") AfterSalesBatch afterSalesBatch);

    AfterSalesBatch selectAfterSalesBatchById(@Param("afterSalesBatchId") Long afterSalesBatchId);

    int insertAfterSalesBatch(@Param("afterSalesBatch") AfterSalesBatch afterSalesBatch);

    int updateAfterSalesBatch(@Param("afterSalesBatch") AfterSalesBatch afterSalesBatch);

    int deleteAfterSalesBatchById(@Param("afterSalesBatchId") Long afterSalesBatchId);

    int deleteAfterSalesBatchsByIds(@Param("afterSalesBatchIds") Long[] afterSalesBatchIds);

    @Select("SELECT orderNumber FROM after_sales_batch WHERE orderNumber LIKE CONCAT('SH_', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String findTopBianHaoByDate(@Param("date") String date);
}
