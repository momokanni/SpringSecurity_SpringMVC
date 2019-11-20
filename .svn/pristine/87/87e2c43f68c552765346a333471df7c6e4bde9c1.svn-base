package com.caishen91.jupiter.model;

import java.util.Date;

public class FaeInvestor {

    private int id;

    private int type;

    private String realName;

    private String idCardNo;

    private String mobile;

    private int userSource;

    private int referrer;

    private String companyName;

    private String creditCode;

    private String businessLicense;

    private String legalPersonName;

    private String contacts;

    private String contactsTel;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUserSource() {
        return userSource;
    }

    public void setUserSource(int userSource) {
        this.userSource = userSource;
    }

    public int getReferrer() {
        return referrer;
    }

    public void setReferrer(int referrer) {
        this.referrer = referrer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static enum FaeInvestorType{

        personInvestor(1, "个人"),
        companyInvestor(2, "企业"),
        ;

        private int type;

        private String desc;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        FaeInvestorType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static FaeInvestorType getFaeInvestorType(int type) {
            for (FaeInvestorType faeInvestorType : values()) {
                if (faeInvestorType.getType() == type) {
                    return faeInvestorType;
                }
            }
            return null;
        }
    }
}
