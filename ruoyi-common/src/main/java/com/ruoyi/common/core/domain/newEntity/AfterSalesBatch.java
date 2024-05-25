package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class AfterSalesBatch extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 售后批发ID */
    @Excel(name = "售后批发ID")
    private Long afterSalesBatchId;

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
    private String recipient;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 品牌方 */
    @Excel(name = "品牌方")
    private String brand;

    /** 退货和售后方 */
    @Excel(name = "退货和售后方")
    private String returnAndAfterSales;

    /** 采购价 */
    @Excel(name = "采购价")
    private BigDecimal purchasePrice;

    /** 采购_其他费 */
    @Excel(name = "采购_其他费")
    private BigDecimal purchaseOtherCost;

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

    /** 出货_其他费 */
    @Excel(name = "出货_其他费")
    private BigDecimal sellingOtherCost;

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

    /** 损耗 */
    @Excel(name = "损耗")
    private BigDecimal loss;

    /** 发货编码 */
    @Excel(name = "发货编码")
    private String shipmentCode;

    public Long getAfterSalesBatchId() {
        return afterSalesBatchId;
    }

    public void setAfterSalesBatchId(Long afterSalesBatchId) {
        this.afterSalesBatchId = afterSalesBatchId;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReturnAndAfterSales() {
        return returnAndAfterSales;
    }

    public void setReturnAndAfterSales(String returnAndAfterSales) {
        this.returnAndAfterSales = returnAndAfterSales;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseOtherCost() {
        return purchaseOtherCost;
    }

    public void setPurchaseOtherCost(BigDecimal purchaseOtherCost) {
        this.purchaseOtherCost = purchaseOtherCost;
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

    public BigDecimal getSellingOtherCost() {
        return sellingOtherCost;
    }

    public void setSellingOtherCost(BigDecimal sellingOtherCost) {
        this.sellingOtherCost = sellingOtherCost;
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

    public BigDecimal getLoss() {
        return loss;
    }

    public void setLoss(BigDecimal loss) {
        this.loss = loss;
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
                .append("afterSalesBatchId", afterSalesBatchId)
                .append("orderNumber", orderNumber)
                .append("productName", productName)
                .append("internalProductCode", internalProductCode)
                .append("quantity", quantity)
                .append("recipient", recipient)
                .append("contactPhone", contactPhone)
                .append("address", address)
                .append("date", date)
                .append("remarks", remarks)
                .append("brand", brand)
                .append("returnAndAfterSales", returnAndAfterSales)
                .append("purchasePrice", purchasePrice)
                .append("purchaseOtherCost", purchaseOtherCost)
                .append("purchaseTotalAmount", purchaseTotalAmount)
                .append("purchaseInspection", purchaseInspection)
                .append("purchaseStatus", purchaseStatus)
                .append("purchaseRemarks", purchaseRemarks)
                .append("sellingPrice", sellingPrice)
                .append("sellingOtherCost", sellingOtherCost)
                .append("sellingTotalAmount", sellingTotalAmount)
                .append("sellingInspection", sellingInspection)
                .append("sellingStatus", sellingStatus)
                .append("sellingRemarks", sellingRemarks)
                .append("loss", loss)
                .append("shipmentCode", shipmentCode)
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
