package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.FilterTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilterTableMapper {

    List<FilterTable> selectAllFilterTables( FilterTable filterTable);

    FilterTable selectFilterTableById( Long orderNumber);

    int insertFilterTable( FilterTable filterTable);

    int updateFilterTable( FilterTable filterTable);

    int deleteFilterTableById(Long orderNumber);

    int deleteFilterTablesByIds( Long[] orderNumbers);
}
