package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/21/19 15 04
 * Description:
 */
public class FaeInvestRecord {

    /**
     * CREATE TABLE `fae_invest_record` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `investorId` int(11) NOT NULL DEFAULT '0' COMMENT '投资人id',
     *   `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_product的id',
     *   `phase` int(4) NOT NULL DEFAULT '0' COMMENT '成立期数',
     *   `bankCardId` int(11) NOT NULL DEFAULT '0' COMMENT 'fae_bank_card(id)',
     *   `investAmount` decimal(14,2) DEFAULT '0.00' COMMENT '认购金额',
     *   `investTime` datetime DEFAULT NULL COMMENT '认购时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资记录表';
     */
    private int id;

    private int investorId;

    private int bankCardId;

    private BigDecimal investAmount;

    private Date investTime;

    private int productId;

    private int establishId;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public enum InvestRecordStatus{
        notRepay(0,"投资未回款"),
        repaying(1,"部分回款"),
        repayed(2,"全部回款"),
        ;
        private int status;

        private String desc;

        InvestRecordStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public static InvestRecordStatus getInvestRecordStatusByStatus(int status){
            for(InvestRecordStatus rs : values()){
                if(rs.getStatus() == status)
                    return rs;
            }
            return null;
        }

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
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEstablishId() {
        return establishId;
    }

    public void setEstablishId(int establishId) {
        this.establishId = establishId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }


    public int getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(int bankCardId) {
        this.bankCardId = bankCardId;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public Date getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }
}
