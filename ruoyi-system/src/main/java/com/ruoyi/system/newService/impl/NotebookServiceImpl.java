package com.ruoyi.system.newService.impl;

import com.ruoyi.common.core.domain.newEntity.Notebook;
import com.ruoyi.system.mapper.NotebookMapper;
import com.ruoyi.system.newService.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookMapper notebookMapper;

    @Override
    public List<Notebook> selectAllNotebooks(Notebook notebook) {
        return notebookMapper.selectAllNotebooks(notebook);
    }

    @Override
    public Notebook selectNotebookById(Long recordId) {
        return notebookMapper.selectNotebookById(recordId);
    }

    @Override
    public int insertNotebook(Notebook notebook) {
        return notebookMapper.insertNotebook(notebook);
    }

    @Override
    public int updateNotebook(Notebook notebook) {
        return notebookMapper.updateNotebook(notebook);
    }

    @Override
    public int deleteNotebookById(Long recordId) {
        return notebookMapper.deleteNotebookById(recordId);
    }

    @Override
    public int deleteNotebooksByIds(Long[] recordIds) {
        return notebookMapper.deleteNotebooksByIds(recordIds);
    }
}
