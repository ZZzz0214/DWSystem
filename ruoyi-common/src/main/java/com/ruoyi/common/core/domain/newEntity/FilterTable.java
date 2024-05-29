package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class FilterTable extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long orderNumber;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 数量 */
    @Excel(name = "数量")
    private Integer quantity;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String productCode;

    /** 团员备注 */
    @Excel(name = "团员备注")
    private String memberRemarks;

    /** 团长 */
    @Excel(name = "团长")
    private String groupLeader;

    /** 筛选 */
    @Excel(name = "筛选")
    private String filter;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String itemName;

    /** 倍数 */
    @Excel(name = "倍数")
    private BigDecimal multiple;

    /** 售后状况 */
    @Excel(name = "售后状况")
    private String afterSalesStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMemberRemarks() {
        return memberRemarks;
    }

    public void setMemberRemarks(String memberRemarks) {
        this.memberRemarks = memberRemarks;
    }

    public String getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getMultiple() {
        return multiple;
    }

    public void setMultiple(BigDecimal multiple) {
        this.multiple = multiple;
    }

    public String getAfterSalesStatus() {
        return afterSalesStatus;
    }

    public void setAfterSalesStatus(String afterSalesStatus) {
        this.afterSalesStatus = afterSalesStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInternalProductCode() {
        return internalProductCode;
    }

    public void setInternalProductCode(String internalProductCode) {
        this.internalProductCode = internalProductCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderNumber", getOrderNumber())
                .append("productName", getProductName())
                .append("specification", getSpecification())
                .append("quantity", getQuantity())
                .append("productCode", getProductCode())
                .append("memberRemarks", getMemberRemarks())
                .append("groupLeader", getGroupLeader())
                .append("filter", getFilter())
                .append("date", getDate())
                .append("itemName", getItemName())
                .append("multiple", getMultiple())
                .append("afterSalesStatus", getAfterSalesStatus())
                .append("remarks", getRemarks())
                .append("internalProductCode", getInternalProductCode())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
