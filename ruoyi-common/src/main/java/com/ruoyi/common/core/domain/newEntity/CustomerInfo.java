package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class CustomerInfo extends BaseEntity {
    /** 客户ID */
    @Excel(name = "序号")
    private Long kehuId;

    /** 编号NO */
    @Excel(name = "编号NO")
    private String customerNumber;

    /** 名称NOMBRE */
    @Excel(name = "名称NOMBRE")
    private String name;

    /** 税号CIF/NIE */
    @Excel(name = "税号CIF/NIE")
    private String taxNumber;

    /** 地址DIRECION */
    @Excel(name = "地址DIRECION")
    private String address;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 创建日期 */
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationDate;

    public Long getKehuId() {
        return kehuId;
    }

    public void setKehuId(Long kehuId) {
        this.kehuId = kehuId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("kehuId", getKehuId())
                .append("customerNumber", getCustomerNumber())
                .append("name", getName())
                .append("taxNumber", getTaxNumber())
                .append("address", getAddress())
                .append("remarks", getRemarks())
                .append("creationDate", getCreationDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
