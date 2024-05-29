package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.SupplierInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SupplierInfoMapper {

    List<SupplierInfo> selectAllSupplierInfos(SupplierInfo supplierInfo);

    /**
     * 根据ID查询单个SupplierInfo记录。
     *
     * @param supplierId 供应商ID
     * @return SupplierInfo记录
     */
    SupplierInfo selectSupplierInfoById(Long supplierId);

    /**
     * 插入一条SupplierInfo记录。
     *
     * @param supplierInfo SupplierInfo对象
     * @return 影响的行数
     */
    int insertSupplierInfo(SupplierInfo supplierInfo);

    /**
     * 更新一条SupplierInfo记录。
     *
     * @param supplierInfo SupplierInfo对象
     * @return 影响的行数
     */
    int updateSupplierInfo(SupplierInfo supplierInfo);

    /**
     * 根据ID删除一条SupplierInfo记录。
     *
     * @param supplierId 供应商ID
     * @return 影响的行数
     */
    int deleteSupplierInfoById(Long supplierId);

    /**
     * 根据多个ID批量删除SupplierInfo记录。
     *
     * @param supplierIds 供应商ID数组
     * @return 影响的行数
     */
    int deleteSupplierInfosByIds(Long[] supplierIds);

    @Select("SELECT MAX(CONVERT(SUBSTRING_INDEX(supplierNumber, '-', -1), UNSIGNED)) FROM SupplierInfo")
    String findMaxBianHao();
}
