package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.Role;
import com.ruoyi.common.core.domain.newEntity.User;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.FinancialRecordService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manage/FinancialRecord")
public class FinancialRecordController extends BaseController {
    @Autowired
    private FinancialRecordService financialRecordService;
//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinancialRecord financialRecord)
    {
        startPage();
        List<FinancialRecord> list = financialRecordService.selectAll(financialRecord);
        System.out.println(list);
        return getDataTable(list);
    }
//    @Log(title = "财务记录", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinancialRecord financialRecord)
    {
        List<FinancialRecord> list = financialRecordService.selectAll(financialRecord);
        ExcelUtil<FinancialRecord> util = new ExcelUtil<FinancialRecord>(FinancialRecord.class);
        util.exportExcel(response, list, "财务记录数据");
    }

//    @Log(title = "财务记录", businessType = BusinessType.IMPORT)
//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:import')")
//    @PostMapping("/importData")
//    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
//    {
//        ExcelUtil<FinancialRecord> util = new ExcelUtil<FinancialRecord>(FinancialRecord.class);
//        List<FinancialRecord> financialRecordList = util.importExcel(file.getInputStream());
//        String operName = getUsername();
//        String message = financialRecordService.importUser(userList, updateSupport, operName);
//        return success(message);
//    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FinancialRecord> util = new ExcelUtil<FinancialRecord>(FinancialRecord.class);
        util.importTemplateExcel(response, "财务记录数据");
    }

//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(financialRecordService.selectById(id));

        }
        return error("id没有");
    }
//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:add')")
//    @Log(title = "财务记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody FinancialRecord financialRecord)
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

        financialRecord.setCreateBy(getUsername());
        System.out.println(financialRecord);
        return toAjax(financialRecordService.insert(financialRecord));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody FinancialRecord financialRecord)
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

        financialRecord.setUpdateBy(getUsername());
        System.out.println(financialRecord);
        return toAjax(financialRecordService.update(financialRecord));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(financialRecordService.deleteByIds(ids));
    }


}
