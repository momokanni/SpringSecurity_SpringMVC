package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/25/19 11 02
 * Description:
 */
public class FaeEstablishInfo {

    /**
     * CREATE TABLE `fae_establish_info` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `productId` int(11) NOT NULL DEFAULT '0' COMMENT '产品id',
     *   `establishDate` date DEFAULT NULL COMMENT '成立日',
     *   `phase` int(4) NOT NULL DEFAULT '0' COMMENT '成立期数',
     *   `createTime` datetime DEFAULT NULL COMMENT '创建时间(导入时间)',
     *   `establishAmount` decimal(14,2) DEFAULT '0.00' COMMENT '成立金额',
     *   `dueDate` date DEFAULT NULL COMMENT '产品到期日',
     *   `incomeTerm` int(4) NOT NULL DEFAULT '0' COMMENT '这一期的投资收益期（天）',
     *   `status` int(4) NOT NULL DEFAULT '0' COMMENT '0-未成立,1-处理中,2-已成立',
     *   PRIMARY KEY (`id`),
     *   KEY `idx_productId` (`productId`) USING BTREE
     * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品成立信息表';
     */
    private int id;

    private int productId;

    private Date establishDate;

    private int phase;

    private Date createTime;

    private BigDecimal establishAmount;

    private Date dueDate;

    private int incomeTerm;

    private int status;

    private int buyCount;//认购笔数

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public enum EstablishStatus {

        notEs(0,"未成立"),
        handling(1,"处理中"),
        succ(2,"已成立"),
        fail(3,"成立失败"),
        ;

        private int status;

        private String desc;

        EstablishStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
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

        public static EstablishStatus getFaeEstablishStatusByStatus(int status){
            for(EstablishStatus pls : values()){
                if(pls.getStatus() == status)
                    return pls;
            }
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getEstablishAmount() {
        return establishAmount;
    }

    public void setEstablishAmount(BigDecimal establishAmount) {
        this.establishAmount = establishAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getIncomeTerm() {
        return incomeTerm;
    }

    public void setIncomeTerm(int incomeTerm) {
        this.incomeTerm = incomeTerm;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
