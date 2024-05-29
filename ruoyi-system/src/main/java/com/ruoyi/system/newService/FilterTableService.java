package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.FilterTable;

import java.util.List;

public interface FilterTableService {
    List<FilterTable> selectAllFilterTables(FilterTable filterTable);

    FilterTable selectFilterTableById(Long orderNumber);

    int insertFilterTable(FilterTable filterTable);

    int updateFilterTable(FilterTable filterTable);

    int deleteFilterTableById(Long orderNumber);

    int deleteFilterTablesByIds(Long[] orderNumbers);
}
