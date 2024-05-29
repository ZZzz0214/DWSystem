package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.FilterTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilterTableMapper {

    List<FilterTable> selectAllFilterTables(@Param("filterTable") FilterTable filterTable);

    FilterTable selectFilterTableById(@Param("orderNumber") Long orderNumber);

    int insertFilterTable(@Param("filterTable") FilterTable filterTable);

    int updateFilterTable(@Param("filterTable") FilterTable filterTable);

    int deleteFilterTableById(@Param("orderNumber") Long orderNumber);

    int deleteFilterTablesByIds(@Param("orderNumbers") Long[] orderNumbers);
}
