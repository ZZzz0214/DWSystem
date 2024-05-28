package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.AfterSalesBatch;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.AfterSalesBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 这个是售后批发表
 */

@RestController
@RequestMapping("/manage/AfterSalesBatch")
public class AfterSalesBatchController extends BaseController {
    @Autowired
    private AfterSalesBatchService afterSalesBatchService;
    @GetMapping("/list")
    public TableDataInfo list(AfterSalesBatch afterSalesBatch)
    {
        startPage();
        List<AfterSalesBatch> list = afterSalesBatchService.selectAllAfterSalesBatchs(afterSalesBatch);
        System.out.println(list);
        return getDataTable(list);
    }
    @PostMapping("/export")
    public void export(HttpServletResponse response, AfterSalesBatch afterSalesBatch)
    {
        List<AfterSalesBatch> list = afterSalesBatchService.selectAllAfterSalesBatchs(afterSalesBatch);
        ExcelUtil<AfterSalesBatch> util = new ExcelUtil<AfterSalesBatch>(AfterSalesBatch.class);
        util.exportExcel(response, list, "售后批发数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<AfterSalesBatch> util = new ExcelUtil<AfterSalesBatch>(AfterSalesBatch.class);
        util.importTemplateExcel(response, "售后批发数据");
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(afterSalesBatchService.selectAfterSalesBatchById(id));

        }
        return error("id没有");
    }
    @PostMapping
    public AjaxResult add(@Validated @RequestBody AfterSalesBatch afterSalesBatch)
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

        afterSalesBatch.setCreateBy(getUsername());
        System.out.println(afterSalesBatch);
        return toAjax(afterSalesBatchService.insertAfterSalesBatch(afterSalesBatch));
    }
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody AfterSalesBatch afterSalesBatch)
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

        afterSalesBatch.setUpdateBy(getUsername());
        System.out.println(afterSalesBatch);
        return toAjax(afterSalesBatchService.updateAfterSalesBatch(afterSalesBatch));
    }

//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
//    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(afterSalesBatchService.deleteAfterSalesBatchsByIds(ids));
    }


}
