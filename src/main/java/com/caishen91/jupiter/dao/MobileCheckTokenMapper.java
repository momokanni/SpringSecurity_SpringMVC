package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.MobileCheckToken;
import org.apache.ibatis.annotations.*;

public interface MobileCheckTokenMapper
{
	@Insert(" insert into mobile_check_token(userId, tokenType, sendTime, ip, cookie, mobile, availableTime, token, source, mode, idCardNo) values(#{userId}, #{tokenType}, #{sendTime}, #{ip}, #{cookie}, #{mobile}, #{availableTime}, #{token}, #{source}, #{mode}, #{idCardNo})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addMobileCheckToken(MobileCheckToken mct);
	
	
	@Select("select * from mobile_check_token where token = #{token}")
	public MobileCheckToken getMobileCheckTokenByToken(@Param("token") String token);
	
	@Update("update mobile_check_token set checkTime=#{checkTime} where id = #{id}")
	public int checkToken(MobileCheckToken mct);
	
}
