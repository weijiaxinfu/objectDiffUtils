package diff.demo;



import diff.demo.myDiff2.Diff;

import java.util.List;

//63
@Diff
public class StoreInfoDTO extends Store {
    private static final long serialVersionUID = 1L;


    private  Person  person;
    /**
     * 联系方式列表
     */
    private List<String> shopownerPhones;
    /**
     * 图片列表
     */
    private List<String> picUrls;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 店面位置描述:临街,角店
     */
    private List<String> posDesc;
    /**
     * 门店状况评价
     */
    private String storeEvaluationDesc;
    /**
     * 加盟商姓名
     */
    private String franchiserName;
    /**
     * 加盟商加盟状态值
     */
    private String franchiserStatus;
    /**
     * 加盟商加盟状态名称
     */
    private String franchiserStatusName;
    /**
     * 位置1,2,3
     */
    private List<String> positionList;

    /**
     * 关联人姓名
     */
    private String storeAssoclaimName;


    /**
     * 门店审核状态(1:审核中,2:审核通过,3:信息错误,4:重复店面)
     */
    private Integer checkStatus;

    /**
     * tip文案
     */
    private String tips;
    /**
     * 是否超过72小时，只有状态为信息错误才会有这个字段，超过72小时为true,不超过为false
     */
    private Boolean isOver72hours;

    /**
     * PC端查询需返回区域
     */
    private String area;

    /**
     * PC端查询需返回跟进人姓名
     */
    private String workerUcName;

    /**
     * PC端跟进人电话
     */
    private String workerUcPhone;

    /**
     * 这个字段是在门店失效时,对应的有效门店的storeId
     */
    private Long validStoreId;
    /**
     * 加盟商电话
     */
    private String franchiserPhone1;
    private String franchiserPhone2;
    private String franchiserPhone3;


    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<String> getPosDesc() {
        return posDesc;
    }

    public void setPosDesc(List<String> posDesc) {
        this.posDesc = posDesc;
    }

    public String getStoreEvaluationDesc() {
        return storeEvaluationDesc;
    }

    public void setStoreEvaluationDesc(String storeEvaluationDesc) {
        this.storeEvaluationDesc = storeEvaluationDesc;
    }

    public List<String> getShopownerPhones() {
        return shopownerPhones;
    }

    public void setShopownerPhones(List<String> shopownerPhones) {
        this.shopownerPhones = shopownerPhones;
    }

    public String getFranchiserStatus() {
        return franchiserStatus;
    }

    public void setFranchiserStatus(String franchiserStatus) {
        this.franchiserStatus = franchiserStatus;
    }

    public String getFranchiserStatusName() {
        return franchiserStatusName;
    }

    public void setFranchiserStatusName(String franchiserStatusDesc) {
        this.franchiserStatusName = franchiserStatusDesc;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }

    public List<String> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<String> positionList) {
        this.positionList = positionList;
    }

    public String getStoreAssoclaimName() {
        return storeAssoclaimName;
    }

    public void setStoreAssoclaimName(String storeAssoclaimName) {
        this.storeAssoclaimName = storeAssoclaimName;
    }


    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Boolean getOver72hours() {
        return isOver72hours;
    }

    public void setOver72hours(Boolean over72hours) {
        isOver72hours = over72hours;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWorkerUcName() {
        return workerUcName;
    }

    public void setWorkerUcName(String workerUcName) {
        this.workerUcName = workerUcName;
    }

    public String getWorkerUcPhone() {
        return workerUcPhone;
    }

    public void setWorkerUcPhone(String workerUcPhone) {
        this.workerUcPhone = workerUcPhone;
    }

    public String getFranchiserPhone1() {
        return franchiserPhone1;
    }

    public void setFranchiserPhone1(String franchiserPhone1) {
        this.franchiserPhone1 = franchiserPhone1;
    }

    public String getFranchiserPhone2() {
        return franchiserPhone2;
    }

    public void setFranchiserPhone2(String franchiserPhone2) {
        this.franchiserPhone2 = franchiserPhone2;
    }

    public String getFranchiserPhone3() {
        return franchiserPhone3;
    }

    public void setFranchiserPhone3(String franchiserPhone3) {
        this.franchiserPhone3 = franchiserPhone3;
    }

    public Long getValidStoreId() {
        return validStoreId;
    }

    public void setValidStoreId(Long validStoreId) {
        this.validStoreId = validStoreId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
