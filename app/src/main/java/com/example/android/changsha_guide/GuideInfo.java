package com.example.android.changsha_guide;

/**
 * Created by PWT on 2017/5/31.
 */

public class GuideInfo {
    private String mBusinessHour;//营业时间

    private String mPhoneNumber;//联系电话

    private Integer mImageResuourceId = NO_IMAGE_PROVIDED;//图片Id

    private String mName;//名称

    private String mAdress;//所在位置

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * 餐馆的构造方法
     * @param mBusinessHour
     * @param mPhoneNumber
     * @param mName
     * @param mAdress
     */
    public GuideInfo(String mBusinessHour, String mPhoneNumber, String mName, String mAdress) {
        this.mBusinessHour = mBusinessHour;
        this.mPhoneNumber = mPhoneNumber;
        this.mName = mName;
        this.mAdress = mAdress;
    }

    /**
     * 公园/景点的构造方法
     * @param mImageResuourceId
     * @param mName
     * @param mAdress
     */
    public GuideInfo(Integer mImageResuourceId, String mName, String mAdress, String mBusinessHour) {
        this.mImageResuourceId = mImageResuourceId;
        this.mName = mName;
        this.mAdress = mAdress;
        this.mBusinessHour = mBusinessHour;
    }

    /**
     * It公司/酒店的构造方法
     * @param mName
     * @param mAdress
     */
    public GuideInfo(String mName, String mAdress,  String mPhoneNumber) {
        this.mName = mName;
        this.mAdress = mAdress;
        this.mPhoneNumber = mPhoneNumber;
    }

    public boolean hasImage(){
        return this.mImageResuourceId!= NO_IMAGE_PROVIDED;
    }

    public String getmBusinessHour() {
        return mBusinessHour;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public Integer getmImageResuourceId() {
        return mImageResuourceId;
    }

    public String getmName() {
        return mName;
    }

    public String getmAdress() {
        return mAdress;
    }

    @Override
    public String toString() {
        return "GuideInfo{" +
                "mBusinessHour='" + mBusinessHour + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mImageId='" + mImageResuourceId + '\'' +
                ", mName='" + mName + '\'' +
                ", mAdress='" + mAdress + '\'' +
                '}';
    }
}
