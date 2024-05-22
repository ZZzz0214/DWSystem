package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.system.mapper.FinancialRecordMapper;
import com.ruoyi.system.newService.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {
    @Autowired
    private FinancialRecordMapper financialRecordMapper;

    // 查询所有记录，并支持可选的过滤条件
    @Override
    public List<FinancialRecord> selectAll(FinancialRecord financialRecord) {
        return financialRecordMapper.selectAll(financialRecord);
    }

    // 根据ID查询记录
    @Override
    public FinancialRecord selectById(Long id) {
        return financialRecordMapper.selectById(id);
    }

    // 插入新记录
    @Override
    public int insert(FinancialRecord financialRecord) {
        return financialRecordMapper.insert(financialRecord);
    }

    // 更新记录
    @Override
    public int update(FinancialRecord financialRecord) {
        return financialRecordMapper.update(financialRecord);
    }

    // 根据ID删除记录
    @Override
    public int deleteById(Long id) {
        return financialRecordMapper.deleteById(id);
    }

    // 根据多个ID删除记录
    @Override
    public int deleteByIds(Long[] ids) {
        return financialRecordMapper.deleteByIds(ids);
    }
}
