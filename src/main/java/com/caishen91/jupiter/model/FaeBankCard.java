package com.caishen91.jupiter.model;

import java.util.Date;

/**
 * 银行卡
 */
public class FaeBankCard {
    private int id;

    private String bankCode;

    private String bankName;

    private String slaveName;

    private int investorId;

    private int status;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSlaveName() {
        return slaveName;
    }

    public void setSlaveName(String slaveName) {
        this.slaveName = slaveName;
    }

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static enum FaeBankCardStatus{
        historyCard(0, "历史卡"),
        currentCard(1, "正在使用的卡"),
        ;

        private int status;

        private String desc;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        FaeBankCardStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public static FaeBankCardStatus getFaeBankCardStatus(int status) {
            for (FaeBankCardStatus faeBankCardStatus : values()) {
                if (faeBankCardStatus.getStatus() == status) {
                    return faeBankCardStatus;
                }
            }
            return null;
        }
    }
}
