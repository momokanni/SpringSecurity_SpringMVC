package com.caishen91.jupiter.enums;

import java.math.BigDecimal;

public enum RepayParams {

	day5(1, 5, new BigDecimal("0.5")),
	day10(6, 10, new BigDecimal("0.7"));
	
	private int startDay;
	
	private int endDay;
	
	private BigDecimal ratio;

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	
	private RepayParams(int startDay, int endDay, BigDecimal ratio) {
		this.startDay = startDay;
		this.endDay = endDay;
		this.ratio = ratio;
	}
	
	public static BigDecimal getRatioByDay(int day) {
		for(RepayParams rp : RepayParams.values()) {
			if (rp.getStartDay() <= day && rp.getEndDay() >= day) {
				return rp.getRatio();
			}
		}
		return null;
	}
}
