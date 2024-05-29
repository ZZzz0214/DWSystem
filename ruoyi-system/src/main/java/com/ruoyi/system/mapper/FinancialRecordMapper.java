package com.ruoyi.system.mapper;


import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FinancialRecordMapper {
    // 查询所有记录，并支持可选的过滤条件
    List<FinancialRecord> selectAll(FinancialRecord financialRecord);

    // 根据ID查询记录
    FinancialRecord selectById(Long id);

    // 插入新记录
    int insert(FinancialRecord financialRecord);

    // 更新记录
    int update(FinancialRecord financialRecord);

    // 根据ID删除记录
    int deleteById(Long id);

    // 根据多个ID删除记录
    int deleteByIds(Long[] ids);

    @Select("SELECT bian_hao FROM financial_records WHERE bian_hao LIKE CONCAT('CWJL_', #{date}, '%') ORDER BY id DESC LIMIT 1")
    String findTopBianHaoByDate(@Param("date") String date);
}
