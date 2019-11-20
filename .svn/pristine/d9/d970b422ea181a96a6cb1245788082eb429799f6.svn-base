package com.caishen91.jupiter.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/18/19 09 50
 * Description:
 */
public class FaeProduct {

    /**
     * CREATE TABLE `fae_product` (
     *   `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
     *   `productType` int(4) NOT NULL DEFAULT '0' COMMENT '产品类型1-定向融资,2-收益权转让',
     *   `productName` varchar(128) NOT NULL DEFAULT '' COMMENT '产品名称',
     *   `issueId` int(11) NOT NULL DEFAULT '0' COMMENT '发行方id(fae_issue)',
     *   `underwriterId` int(11) NOT NULL DEFAULT '0' COMMENT '承销商id(fae_underwriter)',
     *   `danbaoId` int(11) NOT NULL DEFAULT '0' COMMENT '担保id(fae_danbao)',
     *   `entrustedId` int(11) NOT NULL DEFAULT '0' COMMENT '受托管理方id(fae_entrusted)',
     *   `raiseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '募集规模',
     *   `term` int(11) NOT NULL DEFAULT '0' COMMENT '产品期限',
     *   `termUnit` int(4) NOT NULL DEFAULT '1' COMMENT '期限单位1-天,2-月',
     *   `expectRate` decimal(4,2) DEFAULT '0.00' COMMENT '预期收益费率',
     *   `baseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '认购基数',
     *   `increaseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '递增基数',
     *   `buyType` int(4) NOT NULL DEFAULT '0' COMMENT '认购方式1-线上,2-线下',
     *   `holdCalType` int(4) NOT NULL DEFAULT '0' COMMENT '存续期计算方式1-固定,2-递减',
     *   `endDate` date DEFAULT NULL COMMENT '截止日',
     *   `dueDate` date DEFAULT NULL COMMENT '到期日',
     *   `trans` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可以转让0否,1是',
     *   `lockTerm` int(4) NOT NULL DEFAULT '0' COMMENT '锁定期',
     *   `lockUnit` int(4) NOT NULL DEFAULT '0' COMMENT '锁定期单位1-天,2-月',
     *   `minEstablishAmount` decimal(14,2) DEFAULT '0.00' COMMENT '最低成立金额',
     *   `establishType` int(4) NOT NULL DEFAULT '0' COMMENT '成立方式1-手动成立,2-自动成立',
     *   `establishDay` varchar(64) DEFAULT '' COMMENT '成立时间(每个自然月？日)',
     *   `yearCalType` int(8) NOT NULL DEFAULT '0' COMMENT '年化单位(360天,365天)',
     *   `settlementType` int(4) NOT NULL DEFAULT '0' COMMENT '结算方式(1-本息一次,2-按月付息,3-按季付息,4-半年付息,5-按年付息)',
     *   `fixed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否固定日期还息(0-否,1-固定)',
     *   `fixedMonth` int(4) NOT NULL DEFAULT '0' COMMENT '固定还息月',
     *   `fixedDay` int(4) NOT NULL DEFAULT '0' COMMENT '固定还息日',
     *   `hasHang` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有挂牌费0-无,1-有',
     *   `hangMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '挂牌费最低额',
     *   `hangRate` decimal(4,2) DEFAULT '0.00' COMMENT '挂牌年化费率',
     *   `hangFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '挂牌收费方式(1-前置,2-扣收,3-月结)',
     *   `hasCx` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有承销商费0-无,1-有',
     *   `cxMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '承销商费最低额',
     *   `cxRate` decimal(4,2) DEFAULT '0.00' COMMENT '承销商费年化费率',
     *   `cxFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '承销商费收费方式(1-前置,2-扣收,3-月结)',
     *   `hasDanbao` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有担保费(0-无,1-有)',
     *   `danbaoMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '担保费最低额',
     *   `danbaoRate` decimal(4,2) DEFAULT '0.00' COMMENT '担保费年化费率',
     *   `danbaoFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '担保费收费方式(1-前置,2-扣收,3-月结)',
     *   `amountUse` varchar(255) DEFAULT '' COMMENT '资金用途',
     *   `increaseCredit` varchar(255) DEFAULT '' COMMENT '增信措施',
     *   `remark` varchar(255) DEFAULT '' COMMENT '特殊事项备注',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=MyISAM DEFAULT CHARSET=utf8;
     */

    private int id;
    private int productType;
    private String productName;
    private int issueId;
    private int underwriterId;
    private int danbaoId;
    private int entrustedId;
    private BigDecimal raiseAmount;
    private int term;
    private int termUnit;
    private BigDecimal expectRate;
    private BigDecimal baseAmount;
    private BigDecimal increaseAmount;
    private int buyType;
    private int holdCalType;

