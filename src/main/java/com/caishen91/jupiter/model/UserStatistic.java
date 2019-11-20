package com.caishen91.jupiter.model;

import java.math.BigDecimal;

public class UserStatistic {

	
	private int userId;
	
	private BigDecimal totalStockRoyalty;
	
	private BigDecimal totalIncrementalRoyalty;
	
	private BigDecimal totalRoyalty;
	
	private BigDecimal totalInvestAmount;
	
	private BigDecimal totalRoyaltied;
	
	private BigDecimal totalRoyaltyInvestAmount;
	
	public BigDecimal getTotalInvestAmount() {
		return totalInvestAmount;
	}

	public void setTotalInvestAmount(BigDecimal totalInvestAmount) {
		this.totalInvestAmount = totalInvestAmount;
	}

	public BigDecimal getTotalRoyaltied() {
		return totalRoyaltied;
	}

	public void setTotalRoyaltied(BigDecimal totalRoyaltied) {
		this.totalRoyaltied = totalRoyaltied;
	}

	public BigDecimal getTotalRoyaltyInvestAmount() {
		return totalRoyaltyInvestAmount;
	}

	public void setTotalRoyaltyInvestAmount(BigDecimal totalRoyaltyInvestAmount) {
		this.totalRoyaltyInvestAmount = totalRoyaltyInvestAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getTotalStockRoyalty() {
		return totalStockRoyalty;
	}

	public void setTotalStockRoyalty(BigDecimal totalStockRoyalty) {
		this.totalStockRoyalty = totalStockRoyalty;
	}

	public BigDecimal getTotalIncrementalRoyalty() {
		return totalIncrementalRoyalty;
	}

	public void setTotalIncrementalRoyalty(BigDecimal totalIncrementalRoyalty) {
		this.totalIncrementalRoyalty = totalIncrementalRoyalty;
	}

	public BigDecimal getTotalRoyalty() {
		return totalRoyalty;
	}

	public void setTotalRoyalty(BigDecimal totalRoyalty) {
		this.totalRoyalty = totalRoyalty;
	}
	
	
}
