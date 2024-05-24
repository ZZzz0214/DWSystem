package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class SupplierInfo extends BaseEntity {
    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierNumber;

    /** 出货商 */
    @Excel(name = "出货商")
    private String shipper;

    /** 收货人姓名 */
    @Excel(name = "收货人姓名")
    private String recipientName;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String recipientPhone;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 微信账号 */
    @Excel(name = "微信账号")
    private String wechatAccount;

    /** 支付宝账号 */
    @Excel(name = "支付宝账号")
    private String alipayAccount;

    /** 银行卡账号 */
    @Excel(name = "银行卡账号")
    private String bankAccount;

    /** 创建日期 */
    @Excel(name = "创建日期",  width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationDate;

    /** 出货总数 */
    @Excel(name = "出货总数")
    private Integer totalShipment;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
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

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getTotalShipment() {
        return totalShipment;
    }

    public void setTotalShipment(Integer totalShipment) {
        this.totalShipment = totalShipment;
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
                .append("supplierId", getSupplierId())
                .append("supplierNumber", getSupplierNumber())
                .append("shipper", getShipper())
                .append("recipientName", getRecipientName())
                .append("recipientPhone", getRecipientPhone())
                .append("address", getAddress())
                .append("wechatAccount", getWechatAccount())
                .append("alipayAccount", getAlipayAccount())
                .append("bankAccount", getBankAccount())
                .append("creationDate", getCreationDate())
                .append("totalShipment", getTotalShipment())
                .append("remarks", getRemarks())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
