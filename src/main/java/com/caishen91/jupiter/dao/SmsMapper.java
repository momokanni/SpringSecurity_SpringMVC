package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.RegSmsCheck;
import com.caishen91.jupiter.model.SmsTrace;
import com.caishen91.jupiter.model.SmsTraceDetail;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface SmsMapper
{
	@Insert(" insert into reg_sms_check(channel,mobile, code, ip, cookie, sendTime, lastSendTime, ref) values(#{channel},#{mobile}, #{code}, #{ip}, #{cookie}, #{sendTime}, #{lastSendTime}, #{ref})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addRegSmsCheck(RegSmsCheck rsc);
	
	@Select("select * from reg_sms_check")
	public RegSmsCheck getRegSmsCheckById(@Param("id") int id);
	
	@Select("select count(1) from reg_sms_check where ip = #{ip} and date_format(sendTime,'%Y%m%d') = date_format(#{date},'%Y%m%d')")
	public int getTodaySmsCheckCodeCountByIp(@Param("ip") String ip, @Param("date") Date date);
	
	@Select("select * from reg_sms_check where ip = #{ip} and cookie = #{cookie} and checkTime is null order by sendTime desc limit 1")
	public RegSmsCheck getLastSmsCheckCodeByIpCookie(@Param("ip") String ip, @Param("cookie") String cookie);
	
	
	@SelectProvider(type = SmsSqlProvider.class, method = "getLastSmsCheckCode")
	public RegSmsCheck getLastSmsCheckCode(@Param("ip") String ip, @Param("cookie") String cookie, @Param("mobile") String mobile, @Param("ref") int ref);
	
	/**
	 * 
	* @描述：通道是否通过
	* @开发时间： 2014-9-25 下午4:01:10
	 */
	@Select("select * from reg_sms_check  where mobile = #{mobile} and ip = #{ip} and cookie = #{cookie}   and ref = #{ref} order by sendTime desc  limit 1")
	public RegSmsCheck getLastSmsCheckCodePass(@Param("ip") String ip, @Param("cookie") String cookie, @Param("mobile") String mobile, @Param("ref") int ref);
	/**
	 * 
	* @描述：修改短信检查渠道
	* @开发时间： 2014-9-25 下午4:43:45
	 */
	@Update("update reg_sms_check set channel=#{channel} where id=#{id}")
	public void updateSmsCheckCodeChannel(RegSmsCheck check);
	
	@Update("update reg_sms_check set lastSendTime=#{lastSendTime},checkTime=#{checkTime},channel=#{channel} where id = #{id}")
	public int resendRegSmsCheck(RegSmsCheck rsc);
	
	@Update("update reg_sms_check set checkTime=#{checkTime} where id = #{id}")
	public int checkRegSmsCheck(RegSmsCheck rsc);
	
	/**
	 * 
	* @描述：添加短信通道,及短信模板
	* @开发时间： 2014-9-25 下午4:20:51
	 */
	@Insert(" insert into sms_trace (mobile, content, createTime, status, smsType,channel) values (#{mobile}, #{content}, #{createTime}, #{status}, #{smsType},#{channel})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addSmsTrace(SmsTrace st);
	
	@Select("select * from sms_trace where id = #{id}")
	public SmsTrace getSmsTraceById(@Param("id") int id);
	
	@Update("update sms_trace set seq = #{seq}, status = #{status}, ret = #{ret}, sendTime=#{sendTime}, lastTryTime=#{lastTryTime}, tryTimes=tryTimes + 1, channel = #{channel} where id = #{id}")
	public int sendSms(SmsTrace trace);
	
	@Update("update sms_trace set   channel = #{channel} where id = #{id}")
	public int sendSmsNew(SmsTrace trace);
	
	/**
	 * 
	* @描述：添加短信模板
	* @开发时间： 2014-9-25 下午5:36:41
	 */
	@Insert("insert into sms_trace_detail (traceId,tryTime,mobile,content,ret,succ,channel,seq)" +
			" values (#{traceId},#{tryTime},#{mobile},#{content},#{ret},#{succ},#{channel}, #{seq})")
	public int addSmsTraceDetail(SmsTraceDetail trace);
	
	@Select("select * from sms_trace where createTime >= #{datestr} and smsType = 1 and (status = 0 or ( status = 2 and tryTimes < 3)) limit 1000")
	public List<SmsTrace> getUnsendSms(Date datestr);
	
	
	

	/**
	 * 按手机号验证移动手机号是否报备
	 * @param mobile
	 * @return
	 */
	@Select("SELECT COUNT(1) from cm_mobile_bao where mobile=#{mobile}  and status=1")
	public int getCmMobileBaoByMobileCount(@Param("mobile") String mobile);
	
	
	
	
}
