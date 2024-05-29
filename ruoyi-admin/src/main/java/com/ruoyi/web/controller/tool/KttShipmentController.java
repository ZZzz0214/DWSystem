package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.KttShipment;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.KttShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 快团团出货表
 */

@RestController
@RequestMapping("/manage/KttShipment")
public class KttShipmentController extends BaseController {
    @Autowired
    private KttShipmentService kttShipmentService;
    @GetMapping("/list")
    public TableDataInfo list(KttShipment kttShipment)
    {
        startPage();
        List<KttShipment> list = kttShipmentService.selectAllKttShipments(kttShipment);
        System.out.println(list);
        return getDataTable(list);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, KttShipment kttShipment)
    {
        List<KttShipment> list = kttShipmentService.selectAllKttShipments(kttShipment);
        ExcelUtil<KttShipment> util = new ExcelUtil<KttShipment>(KttShipment.class);
        util.exportExcel(response, list, "快团团出货表数据");
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<KttShipment> util = new ExcelUtil<KttShipment>(KttShipment.class);
        util.importTemplateExcel(response, "快团团出货表数据");
    }
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(kttShipmentService.selectKttShipmentById(id));

        }
        return error("id没有");
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody  KttShipment kttShipment)
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

        kttShipment.setCreateBy(getUsername());
        System.out.println(kttShipment);
        return toAjax(kttShipmentService.insertKttShipment(kttShipment));
    }
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody  KttShipment kttShipment)
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

        kttShipment.setUpdateBy(getUsername());
        System.out.println(kttShipment);
        return toAjax(kttShipmentService.updateKttShipment(kttShipment));
    }

//    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
//    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(kttShipmentService.deleteKttShipmentsByIds(ids));
    }






}
