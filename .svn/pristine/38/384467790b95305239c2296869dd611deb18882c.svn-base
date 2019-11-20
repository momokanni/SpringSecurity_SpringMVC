package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/22/19 14 19
 * Description:
 */
public class FaeRepayInfo {

    /**
     * CREATE TABLE `fae_repay_info` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `establishId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '对应的成立信息(fae_establish_info)',
     *   `repayPhase` int(4) NOT NULL DEFAULT '0' COMMENT '还款期数',
     *   `repayPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '还款本金',
     *   `repayInterest` decimal(14,2) DEFAULT '0.00' COMMENT '还款利息',
     *   `repayStatus` int(4) NOT NULL DEFAULT '0' COMMENT '0-未还,1-还款中.2-已还',
     *   `createTime` datetime NOT NULL COMMENT '创建时间',
     *   `repayDate` date DEFAULT NULL COMMENT '还款日期',
     *   `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '产品id',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借款人还款计划';
     */

    private int id;

    private int establishId;

    private int repayPhase;

    private BigDecimal repayPrincipal;

    private BigDecimal repayInterest;

    private int repayStatus;

    private Date createTime;

    private Date repayDate;

    private int productId;

    public enum RepayStatus{
        notRepay(0,"未还"),
        repaying(1,"还款中"),
        repayed(2,"已还"),
        ;
        private int status;

        private String desc;

        RepayStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public static RepayStatus getRepayStatusByStatus(int status){
            for(RepayStatus rs : values()){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstablishId() {
        return establishId;
    }

    public void setEstablishId(int establishId) {
        this.establishId = establishId;
    }

    public int getRepayPhase() {
        return repayPhase;
    }

    public void setRepayPhase(int repayPhase) {
        this.repayPhase = repayPhase;
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

    public int getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(int repayStatus) {
        this.repayStatus = repayStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
