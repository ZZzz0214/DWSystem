package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.SupplierInfo;

import java.util.List;

public interface SupplierInfoService {
    List<SupplierInfo> getAllSupplierInfos(SupplierInfo supplierInfo);

    /**
     * 根据ID查询单个SupplierInfo记录。
     *
     * @param supplierId 供应商ID
     * @return SupplierInfo记录
     */
    SupplierInfo getSupplierInfoById(Long supplierId);

    /**
     * 插入一条SupplierInfo记录。
     *
     * @param supplierInfo SupplierInfo对象
     * @return 插入的结果
     */
    int addSupplierInfo(SupplierInfo supplierInfo);

    /**
     * 更新一条SupplierInfo记录。
     *
     * @param supplierInfo SupplierInfo对象
     * @return 更新的结果
     */
    int updateSupplierInfo(SupplierInfo supplierInfo);

    /**
     * 根据ID删除一条SupplierInfo记录。
     *
     * @param supplierId 供应商ID
     * @return 删除的结果
     */
    int deleteSupplierInfoById(Long supplierId);

    /**
     * 根据多个ID批量删除SupplierInfo记录。
     *
     * @param supplierIds 供应商ID数组
     * @return 删除的结果
     */
    int deleteSupplierInfosByIds(Long[] supplierIds);
}
