package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.newEntity.Notebook;

import java.util.List;

public interface NotebookMapper {
    List<Notebook> selectAllNotebooks(Notebook notebook);

    Notebook selectNotebookById(Long recordId);

    int insertNotebook(Notebook notebook);

    int updateNotebook(Notebook notebook);

    int deleteNotebookById(Long recordId);

    int deleteNotebooksByIds(Long[] recordIds);
}
