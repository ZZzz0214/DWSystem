package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.newEntity.FinancialRecord;
import com.ruoyi.common.core.domain.newEntity.Product;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.newService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 产品表
 */
@RestController
@RequestMapping("/manage/Product")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        System.out.println(product);
        List<Product> list = productService.selectAll(product);
//        System.out.println(list);
        return getDataTable(list);
    }



    @PostMapping(value = "/export")
    public void export(HttpServletResponse response, Product product,@RequestParam Map<String, String> params) {
        List<String> hiddenColumns = params.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("hiddenColumns["))
                .sorted(Comparator.comparingInt(entry -> Integer.parseInt(entry.getKey().replaceAll("[^0-9]", ""))))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        System.out.println("Hidden Columns: " + hiddenColumns);

        List<Product> list = productService.selectAll(product);
        // 使用ExcelUtil进行导出
        ExcelUtil<Product> util = new ExcelUtil<>(Product.class);
        if (!hiddenColumns.isEmpty()) {
            System.out.println("Hidden : " + hiddenColumns.toArray(new String[0]));
            util.hideColumn(hiddenColumns.toArray(new String[0])); // 隐藏列
        }
        util.exportExcel(response, list, "产品信息数据");
    }



//    @PostMapping(value = "/export")
//    public void export(HttpServletResponse response, @ModelAttribute Product product,
//                       @RequestParam("hiddenColumns") List<String> hiddenColumns)
//    {
//
//        System.out.println(hiddenColumns);
//        List<Product> list = productService.selectAll(product);
//        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
//        // 隐藏列
////        if (hiddenColumns != null) {
////            util.hideColumn(hiddenColumns.toArray(new String[0])); // 修改这一行
////        }
//        util.exportExcel(response, list, "产品信息数据");
//    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.importTemplateExcel(response, "产品信息数据");
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {

        if (StringUtils.isNotNull(id))
        {
            return success(productService.selectById(id));

        }
        return error("id没有");
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody Product product)
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

        product.setCreateBy(getUsername());
        System.out.println(product);
        return toAjax(productService.insert(product));
    }

    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:edit')")
    @Log(title = "财务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Product product)
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

        product.setUpdateBy(getUsername());
        System.out.println(product);
        return toAjax(productService.update(product));
    }


    @PreAuthorize("@ss.hasPermi('manage:FinancialRecord:remove')")
    @Log(title = "财务记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(productService.deleteByIds(ids));
    }

}
