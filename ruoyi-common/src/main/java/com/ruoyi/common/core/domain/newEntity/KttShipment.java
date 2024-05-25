package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class KttShipment extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** ID */
    @Excel(name = "ID")
    private Long recordId;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String productCode;

    /** 开团团长 */
    @Excel(name = "开团团长")
    private String groupLeader;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 供货价 */
    @Excel(name = "供货价")
    private BigDecimal supplyPrice;

    /** 货数 */
    @Excel(name = "货数")
    private Integer quantity;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productType;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    /** 品牌方 */
    @Excel(name = "品牌方")
    private String brandOwner;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(BigDecimal supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getInternalProductCode() {
        return internalProductCode;
    }

    public void setInternalProductCode(String internalProductCode) {
        this.internalProductCode = internalProductCode;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
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
                .append("recordId", getRecordId())
                .append("productCode", getProductCode())
                .append("groupLeader", getGroupLeader())
                .append("productName", getProductName())
                .append("supplyPrice", getSupplyPrice())
                .append("quantity", getQuantity())
                .append("productType", getProductType())
                .append("internalProductCode", getInternalProductCode())
                .append("brandOwner", getBrandOwner())
                .append("remarks", getRemarks())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
