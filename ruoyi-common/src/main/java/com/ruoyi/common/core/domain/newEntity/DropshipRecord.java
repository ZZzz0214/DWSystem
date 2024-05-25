package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class DropshipRecord extends BaseEntity {
    /** ID */
    @Excel(name = "ID")
    private Long recordId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 物流公司 */
    @Excel(name = "物流公司")
    private String logisticsCompany;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String trackingNumber;

    /** 收货人 */
    @Excel(name = "收货人")
    private String recipientName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String recipientPhone;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

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
    private String leader;

    /** 筛选 */
    @Excel(name = "筛选")
    private String filter;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productNameDetails;

    /** 倍数 */
    @Excel(name = "倍数")
    private Integer multiplier;

    /** 售后状况 */
    @Excel(name = "售后状况")
    private String afterSalesStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    /** 货数 */
    @Excel(name = "货数")
    private Integer stockQuantity;

    /** 品牌方 */
    @Excel(name = "品牌方")
    private String brand;

    /** 采购价 */
    @Excel(name = "采购价")
    private BigDecimal purchasePrice;

    /** 采购_运费 */
    @Excel(name = "采购_运费")
    private BigDecimal purchaseShippingFee;

    /** 采购_其他费 */
    @Excel(name = "采购_其他费")
    private BigDecimal purchaseOtherFee;

    /** 采购_总额 */
    @Excel(name = "采购_总额")
    private BigDecimal purchaseTotalAmount;

    /** 采购_检查 */
    @Excel(name = "采购_检查")
    private String purchaseInspection;

    /** 采购_状况 */
    @Excel(name = "采购_状况")
    private String purchaseStatus;

    /** 采购_备注 */
    @Excel(name = "采购_备注")
    private String purchaseRemarks;

    /** 出货价 */
    @Excel(name = "出货价")
    private BigDecimal sellingPrice;

    /** 出货_运费 */
    @Excel(name = "出货_运费")
    private BigDecimal sellingShippingFee;

    /** 出货_其他费 */
    @Excel(name = "出货_其他费")
    private BigDecimal sellingOtherFee;

    /** 出货_总额 */
    @Excel(name = "出货_总额")
    private BigDecimal sellingTotalAmount;

    /** 出货_检查 */
    @Excel(name = "出货_检查")
    private String sellingInspection;

    /** 出货_状况 */
    @Excel(name = "出货_状况")
    private String sellingStatus;

    /** 出货_备注 */
    @Excel(name = "出货_备注")
    private String sellingRemarks;

    /** 利润 */
    @Excel(name = "利润")
    private BigDecimal profit;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
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

    public String getProductNameDetails() {
        return productNameDetails;
    }

    public void setProductNameDetails(String productNameDetails) {
        this.productNameDetails = productNameDetails;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
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

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseShippingFee() {
        return purchaseShippingFee;
    }

    public void setPurchaseShippingFee(BigDecimal purchaseShippingFee) {
        this.purchaseShippingFee = purchaseShippingFee;
    }

    public BigDecimal getPurchaseOtherFee() {
        return purchaseOtherFee;
    }

    public void setPurchaseOtherFee(BigDecimal purchaseOtherFee) {
        this.purchaseOtherFee = purchaseOtherFee;
    }

    public BigDecimal getPurchaseTotalAmount() {
        return purchaseTotalAmount;
    }

    public void setPurchaseTotalAmount(BigDecimal purchaseTotalAmount) {
        this.purchaseTotalAmount = purchaseTotalAmount;
    }

    public String getPurchaseInspection() {
        return purchaseInspection;
    }

    public void setPurchaseInspection(String purchaseInspection) {
        this.purchaseInspection = purchaseInspection;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getPurchaseRemarks() {
        return purchaseRemarks;
    }

    public void setPurchaseRemarks(String purchaseRemarks) {
        this.purchaseRemarks = purchaseRemarks;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getSellingShippingFee() {
        return sellingShippingFee;
    }

    public void setSellingShippingFee(BigDecimal sellingShippingFee) {
        this.sellingShippingFee = sellingShippingFee;
    }

    public BigDecimal getSellingOtherFee() {
        return sellingOtherFee;
    }

    public void setSellingOtherFee(BigDecimal sellingOtherFee) {
        this.sellingOtherFee = sellingOtherFee;
    }

    public BigDecimal getSellingTotalAmount() {
        return sellingTotalAmount;
    }

    public void setSellingTotalAmount(BigDecimal sellingTotalAmount) {
        this.sellingTotalAmount = sellingTotalAmount;
    }

    public String getSellingInspection() {
        return sellingInspection;
    }

    public void setSellingInspection(String sellingInspection) {
        this.sellingInspection = sellingInspection;
    }

    public String getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(String sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public String getSellingRemarks() {
        return sellingRemarks;
    }

    public void setSellingRemarks(String sellingRemarks) {
        this.sellingRemarks = sellingRemarks;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("orderNumber", getOrderNumber())
                .append("orderId", getOrderId())
                .append("logisticsCompany", getLogisticsCompany())
                .append("trackingNumber", getTrackingNumber())
                .append("recipientName", getRecipientName())
                .append("recipientPhone", getRecipientPhone())
                .append("address", getAddress())
                .append("productName", getProductName())
                .append("specifications", getSpecifications())
                .append("quantity", getQuantity())
                .append("productCode", getProductCode())
                .append("memberRemarks", getMemberRemarks())
                .append("leader", getLeader())
                .append("filter", getFilter())
                .append("date", getDate())
                .append("productNameDetails", getProductNameDetails())
                .append("multiplier", getMultiplier())
                .append("afterSalesStatus", getAfterSalesStatus())
                .append("remarks", getRemarks())
                .append("internalProductCode", getInternalProductCode())
                .append("stockQuantity", getStockQuantity())
                .append("brand", getBrand())
                .append("purchasePrice", getPurchasePrice())
                .append("purchaseShippingFee", getPurchaseShippingFee())
                .append("purchaseOtherFee", getPurchaseOtherFee())
                .append("purchaseTotalAmount", getPurchaseTotalAmount())
                .append("purchaseInspection", getPurchaseInspection())
                .append("purchaseStatus", getPurchaseStatus())
                .append("purchaseRemarks", getPurchaseRemarks())
                .append("sellingPrice", getSellingPrice())
                .append("sellingShippingFee", getSellingShippingFee())
                .append("sellingOtherFee", getSellingOtherFee())
                .append("sellingTotalAmount", getSellingTotalAmount())
                .append("sellingInspection", getSellingInspection())
                .append("sellingStatus", getSellingStatus())
                .append("sellingRemarks", getSellingRemarks())
                .append("profit", getProfit())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
