package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/25/19 14 05
 * Description:
 */
public class FaeInvestorRepayPhase {

    /**
     * CREATE TABLE `fae_investor_repay_phase` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `investorId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '投资人id',
     *   `investRecordId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '投资记录Id',
     *   `phase` int(4) NOT NULL DEFAULT '0' COMMENT '回款期数',
     *   `repayInfoId` int(10) unsigned NOT NULL COMMENT 'fae_repay_info(id)',
     *   `repayPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '回款本金',
     *   `repayInterest` decimal(14,2) DEFAULT '0.00' COMMENT '回款利息',
     *   `back` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已经回款',
     *   `repayDate` date DEFAULT NULL COMMENT '回款日期',
     *   `actualRepayTime` datetime DEFAULT NULL COMMENT '实际回款时间',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资人回款计划';
     */

    private int id;

    private int investorId;

    private int investRecordId;

    private int phase;

    private int repayInfoId;

    private BigDecimal repayPrincipal;

    private BigDecimal repayInterest;

    private boolean back;

    private Date repayDate;

    private Date actualRepayTime;

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

    public int getInvestRecordId() {
        return investRecordId;
    }

    public void setInvestRecordId(int investRecordId) {
        this.investRecordId = investRecordId;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getRepayInfoId() {
        return repayInfoId;
    }

    public void setRepayInfoId(int repayInfoId) {
        this.repayInfoId = repayInfoId;
    }

    public BigDecimal getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(BigDecimal repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public BigDecimal getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(BigDecimal repayInterest) {
        this.repayInterest = repayInterest;
    }

    public boolean isBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Date getActualRepayTime() {
        return actualRepayTime;
    }

    public void setActualRepayTime(Date actualRepayTime) {
        this.actualRepayTime = actualRepayTime;
    }
}