    private Date endDate;
    private Date dueDate;
    private boolean trans;
    private int lockTerm;
    private int lockUnit;
    private BigDecimal minEstablishAmount;
    private int establishType;
    private String establishDay;
    private int yearCalType;
    private int settlementType;
    private boolean fixed;
    private int fixedMonth;
    private int fixedDay;

    private boolean hasHang;
    private BigDecimal hangMinFee;
    private BigDecimal hangRate;
    private int hangFeeType;
    private int hangYjDay;

    private boolean hasCx;
    private BigDecimal cxMinFee;
    private BigDecimal cxRate;
    private int cxFeeType;
    private int cxYjDay;

    private boolean hasSt;
    private BigDecimal stMinFee;
    private BigDecimal stRate;
    private int stFeeType;
    private int stYjDay;

    private String amountUse;
    private String increaseCredit;
    private String remark;
    private Date createTime;

    /**
     * 单位
     */
    public enum Unit{
        day(1,"天"),
        month(2,"月"),
        ;
        private int unit;
        private String desc;

        Unit() {
        }

        Unit(int unit, String desc) {

            this.unit = unit;
            this.desc = desc;
        }

        public int getUnit() {

            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static Unit getUnitByUint(int unit){
            for(Unit u : values()){
                if(u.getUnit() == unit)
                    return u;
            }
            return null;
        }
    }

    /**
     * 产品类型
     */
    public enum ProductType{
        dxRaise(1,"定向融资"),
        syTrans(2,"收益权转让"),
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

        ProductType() {
        }

        ProductType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static ProductType getProductType(int type){
            for(ProductType pt : values()){
                if(pt.getType() == type)
                    return pt;
            }
            return null;
        }
    }

    /**
     * 认购类型
     */
    public enum BuyType{
        online(1,"线上"),
        offline(2,"线下"),
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

        BuyType() {
        }

        BuyType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static BuyType getBuyTypeByType(int type){
            for(BuyType u : values()){
                if(u.getType() == type)
                    return u;
            }
            return null;
        }
    }

    /**
     * 存续期计算方式
     */
    public enum HoldCalType{
        fix(1,"固定"),
        decrement(2,"递减"),
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

        HoldCalType() {
        }

        HoldCalType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static HoldCalType getHoldCalTypeByType(int type){
            for(HoldCalType u : values()){
                if(u.getType() == type)
                    return u;
            }
            return null;
        }
    }



    /**
     * 成立方式
     */
    public enum EstablishType{
        hand(1,"手动成立"),
        auto(2,"自动成立"),
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

        EstablishType() {
        }

        EstablishType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static EstablishType getEstablishTypeByType(int type){
            for(EstablishType u : values()){
                if(u.getType() == type)
                    return u;
            }
            return null;
        }
    }


    /**
     * 结算方式(1-本息一次,2-按月付息,3-按季付息,4-半年付息,5-按年付息)
     */
    public enum SettlementType{
        once(1,"本息一次"),
        month(2,"按月付息"),
        season(3,"按季付息"),
        halfYear(4,"按半年付息"),
        year(5,"按年付息"),
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

        SettlementType() {
        }

        SettlementType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static SettlementType getSettlementTypeByType(int type){
            for(SettlementType u : values()){
                if(u.getType() == type)
                    return u;
            }
            return null;
        }
    }

    /**
     * 收费方式(1-前置,2-扣收,3-月结)
     */
    public enum FeeType{
        qz(1,"前置"),
        ks(2,"扣收"),
        yj(3,"月结"),
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

        FeeType() {
        }

