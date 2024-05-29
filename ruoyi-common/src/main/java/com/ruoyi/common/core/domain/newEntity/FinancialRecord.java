package com.ruoyi.common.core.domain.newEntity;

import com.alibaba.druid.sql.ast.statement.SQLCreateViewStatement;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

import static com.alibaba.druid.sql.ast.statement.SQLCreateViewStatement.*;

public class FinancialRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "编号")
    private String bianHao;


    /** 结算日期 */
    @Excel(name = "结算日期")
    private String settlementDate;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNumber;

    /** 产品名称_详细信息 */
    @Excel(name = "产品名称_详细信息")
    private String productNameDetails;

    /** 账款 */
    @Excel(name = "账款")
    private BigDecimal amount;

    /** 是否完成 */
    @Excel(name = "是否完成", readConverterExp = "0=否,1=是")
    private String isCompleted;

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    /** 支出收入 */
    @Excel(name = "支出收入")
    private String incomeExpense;

    /** 付款项目 */
    @Excel(name = "付款项目")
    private String paymentItem;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 出货方 */
    @Excel(name = "出货方")
    private String supplier;

    /** 处理人 */
    @Excel(name = "处理人")
    private String handler;

    public String getBianHao() {
        return bianHao;
    }

    public void setBianHao(String bianHao) {
        this.bianHao = bianHao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductNameDetails() {
        return productNameDetails;
    }

    public void setProductNameDetails(String productNameDetails) {
        this.productNameDetails = productNameDetails;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getIncomeExpense() {
        return incomeExpense;
    }

    public void setIncomeExpense(String incomeExpense) {
        this.incomeExpense = incomeExpense;
    }

    public String getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(String paymentItem) {
        this.paymentItem = paymentItem;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bianHao", getBianHao())
                .append("settlementDate", getSettlementDate())
                .append("date", getDate())
                .append("orderNumber", getOrderNumber())
                .append("productNameDetails", getProductNameDetails())
                .append("amount", getAmount())
                .append("isCompleted", getIsCompleted())
                .append("incomeExpense", getIncomeExpense())
                .append("paymentItem", getPaymentItem())
                .append("remarks", getRemarks())
                .append("brand", getBrand())
                .append("supplier", getSupplier())
                .append("handler", getHandler())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
