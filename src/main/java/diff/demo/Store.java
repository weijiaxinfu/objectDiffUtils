package diff.demo;


import diff.demo.myDiff2.Diff;
import diff.demo.myDiff2.NotDiff;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Diff
public class Store implements Serializable {
    //42
    private static final long serialVersionUID = 1L;

    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 楼盘字典id
     */
    private Long standardId;
    /**
     * 经纪公司名称
     */
    private String companyName;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 地级市的城市id
     */
    private Integer cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 地区编码
     */
    @Diff
    private String areaCode;
    /**
     * 地区名称
     */

    private String areaName;
    /**
     * 地址
     */
    @NotDiff
    private String storeAddress;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 品牌(1自营2加盟)
     */
    private Integer brand;
    /**
     * 位置(1临街2角店3其他)
     */
    private String positionDesc;
    /**
     * 其他位置描述
     */
    private String positionOther;
    /**
     * 店面面积
     */
    private BigDecimal storeArea;
    /**
     * 门头宽度
     */
    private BigDecimal gateWidth;
    /**
     * 开店时间
     */
    private Date startTime;
    /**
     * 店长姓名
     */
    private String shopownerName;
    /**
     * 店长联系方式
     */
    private String shopownerPhone1;
    /**
     * 店长联系方式
     */
    private String shopownerPhone2;
    /**
     * 店长联系方式
     */
    private String shopownerPhone3;
    /**
     * 租金(万元/年)
     */
    private BigDecimal storeRent;
    /**
     * 租期截止日期
     */
    private Date storeDeadline;
    /**
     * 门店状况评价(1.优2.良3.中4.差)
     */
    private Integer storeEvaluation;
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 加盟商id
     */
    private Long storeFranid;
    /**
     * 加盟状态
     */
    private Integer storeJoinstatus;
    /**
     * 关联时间
     */
    private Date storeAssotime;
    /**
     * 关联门店和加盟商的bd的ucid
     */
    private Long storeAssoclaim;
    /**
     * 陌生拜访态度
     */
    private Integer storeStrangeVisit;
    /**
     *
     */
    private String storeNote;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人ucid
     */
    private Long createUcid;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态：1-生效，0-关店
     */
    private Integer status;

    /**
     * 参与绑定的工作人员的UC ID
     */
    private Long workerUcId;
    /**
     * 操作时间
     */
    private Date claimTime;
    /**
     * 所属大区名字
     */
    private String districtName;
    /**
     * 门店状态（0-待审核，1-核准开业）
     */
    private Integer storeStatus;
    /**
     * 关店描述
     */
    private String closeDesc;
    /**
     * 所属品牌编码
     */
    private String merchantBrand;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionOther(String positionOther) {
        this.positionOther = positionOther;
    }

    public String getPositionOther() {
        return positionOther;
    }

    public void setStoreArea(BigDecimal storeArea) {
        this.storeArea = storeArea;
    }

    public BigDecimal getStoreArea() {
        return storeArea;
    }

    public void setGateWidth(BigDecimal gateWidth) {
        this.gateWidth = gateWidth;
    }

    public BigDecimal getGateWidth() {
        return gateWidth;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setShopownerName(String shopownerName) {
        this.shopownerName = shopownerName;
    }

    public String getShopownerName() {
        return shopownerName;
    }

    public void setShopownerPhone1(String shopownerPhone1) {
        this.shopownerPhone1 = shopownerPhone1;
    }

    public String getShopownerPhone1() {
        return shopownerPhone1;
    }

    public void setShopownerPhone2(String shopownerPhone2) {
        this.shopownerPhone2 = shopownerPhone2;
    }

    public String getShopownerPhone2() {
        return shopownerPhone2;
    }

    public void setShopownerPhone3(String shopownerPhone3) {
        this.shopownerPhone3 = shopownerPhone3;
    }

    public String getShopownerPhone3() {
        return shopownerPhone3;
    }

    public void setStoreRent(BigDecimal storeRent) {
        this.storeRent = storeRent;
    }

    public BigDecimal getStoreRent() {
        return storeRent;
    }

    public void setStoreDeadline(Date storeDeadline) {
        this.storeDeadline = storeDeadline;
    }

    public Date getStoreDeadline() {
        return storeDeadline;
    }

    public void setStoreEvaluation(Integer storeEvaluation) {
        this.storeEvaluation = storeEvaluation;
    }

    public Integer getStoreEvaluation() {
        return storeEvaluation;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setStoreFranid(Long storeFranid) {
        this.storeFranid = storeFranid;
    }

    public Long getStoreFranid() {
        return storeFranid;
    }

    public void setStoreJoinstatus(Integer storeJoinstatus) {
        this.storeJoinstatus = storeJoinstatus;
    }

    public Integer getStoreJoinstatus() {
        return storeJoinstatus;
    }

    public void setStoreAssotime(Date storeAssotime) {
        this.storeAssotime = storeAssotime;
    }

    public Date getStoreAssotime() {
        return storeAssotime;
    }

    public void setStoreAssoclaim(Long storeAssoclaim) {
        this.storeAssoclaim = storeAssoclaim;
    }

    public Long getStoreAssoclaim() {
        return storeAssoclaim;
    }

    public void setStoreStrangeVisit(Integer storeStrangeVisit) {
        this.storeStrangeVisit = storeStrangeVisit;
    }

    public Integer getStoreStrangeVisit() {
        return storeStrangeVisit;
    }

    public void setStoreNote(String storeNote) {
        this.storeNote = storeNote;
    }

    public String getStoreNote() {
        return storeNote;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateUcid(Long createUcid) {
        this.createUcid = createUcid;
    }

    public Long getCreateUcid() {
        return createUcid;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getCloseDesc() {
        return closeDesc;
    }

    public void setCloseDesc(String closeDesc) {
        this.closeDesc = closeDesc;
    }


    public String getMerchantBrand() {
        return merchantBrand;
    }

    /**
     * fixme 0614
     *
     * @param merchantBrand
     */
    public void setMerchantBrand(String merchantBrand) {
        this.merchantBrand = merchantBrand;
    }

    public Long getWorkerUcId() {
        return workerUcId;
    }

    public void setWorkerUcId(Long workerUcId) {
        this.workerUcId = workerUcId;
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public boolean isReadyForStepOne() {
        boolean storeAreaOk = (null != this.storeArea && this.storeArea.intValue() > 0);
        boolean gateWidthOk = (null != this.gateWidth && this.gateWidth.intValue() > 0);
        if (!isEmpty(this.companyName) && !isEmpty(this.storeName)
                && !isEmpty(this.cityCode)
                && !isEmpty(this.storeAddress)
                && !isEmpty(this.positionDesc) && storeAreaOk
                && gateWidthOk) {
            return true;
        } else {
            return false;
        }
    }


}
