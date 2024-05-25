package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class WholesaleRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long wholesaleRecordId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    /** 货数 */
    @Excel(name = "货数")
    private Integer quantity;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailedAddress;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 货拉拉费用 */
    @Excel(name = "货拉拉费用")
    private BigDecimal expressFee;

    /** 物流费用 */
    @Excel(name = "物流费用")
    private BigDecimal logisticsCost;

    /** 品牌方 */
    @Excel(name = "品牌方")
    private String brandOwner;

    /** 订货方 */
    @Excel(name = "订货方")
    private String orderingParty;

    /** 采购价 */
    @Excel(name = "采购价")
    private BigDecimal purchasePrice;

    /** 采购_运费 */
    @Excel(name = "采购_运费")
    private BigDecimal purchaseFreight;

    /** 采购_其他费 */
    @Excel(name = "采购_其他费")
    private BigDecimal purchaseOtherCosts;

    /** 采购_总额 */
    @Excel(name = "采购_总额")
    private BigDecimal purchaseTotal;

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
    private BigDecimal deliveryPrice;

    /** 出货_运费 */
    @Excel(name = "出货_运费")
    private BigDecimal deliveryFreight;

    /** 出货_其他费 */
    @Excel(name = "出货_其他费")
    private BigDecimal deliveryOtherCosts;

    /** 出货_总额 */
    @Excel(name = "出货_总额")
    private BigDecimal deliveryTotal;

    /** 出货_检查 */
    @Excel(name = "出货_检查")
    private String deliveryInspection;

    /** 出货_状况 */
    @Excel(name = "出货_状况")
    private String deliveryStatus;

    /** 出货_备注 */
    @Excel(name = "出货_备注")
    private String deliveryRemarks;

    /** 利润 */
    @Excel(name = "利润")
    private BigDecimal profit;

    /** 发货编码 */
    @Excel(name = "发货编码")
    private String shipmentCode;

    public Long getWholesaleRecordId() {
        return wholesaleRecordId;
    }

    public void setWholesaleRecordId(Long wholesaleRecordId) {
        this.wholesaleRecordId = wholesaleRecordId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(BigDecimal expressFee) {
        this.expressFee = expressFee;
    }

    public BigDecimal getLogisticsCost() {
        return logisticsCost;
    }

    public void setLogisticsCost(BigDecimal logisticsCost) {
        this.logisticsCost = logisticsCost;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getOrderingParty() {
        return orderingParty;
    }

    public void setOrderingParty(String orderingParty) {
        this.orderingParty = orderingParty;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseFreight() {
        return purchaseFreight;
    }

    public void setPurchaseFreight(BigDecimal purchaseFreight) {
        this.purchaseFreight = purchaseFreight;
    }

    public BigDecimal getPurchaseOtherCosts() {
        return purchaseOtherCosts;
    }

    public void setPurchaseOtherCosts(BigDecimal purchaseOtherCosts) {
        this.purchaseOtherCosts = purchaseOtherCosts;
    }

    public BigDecimal getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(BigDecimal purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
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

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getDeliveryFreight() {
        return deliveryFreight;
    }

    public void setDeliveryFreight(BigDecimal deliveryFreight) {
        this.deliveryFreight = deliveryFreight;
    }

    public BigDecimal getDeliveryOtherCosts() {
        return deliveryOtherCosts;
    }

    public void setDeliveryOtherCosts(BigDecimal deliveryOtherCosts) {
        this.deliveryOtherCosts = deliveryOtherCosts;
    }

    public BigDecimal getDeliveryTotal() {
        return deliveryTotal;
    }

    public void setDeliveryTotal(BigDecimal deliveryTotal) {
        this.deliveryTotal = deliveryTotal;
    }

    public String getDeliveryInspection() {
        return deliveryInspection;
    }

    public void setDeliveryInspection(String deliveryInspection) {
        this.deliveryInspection = deliveryInspection;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryRemarks() {
        return deliveryRemarks;
    }

    public void setDeliveryRemarks(String deliveryRemarks) {
        this.deliveryRemarks = deliveryRemarks;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("wholesaleRecordId", getWholesaleRecordId())
                .append("orderNumber", getOrderNumber())
                .append("productName", getProductName())
                .append("internalProductCode", getInternalProductCode())
                .append("quantity", getQuantity())
                .append("consignee", getConsignee())
                .append("contactNumber", getContactNumber())
                .append("detailedAddress", getDetailedAddress())
                .append("date", getDate())
                .append("remarks", getRemarks())
                .append("expressFee", getExpressFee())
                .append("logisticsCost", getLogisticsCost())
                .append("brandOwner", getBrandOwner())
                .append("orderingParty", getOrderingParty())
                .append("purchasePrice", getPurchasePrice())
                .append("purchaseFreight", getPurchaseFreight())
                .append("purchaseOtherCosts", getPurchaseOtherCosts())
                .append("purchaseTotal", getPurchaseTotal())
                .append("purchaseInspection", getPurchaseInspection())
                .append("purchaseStatus", getPurchaseStatus())
                .append("purchaseRemarks", getPurchaseRemarks())
                .append("deliveryPrice", getDeliveryPrice())
                .append("deliveryFreight", getDeliveryFreight())
                .append("deliveryOtherCosts", getDeliveryOtherCosts())
                .append("deliveryTotal", getDeliveryTotal())
                .append("deliveryInspection", getDeliveryInspection())
                .append("deliveryStatus", getDeliveryStatus())
                .append("deliveryRemarks", getDeliveryRemarks())
                .append("profit", getProfit())
                .append("shipmentCode", getShipmentCode())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
