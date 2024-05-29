package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.KttShipment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KttShipmentMapper {
    /**
     * 查询所有符合条件的KttShipment记录
     *
     * @param kttShipment 查询条件
     * @return KttShipment列表
     */
    List<KttShipment> selectAllKttShipments( KttShipment kttShipment);

    /**
     * 根据ID查询单个KttShipment记录
     *
     * @param recordId 记录ID
     * @return KttShipment对象
     */
    KttShipment selectKttShipmentById( Long recordId);

    /**
     * 插入新的KttShipment记录
     *
     * @param kttShipment 要插入的KttShipment对象
     * @return 受影响的行数
     */
    int insertKttShipment( KttShipment kttShipment);

    /**
     * 更新KttShipment记录
     *
     * @param kttShipment 要更新的KttShipment对象
     * @return 受影响的行数
     */
    int updateKttShipment( KttShipment kttShipment);

    /**
     * 根据ID删除KttShipment记录
     *
     * @param recordId 要删除的记录ID
     * @return 受影响的行数
     */
    int deleteKttShipmentById( Long recordId);

    /**
     * 根据多个ID删除KttShipment记录
     *
     * @param recordIds 要删除的记录ID数组
     * @return 受影响的行数
     */
    int deleteKttShipmentsByIds( Long[] recordIds);

    @Select("SELECT MAX(CONVERT(SUBSTRING_INDEX(productCode, 'AH', -1), UNSIGNED)) FROM kuatuantuan_shipment")
    String findMaxBianHao();
}
