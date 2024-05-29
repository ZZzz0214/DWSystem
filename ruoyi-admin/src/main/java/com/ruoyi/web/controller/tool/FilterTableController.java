package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FilterTable;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.FilterTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 筛选表
 */

@RestController
@RequestMapping("/manage/FilterTable")
public class FilterTableController extends BaseController {

    @Autowired
    private FilterTableService filterTableService;
    @GetMapping("/list")
    public TableDataInfo list(FilterTable filterTable)
    {
        startPage();
        List<FilterTable> list = filterTableService.selectAllFilterTables(filterTable);
        System.out.println(list);
        return getDataTable(list);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, FilterTable filterTable)
    {
        List<FilterTable> list = filterTableService.selectAllFilterTables(filterTable);
        ExcelUtil<FilterTable> util = new ExcelUtil<FilterTable>(FilterTable.class);
        util.exportExcel(response, list, "筛选表数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FilterTable> util = new ExcelUtil<FilterTable>(FilterTable.class);
        util.importTemplateExcel(response, "筛选表数据");
    }

    //    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(filterTableService.selectFilterTableById(id));

        }
        return error("id没有");
    }
    //    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:add')")
//    @Log(title = "财务记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody FilterTable filterTable)
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

        filterTable.setCreateBy(getUsername());
        System.out.println(filterTable);
        return toAjax(filterTableService.insertFilterTable(filterTable));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody FilterTable filterTable)
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

        filterTable.setUpdateBy(getUsername());
        System.out.println(filterTable);
        return toAjax(filterTableService.updateFilterTable(filterTable));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(filterTableService.deleteFilterTablesByIds(ids));
    }




}