        FeeType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static FeeType getFeeTypeByType(int type){
            for(FeeType u : values()){
                if(u.getType() == type)
                    return u;
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getUnderwriterId() {
        return underwriterId;
    }

    public void setUnderwriterId(int underwriterId) {
        this.underwriterId = underwriterId;
    }

    public int getDanbaoId() {
        return danbaoId;
    }

    public void setDanbaoId(int danbaoId) {
        this.danbaoId = danbaoId;
    }

    public int getEntrustedId() {
        return entrustedId;
    }

    public void setEntrustedId(int entrustedId) {
        this.entrustedId = entrustedId;
    }

    public BigDecimal getRaiseAmount() {
        return raiseAmount;
    }

    public void setRaiseAmount(BigDecimal raiseAmount) {
        this.raiseAmount = raiseAmount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(int termUnit) {
        this.termUnit = termUnit;
    }

    public BigDecimal getExpectRate() {
        return expectRate;
    }

    public void setExpectRate(BigDecimal expectRate) {
        this.expectRate = expectRate;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(BigDecimal increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    public int getBuyType() {
        return buyType;
    }

    public void setBuyType(int buyType) {
        this.buyType = buyType;
    }

    public int getHoldCalType() {
        return holdCalType;
    }

    public void setHoldCalType(int holdCalType) {
        this.holdCalType = holdCalType;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isTrans() {
        return trans;
    }

    public void setTrans(boolean trans) {
        this.trans = trans;
    }

    public int getLockTerm() {
        return lockTerm;
    }

    public void setLockTerm(int lockTerm) {
        this.lockTerm = lockTerm;
    }

    public int getLockUnit() {
        return lockUnit;
    }

    public void setLockUnit(int lockUnit) {
        this.lockUnit = lockUnit;
    }

    public BigDecimal getMinEstablishAmount() {
        return minEstablishAmount;
    }

    public void setMinEstablishAmount(BigDecimal minEstablishAmount) {
        this.minEstablishAmount = minEstablishAmount;
    }

    public int getEstablishType() {
        return establishType;
    }

    public void setEstablishType(int establishType) {
        this.establishType = establishType;
    }

    public String getEstablishDay() {
        return establishDay;
    }

    public void setEstablishDay(String establishDay) {
        this.establishDay = establishDay;
    }

    public int getYearCalType() {
        return yearCalType;
    }

    public void setYearCalType(int yearCalType) {
        this.yearCalType = yearCalType;
    }

    public int getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(int settlementType) {
        this.settlementType = settlementType;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public int getFixedMonth() {
        return fixedMonth;
    }

    public void setFixedMonth(int fixedMonth) {
        this.fixedMonth = fixedMonth;
    }

    public int getFixedDay() {
        return fixedDay;
    }

    public void setFixedDay(int fixedDay) {
        this.fixedDay = fixedDay;
    }

    public boolean isHasHang() {
        return hasHang;
    }

    public void setHasHang(boolean hasHang) {
        this.hasHang = hasHang;
    }

    public BigDecimal getHangMinFee() {
        return hangMinFee;
    }

    public void setHangMinFee(BigDecimal hangMinFee) {
        this.hangMinFee = hangMinFee;
    }

    public BigDecimal getHangRate() {
        return hangRate;
    }

    public void setHangRate(BigDecimal hangRate) {
        this.hangRate = hangRate;
    }

    public int getHangFeeType() {
        return hangFeeType;
    }

    public void setHangFeeType(int hangFeeType) {
        this.hangFeeType = hangFeeType;
    }

    public boolean isHasCx() {
        return hasCx;
    }

    public void setHasCx(boolean hasCx) {
        this.hasCx = hasCx;
    }

    public BigDecimal getCxMinFee() {
        return cxMinFee;
    }

    public void setCxMinFee(BigDecimal cxMinFee) {
        this.cxMinFee = cxMinFee;
    }

    public BigDecimal getCxRate() {
        return cxRate;
    }

    public void setCxRate(BigDecimal cxRate) {
        this.cxRate = cxRate;
    }

    public int getCxFeeType() {
        return cxFeeType;
    }

    public void setCxFeeType(int cxFeeType) {
        this.cxFeeType = cxFeeType;
    }

    public boolean isHasSt() {
        return hasSt;
    }

    public void setHasSt(boolean hasSt) {
        this.hasSt = hasSt;
    }

    public BigDecimal getStMinFee() {
        return stMinFee;
    }

    public void setStMinFee(BigDecimal stMinFee) {
        this.stMinFee = stMinFee;
    }

    public BigDecimal getStRate() {
        return stRate;
    }

    public void setStRate(BigDecimal stRate) {
        this.stRate = stRate;
    }

    public int getStFeeType() {
        return stFeeType;
    }

    public void setStFeeType(int stFeeType) {
        this.stFeeType = stFeeType;
    }

    public String getAmountUse() {
        return amountUse;
    }

    public void setAmountUse(String amountUse) {
        this.amountUse = amountUse;
    }

    public String getIncreaseCredit() {
        return increaseCredit;
    }

    public void setIncreaseCredit(String increaseCredit) {
        this.increaseCredit = increaseCredit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getHangYjDay() {
        return hangYjDay;
    }

    public void setHangYjDay(int hangYjDay) {
        this.hangYjDay = hangYjDay;
    }

    public int getCxYjDay() {
        return cxYjDay;
    }

    public void setCxYjDay(int cxYjDay) {
        this.cxYjDay = cxYjDay;
    }

    public int getStYjDay() {
        return stYjDay;
    }

    public void setStYjDay(int stYjDay) {
        this.stYjDay = stYjDay;
    }
}
