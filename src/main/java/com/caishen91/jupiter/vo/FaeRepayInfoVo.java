package com.caishen91.jupiter.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/22/19 14 23
 * Description:
 */
public class FaeRepayInfoVo {

    private int id;

    private int repayPhase;

    private int establishPhase;

    private Date repayDate;

    private BigDecimal repayPrincipal;

    private BigDecimal repayInterest;

    private int repayStatus;

    private String productName;

    private String issueName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRepayPhase() {
        return repayPhase;
    }

    public void setRepayPhase(int repayPhase) {
        this.repayPhase = repayPhase;
    }

    public int getEstablishPhase() {
        return establishPhase;
    }

    public void setEstablishPhase(int establishPhase) {
        this.establishPhase = establishPhase;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
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
}
