package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.MobileAvailable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface MobileAvailableMapper
{
	@Insert(" insert into mobile_available(mobile,  ip, cookie, checkTime) values(#{mobile}, #{ip}, #{cookie}, #{checkTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addMobileAvailable(MobileAvailable ma);
	
	
	@Select("select count(1) from mobile_available where ip = #{ip} and date_format(checkTime,'%Y%m%d') = date_format(#{date},'%Y%m%d')")
	public int getTodayMobileAvailableCountByIp(@Param("ip") String ip, @Param("date") Date date);
	
	@Select("select count(1) from mobile_available where ip = #{ip} and cookie = #{cookie} and date_format(checkTime,'%Y%m%d') = date_format(#{date},'%Y%m%d')")
	public int getTodayMobileAvailableCountByMachine(@Param("ip") String ip, @Param("cookie") String cookie, @Param("date") Date date);
	
	@Select("select count(1) from offline_bank_send_log where userId = #{userId} and date_format(checkTime,'%Y%m%d') = date_format(#{date},'%Y%m%d')")
	public int getTodayOfflineBankSendCountByUserId(@Param("userId") int userId, @Param("date") Date date);
}
