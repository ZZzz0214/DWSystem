package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.DropshipRecord;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.DropshipRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *代发记录表
 */

@RestController
@RequestMapping("/manage/DropshipRecord")
public class DropshipRecordController extends BaseController {
    @Autowired
    private DropshipRecordService dropshipRecordService;
    @GetMapping("/list")
    public TableDataInfo list(DropshipRecord dropshipRecord)
    {
        startPage();
        List<DropshipRecord> list = dropshipRecordService.selectAllDropshipRecords(dropshipRecord);
        System.out.println(list);
        return getDataTable(list);
    }
    @PostMapping("/export")
    public void export(HttpServletResponse response,DropshipRecord dropshipRecord)
    {
        List<DropshipRecord> list = dropshipRecordService.selectAllDropshipRecords(dropshipRecord);
        ExcelUtil<DropshipRecord> util = new ExcelUtil<DropshipRecord>(DropshipRecord.class);
        util.exportExcel(response, list, "代发记录数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DropshipRecord> util = new ExcelUtil<DropshipRecord>(DropshipRecord.class);
        util.importTemplateExcel(response, "代发记录数据");
    }

    //    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(dropshipRecordService.selectDropshipRecordById(id));

        }
        return error("id没有");
    }
    //    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:add')")
//    @Log(title = "财务记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody DropshipRecord dropshipRecord)
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

        dropshipRecord.setCreateBy(getUsername());
        System.out.println(dropshipRecord);
        return toAjax(dropshipRecordService.insertDropshipRecord(dropshipRecord));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody DropshipRecord dropshipRecord)
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

        dropshipRecord.setUpdateBy(getUsername());
        System.out.println(dropshipRecord);
        return toAjax(dropshipRecordService.updateDropshipRecord(dropshipRecord));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(dropshipRecordService.deleteDropshipRecordsByIds(ids));
    }

}
