package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.SupplierInfo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 出货商信息表
 */

@RestController
@RequestMapping("/manage/SupplierInfo")
public class SupplierInfoController extends BaseController {
    @Autowired
    private SupplierInfoService supplierInfoService;
    @GetMapping("/list")
    public TableDataInfo list(SupplierInfo supplierInfo)
    {
        startPage();
        List<SupplierInfo> list = supplierInfoService.getAllSupplierInfos(supplierInfo);
        System.out.println(list);
        return getDataTable(list);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, SupplierInfo supplierInfo)
    {
        List<SupplierInfo> list = supplierInfoService.getAllSupplierInfos(supplierInfo);
        ExcelUtil<SupplierInfo> util = new ExcelUtil<SupplierInfo>(SupplierInfo.class);
        util.exportExcel(response, list, "供应商数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<SupplierInfo> util = new ExcelUtil<SupplierInfo>(SupplierInfo.class);
        util.importTemplateExcel(response, "供应商数据");
    }
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long supplierId)
    {

        if (StringUtils.isNotNull(supplierId))
        {
            return success(supplierInfoService.deleteSupplierInfoById(supplierId));

        }
        return error("id没有");
    }
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SupplierInfo supplierInfo)
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

        supplierInfo.setCreateBy(getUsername());
        System.out.println(supplierInfo);
        return toAjax(supplierInfoService.addSupplierInfo(supplierInfo));
    }

    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SupplierInfo supplierInfo)
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

        supplierInfo.setUpdateBy(getUsername());
        System.out.println(supplierInfo);
        return toAjax(supplierInfoService.updateSupplierInfo(supplierInfo));
    }

    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(supplierInfoService.deleteSupplierInfosByIds(ids));
    }


}
