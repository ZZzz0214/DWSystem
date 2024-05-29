package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.AfterSalesBatch;

import java.util.List;

public interface AfterSalesBatchService {


    List<AfterSalesBatch> selectAllAfterSalesBatchs(AfterSalesBatch afterSalesBatch);

    AfterSalesBatch selectAfterSalesBatchById(Long afterSalesBatchId);

    int insertAfterSalesBatch(AfterSalesBatch afterSalesBatch);

    int updateAfterSalesBatch(AfterSalesBatch afterSalesBatch);

    int deleteAfterSalesBatchById(Long afterSalesBatchId);

    int deleteAfterSalesBatchsByIds(Long[] afterSalesBatchIds);
}
