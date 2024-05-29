package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.Notebook;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 记事本
 */


@RestController
@RequestMapping("/manage/Notebook")
public class NotebookController extends BaseController {

    @Autowired
    private NotebookService notebookService;
    @GetMapping("/list")
    public TableDataInfo list(Notebook notebook)
    {
        startPage();
        List<Notebook> list = notebookService.selectAllNotebooks(notebook);
        System.out.println(list);
        return getDataTable(list);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, Notebook notebook)
    {
        List<Notebook> list = notebookService.selectAllNotebooks(notebook);
        ExcelUtil<Notebook> util = new ExcelUtil<Notebook>(Notebook.class);
        util.exportExcel(response, list, "记事本数据");
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<Notebook> util = new ExcelUtil<Notebook>(Notebook.class);
        util.importTemplateExcel(response, "记事本数据");
    }
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(notebookService.selectNotebookById(id));

        }
        return error("id没有");
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody Notebook notebook)
    {
//        if (!userService.checkUserNameUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }

        notebook.setCreateBy(getUsername());
        System.out.println(notebook);
        return toAjax(notebookService.insertNotebook(notebook));
    }
    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody  Notebook notebook)
    {
//        userService.checkUserAllowed(user);
//        userService.checkUserDataScope(user.getUserId());
//        if (!userService.checkUserNameUnique(user))
//        {
//            return error("修改用户'" + user.getUserName() + "'失败，登录账号已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
//        {
//            return error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
//        {
//            return error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }

        notebook.setUpdateBy(getUsername());
        System.out.println(notebook);
        return toAjax(notebookService.updateNotebook(notebook));
    }

    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(notebookService.deleteNotebooksByIds(ids));
    }


}
