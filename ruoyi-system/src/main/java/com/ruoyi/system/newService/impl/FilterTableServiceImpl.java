package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.FilterTable;
import com.ruoyi.system.mapper.FilterTableMapper;
import com.ruoyi.system.newService.FilterTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterTableServiceImpl implements FilterTableService {
    @Autowired
    private  FilterTableMapper filterTableMapper;
    @Override
    public List<FilterTable> selectAllFilterTables(FilterTable filterTable) {
        return filterTableMapper.selectAllFilterTables(filterTable);
    }

    @Override
    public FilterTable selectFilterTableById(Long orderNumber) {
        return filterTableMapper.selectFilterTableById(orderNumber);
    }

    @Override
    public int insertFilterTable(FilterTable filterTable) {
        return filterTableMapper.insertFilterTable(filterTable);
    }

    @Override
    public int updateFilterTable(FilterTable filterTable) {
        return filterTableMapper.updateFilterTable(filterTable);
    }

    @Override
    public int deleteFilterTableById(Long orderNumber) {
        return filterTableMapper.deleteFilterTableById(orderNumber);
    }

    @Override
    public int deleteFilterTablesByIds(Long[] orderNumbers) {
        return filterTableMapper.deleteFilterTablesByIds(orderNumbers);
    }
}
