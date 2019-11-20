package com.caishen91.jupiter.util;

import com.caishen91.jupiter.constsant.Consts;

import java.math.BigDecimal;

public class DecimalUtil {

	public final static BigDecimal Minus1 = new BigDecimal("-1");

	public final static BigDecimal TenThousand = new BigDecimal("10000");

	public final static BigDecimal OneHundred = new BigDecimal("100");


	public static BigDecimal getMoneyWan(BigDecimal amount) {
		if (amount == null) {
			return BigDecimal.ZERO;
		}

		BigDecimal ret = amount.divide(Consts.wan, 2, BigDecimal.ROUND_HALF_EVEN);
		return ret;

	}
	
	public static BigDecimal getHouseEstimateAmount(BigDecimal evaWebsiteAmount, BigDecimal evaCompanyAmount, BigDecimal evaMarketAmount) {
		
		int noZeroCount = 0;
		if (evaWebsiteAmount.doubleValue() > 0) {
			noZeroCount++;
		}
		
		if (evaCompanyAmount.doubleValue() > 0) {
			noZeroCount++;
		}
		
		if (evaMarketAmount.doubleValue() > 0) {
			noZeroCount++;
		}
		
		if (noZeroCount == 0) {
			return BigDecimal.ZERO;
		}
		
		BigDecimal ret = evaWebsiteAmount.add(evaCompanyAmount)
										 .add(evaMarketAmount)
										 .setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		ret = ret.divide(new BigDecimal(noZeroCount), 2, BigDecimal.ROUND_HALF_EVEN);
		
		return ret;
	}

}
