package com.ruoyi.common.core.domain.newEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

public class Product extends BaseEntity {
    /** ID */
    @Excel(name = "ID")
    private Long productId;

    /** 录入时间 */
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryTime;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 内部商品编号 */
    @Excel(name = "内部商品编号")
    private String internalProductCode;

    /** 发货编码 */
    @Excel(name = "发货编码")
    private String shipmentCode;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 天猫挂价 */
    @Excel(name = "天猫挂价")
    @Digits(integer = Integer.MAX_VALUE, fraction = Integer.MAX_VALUE, message = "字段必须是数字")
    private BigDecimal tmallListingPrice;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionDate;

    /** 产品卖点 */
    @Excel(name = "产品卖点")
    private String productSellingPoints;

    /** 现货库存 */
    @Excel(name = "现货库存")
    private Integer currentStock;

    /** 实际返单时效 */
    @Excel(name = "实际返单时效", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date actualOrderTime;

    /** 活动控价 */
    @Excel(name = "活动控价")
    private String promotionPriceControl;

    /** 退货地址 */
    @Excel(name = "退货地址")
    private String returnAddress;

    /** 快递明细 */
    @Excel(name = "快递明细")
    private String shippingDetails;

    /** 其他平台客单价 */
    @Excel(name = "其他平台客单价")
    private BigDecimal otherPlatformPrice;

    /** 链接 */
    @Excel(name = "链接")
    private String link;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 筛选 */
    @Excel(name = "筛选")
    private String filter;

    /** 品类 */
    @Excel(name = "品类")
    private String category;

    /** 剩余库存 */
    @Excel(name = "剩余库存")
    private Integer remainingStock;

    /** 售后数量 */
    @Excel(name = "售后数量")
    private Integer afterSalesQuantity;

    /** 品牌方 */
    @Excel(name = "品牌方")
    private String brandOwner;

    /** 产品状态 */
    @Excel(name = "产品状态")
    private String productStatus;

    /** 采购价 */
    @Excel(name = "采购价")
    private BigDecimal purchasePrice;

    /** 运费 */
    @Excel(name = "运费")
    private BigDecimal shippingCost;

    /** 出货价_链 */
    @Excel(name = "出货价_链")
    private BigDecimal shippingPriceChain;

    /** 出货价_代发 */
    @Excel(name = "出货价_代发")
    private BigDecimal shippingPriceDropship;

    /** 出货价_详细代发 */
    @Excel(name = "出货价_详细代发")
    private BigDecimal shippingPriceDetailedDropship;

    /** 采购_注意事项 */
    @Excel(name = "采购_注意事项")
    private String purchaseNotes;

    /** 出货_注意事项 */
    @Excel(name = "出货_注意事项")
    private String shippingNotes;

    /** 公域挂价_天猫_淘宝_京东 */
    @Excel(name = "公域挂价_天猫_淘宝_京东")
    private BigDecimal publicListingPriceTmallTaobaoJd;

    /** 拼多多挂价 */
    @Excel(name = "拼多多挂价")
    private BigDecimal pinduoduoListingPrice;

    /** 私域_团购_快团等 */
    @Excel(name = "私域_团购_快团等")
    private BigDecimal privateGroupBuyPrice;

    /** 直播挂价_专属价_日常改原价 */
    @Excel(name = "直播挂价_专属价_日常改原价")
    private BigDecimal liveStreamPrice;

    /** 出货价_1档 */
    @Excel(name = "出货价_1档")
    private BigDecimal shippingPriceTier1;

    /** 出货价_2档 */
    @Excel(name = "出货价_2档")
    private BigDecimal shippingPriceTier2;

    /** 代发出货价 */
    @Excel(name = "代发出货价")
    private BigDecimal dropshipShippingPrice;

    /** 阿里挂价 */
    @Excel(name = "阿里挂价")
    private BigDecimal alibabaListingPrice;




    private String entryStartDate;
    private String entryEndDate;
    private String productionStartDate;
    private String productionEndDate;

    public String getEntryStartDate() {
        return entryStartDate;
    }

    public void setEntryStartDate(String entryStartDate) {
        this.entryStartDate = entryStartDate;
    }

    public String getEntryEndDate() {
        return entryEndDate;
    }

    public void setEntryEndDate(String entryEndDate) {
        this.entryEndDate = entryEndDate;
    }

    public String getProductionStartDate() {
        return productionStartDate;
    }

    public void setProductionStartDate(String productionStartDate) {
        this.productionStartDate = productionStartDate;
    }

    public String getProductionEndDate() {
        return productionEndDate;
    }

    public void setProductionEndDate(String productionEndDate) {
        this.productionEndDate = productionEndDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public BigDecimal getTmallListingPrice() {
        return tmallListingPrice;
    }

    public void setTmallListingPrice(BigDecimal tmallListingPrice) {
        this.tmallListingPrice = tmallListingPrice;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getProductSellingPoints() {
        return productSellingPoints;
    }

    public void setProductSellingPoints(String productSellingPoints) {
        this.productSellingPoints = productSellingPoints;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Date getActualOrderTime() {
        return actualOrderTime;
    }

    public void setActualOrderTime(Date actualOrderTime) {
        this.actualOrderTime = actualOrderTime;
    }

    public String getPromotionPriceControl() {
        return promotionPriceControl;
    }

    public void setPromotionPriceControl(String promotionPriceControl) {
        this.promotionPriceControl = promotionPriceControl;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public BigDecimal getOtherPlatformPrice() {
        return otherPlatformPrice;
    }

    public void setOtherPlatformPrice(BigDecimal otherPlatformPrice) {
        this.otherPlatformPrice = otherPlatformPrice;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }

    public Integer getAfterSalesQuantity() {
        return afterSalesQuantity;
    }

    public void setAfterSalesQuantity(Integer afterSalesQuantity) {
        this.afterSalesQuantity = afterSalesQuantity;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getShippingPriceChain() {
        return shippingPriceChain;
    }

    public void setShippingPriceChain(BigDecimal shippingPriceChain) {
        this.shippingPriceChain = shippingPriceChain;
    }

    public BigDecimal getShippingPriceDropship() {
        return shippingPriceDropship;
    }

    public void setShippingPriceDropship(BigDecimal shippingPriceDropship) {
        this.shippingPriceDropship = shippingPriceDropship;
    }

    public BigDecimal getShippingPriceDetailedDropship() {
        return shippingPriceDetailedDropship;
    }

    public void setShippingPriceDetailedDropship(BigDecimal shippingPriceDetailedDropship) {
        this.shippingPriceDetailedDropship = shippingPriceDetailedDropship;
    }

    public String getPurchaseNotes() {
        return purchaseNotes;
    }

    public void setPurchaseNotes(String purchaseNotes) {
        this.purchaseNotes = purchaseNotes;
    }

    public String getShippingNotes() {
        return shippingNotes;
    }

    public void setShippingNotes(String shippingNotes) {
        this.shippingNotes = shippingNotes;
    }

    public BigDecimal getPublicListingPriceTmallTaobaoJd() {
        return publicListingPriceTmallTaobaoJd;
    }

    public void setPublicListingPriceTmallTaobaoJd(BigDecimal publicListingPriceTmallTaobaoJd) {
        this.publicListingPriceTmallTaobaoJd = publicListingPriceTmallTaobaoJd;
    }

    public BigDecimal getPinduoduoListingPrice() {
        return pinduoduoListingPrice;
    }

    public void setPinduoduoListingPrice(BigDecimal pinduoduoListingPrice) {
        this.pinduoduoListingPrice = pinduoduoListingPrice;
    }

    public BigDecimal getPrivateGroupBuyPrice() {
        return privateGroupBuyPrice;
    }

    public void setPrivateGroupBuyPrice(BigDecimal privateGroupBuyPrice) {
        this.privateGroupBuyPrice = privateGroupBuyPrice;
    }

    public BigDecimal getLiveStreamPrice() {
        return liveStreamPrice;
    }

    public void setLiveStreamPrice(BigDecimal liveStreamPrice) {
        this.liveStreamPrice = liveStreamPrice;
    }

    public BigDecimal getShippingPriceTier1() {
        return shippingPriceTier1;
    }

    public void setShippingPriceTier1(BigDecimal shippingPriceTier1) {
        this.shippingPriceTier1 = shippingPriceTier1;
    }

    public BigDecimal getShippingPriceTier2() {
        return shippingPriceTier2;
    }

    public void setShippingPriceTier2(BigDecimal shippingPriceTier2) {
        this.shippingPriceTier2 = shippingPriceTier2;
    }

    public BigDecimal getDropshipShippingPrice() {
        return dropshipShippingPrice;
    }

    public void setDropshipShippingPrice(BigDecimal dropshipShippingPrice) {
        this.dropshipShippingPrice = dropshipShippingPrice;
    }

    public BigDecimal getAlibabaListingPrice() {
        return alibabaListingPrice;
    }

    public void setAlibabaListingPrice(BigDecimal alibabaListingPrice) {
        this.alibabaListingPrice = alibabaListingPrice;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productId", getProductId())
                .append("productName", getProductName())
                .append("internalProductCode", getInternalProductCode())
                .append("shipmentCode", getShipmentCode())
                .append("specifications", getSpecifications())
                .append("tmallListingPrice", getTmallListingPrice())
                .append("productionDate", getProductionDate())
                .append("productSellingPoints", getProductSellingPoints())
                .append("currentStock", getCurrentStock())
                .append("actualOrderTime", getActualOrderTime())
                .append("promotionPriceControl", getPromotionPriceControl())
                .append("returnAddress", getReturnAddress())
                .append("shippingDetails", getShippingDetails())
                .append("otherPlatformPrice", getOtherPlatformPrice())
                .append("link", getLink())
                .append("status", getStatus())
                .append("brand", getBrand())
                .append("filter", getFilter())
                .append("category", getCategory())
                .append("remainingStock", getRemainingStock())
                .append("afterSalesQuantity", getAfterSalesQuantity())
                .append("brandOwner", getBrandOwner())
                .append("productStatus", getProductStatus())
                .append("purchasePrice", getPurchasePrice())
                .append("shippingCost", getShippingCost())
                .append("shippingPriceChain", getShippingPriceChain())
                .append("shippingPriceDropship", getShippingPriceDropship())
                .append("shippingPriceDetailedDropship", getShippingPriceDetailedDropship())
                .append("purchaseNotes", getPurchaseNotes())
                .append("shippingNotes", getShippingNotes())
                .append("publicListingPriceTmallTaobaoJd", getPublicListingPriceTmallTaobaoJd())
                .append("pinduoduoListingPrice", getPinduoduoListingPrice())
                .append("privateGroupBuyPrice", getPrivateGroupBuyPrice())
                .append("liveStreamPrice", getLiveStreamPrice())
                .append("shippingPriceTier1", getShippingPriceTier1())
                .append("shippingPriceTier2", getShippingPriceTier2())
                .append("dropshipShippingPrice", getDropshipShippingPrice())
                .append("alibabaListingPrice", getAlibabaListingPrice())
                .append("entryTime", getEntryTime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
