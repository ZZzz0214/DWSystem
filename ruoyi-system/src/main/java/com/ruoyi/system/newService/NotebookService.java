package com.ruoyi.system.newService;

import com.ruoyi.common.core.domain.newEntity.Notebook;

import java.util.List;

public interface NotebookService {
    /**
     * 根据条件查询所有Notebook
     * @param notebook 查询条件
     * @return Notebook列表
     */
    List<Notebook> selectAllNotebooks(Notebook notebook);

    /**
     * 根据ID查询单个Notebook
     * @param recordId Notebook ID
     * @return Notebook对象
     */
    Notebook selectNotebookById(Long recordId);

    /**
     * 插入Notebook
     * @param notebook Notebook对象
     * @return 插入结果
     */
    int insertNotebook(Notebook notebook);

    /**
     * 更新Notebook
     * @param notebook Notebook对象
     * @return 更新结果
     */
    int updateNotebook(Notebook notebook);

    /**
     * 根据ID删除单个Notebook
     * @param recordId Notebook ID
     * @return 删除结果
     */
    int deleteNotebookById(Long recordId);

    /**
     * 根据多个ID删除Notebook
     * @param recordIds Notebook ID数组
     * @return 删除结果
     */
    int deleteNotebooksByIds(Long[] recordIds);
}
