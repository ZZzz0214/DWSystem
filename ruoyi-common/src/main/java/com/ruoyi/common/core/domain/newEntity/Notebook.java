package com.ruoyi.common.core.domain.newEntity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Notebook extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** ID */
    @Excel(name = "ID")
    private Long recordId;

    /** 记录日期 */
    @Excel(name = "记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDate;

    /** 记录信息 */
    @Excel(name = "记录信息")
    private String recordInfo;

    /** 解决信息 */
    @Excel(name = "解决信息")
    private String resolutionInfo;

    /** 售后方 */
    @Excel(name = "售后方")
    private String afterSalesParty;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(String recordInfo) {
        this.recordInfo = recordInfo;
    }

    public String getResolutionInfo() {
        return resolutionInfo;
    }

    public void setResolutionInfo(String resolutionInfo) {
        this.resolutionInfo = resolutionInfo;
    }

    public String getAfterSalesParty() {
        return afterSalesParty;
    }

    public void setAfterSalesParty(String afterSalesParty) {
        this.afterSalesParty = afterSalesParty;
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
                .append("recordDate", getRecordDate())
                .append("recordInfo", getRecordInfo())
                .append("resolutionInfo", getResolutionInfo())
                .append("afterSalesParty", getAfterSalesParty())
                .append("remarks", getRemarks())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
