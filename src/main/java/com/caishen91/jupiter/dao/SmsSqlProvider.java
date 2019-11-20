package com.caishen91.jupiter.dao;

import java.util.Map;

public class SmsSqlProvider {

	
	public String getLastSmsCheckCode(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from reg_sms_check where mobile = #{mobile} and cookie = #{cookie} ");
		int ref = (Integer)params.get("ref");
		if (ref != 0) {
			sb.append(" and ref = #{ref} ");
		}
		sb.append(" and checkTime is null" );
		sb.append(" order by sendTime desc  limit 1");
		return sb.toString();
	}
	
	
}
