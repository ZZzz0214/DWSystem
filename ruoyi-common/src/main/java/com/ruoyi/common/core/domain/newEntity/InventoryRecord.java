package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class InventoryRecord extends BaseEntity {
    /** ID */
    @Excel(name = "ID")
    private Long inventoryRecordId;

    /** 入库日期 */
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDate;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer entryQuantity;

    /** 采购价 */
    @Excel(name = "采购价")
    private BigDecimal purchasePrice;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public Long getInventoryRecordId() {
        return inventoryRecordId;
    }

    public void setInventoryRecordId(Long inventoryRecordId) {
        this.inventoryRecordId = inventoryRecordId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInternalProductCode() {
        return internalProductCode;
    }

    public void setInternalProductCode(String internalProductCode) {
        this.internalProductCode = internalProductCode;
    }

    public Integer getEntryQuantity() {
        return entryQuantity;
    }

    public void setEntryQuantity(Integer entryQuantity) {
        this.entryQuantity = entryQuantity;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("inventoryRecordId", getInventoryRecordId())
                .append("entryDate", getEntryDate())
                .append("productName", getProductName())
                .append("internalProductCode", getInternalProductCode())
                .append("entryQuantity", getEntryQuantity())
                .append("purchasePrice", getPurchasePrice())
                .append("remarks", getRemarks())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
