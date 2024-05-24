package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 收入明细ID */
    @Excel(name = "收入明细ID")
    private Long incomeDetailId;

    /** 订单序列号 */
    @Excel(name = "订单序列号")
    private String orderSerialNumber;

    /** 发票日期 */
    @Excel(name = "发票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceDate;

    /** 发票号 */
    @Excel(name = "发票号")
    private String invoiceNumber;

    /** 客人姓名 */
    @Excel(name = "客人姓名")
    private String customerName;

    /** 国际/国内 */
    @Excel(name = "国际/国内")
    private String internationalOrDomestic;

    /** 销售金额 */
    @Excel(name = "销售金额")
    private BigDecimal salesAmount;

    /** 进账方式 */
    @Excel(name = "进账方式")
    private String paymentMethod;

    /** 进帐日期 */
    @Excel(name = "进帐日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentDate;

    /** 入帐金额 */
    @Excel(name = "入帐金额")
    private BigDecimal paymentAmount;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 销售办公室 */
    @Excel(name = "销售办公室")
    private String salesOffice;

    /** 经办人 */
    @Excel(name = "经办人")
    private String handler;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    public Long getIncomeDetailId() {
        return incomeDetailId;
    }

    public void setIncomeDetailId(Long incomeDetailId) {
        this.incomeDetailId = incomeDetailId;
    }

    public String getOrderSerialNumber() {
        return orderSerialNumber;
    }

    public void setOrderSerialNumber(String orderSerialNumber) {
        this.orderSerialNumber = orderSerialNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInternationalOrDomestic() {
        return internationalOrDomestic;
    }

    public void setInternationalOrDomestic(String internationalOrDomestic) {
        this.internationalOrDomestic = internationalOrDomestic;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSalesOffice() {
        return salesOffice;
    }

    public void setSalesOffice(String salesOffice) {
        this.salesOffice = salesOffice;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("incomeDetailId", incomeDetailId)
                .append("orderSerialNumber", orderSerialNumber)
                .append("invoiceDate", invoiceDate)
                .append("invoiceNumber", invoiceNumber)
                .append("customerName", customerName)
                .append("internationalOrDomestic", internationalOrDomestic)
                .append("salesAmount", salesAmount)
                .append("paymentMethod", paymentMethod)
                .append("paymentDate", paymentDate)
                .append("paymentAmount", paymentAmount)
                .append("remarks", remarks)
                .append("salesOffice", salesOffice)
                .append("handler", handler)
                .append("attachment", attachment)
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
