package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.InventoryRecord;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 入库记录表
 */

@RestController
@RequestMapping("/manage/InventoryRecord")
public class InventoryRecordController extends BaseController {
    @Autowired
    private InventoryRecordService inventoryRecordService;
    @GetMapping("/list")
    public TableDataInfo list(InventoryRecord inventoryRecord)
    {
        startPage();
        List<InventoryRecord> list = inventoryRecordService.selectAllInventoryRecords(inventoryRecord);
        System.out.println(list);
        return getDataTable(list);

    }
    @PostMapping("/export")
    public void export(HttpServletResponse response, InventoryRecord inventoryRecord)
    {
        List<InventoryRecord> list = inventoryRecordService.selectAllInventoryRecords(inventoryRecord);
        ExcelUtil<InventoryRecord> util = new ExcelUtil<InventoryRecord>(InventoryRecord.class);
        util.exportExcel(response, list, "入库记录数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<InventoryRecord> util = new ExcelUtil<InventoryRecord>(InventoryRecord.class);
        util.importTemplateExcel(response, "入库记录数据");
    }
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(inventoryRecordService.selectInventoryRecordById(id));

        }
        return error("id没有");
    }
    @PostMapping
    public AjaxResult add(@Validated @RequestBody InventoryRecord inventoryRecord)
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

        inventoryRecord.setCreateBy(getUsername());
        System.out.println(inventoryRecord);
        return toAjax(inventoryRecordService.insertInventoryRecord(inventoryRecord));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody InventoryRecord inventoryRecord)
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

        inventoryRecord.setUpdateBy(getUsername());
        System.out.println(inventoryRecord);
        return toAjax(inventoryRecordService.updateInventoryRecord(inventoryRecord));
    }
//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
//    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(inventoryRecordService.deleteInventoryRecordsByIds(ids));
    }


}
