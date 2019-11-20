package com.caishen91.jupiter.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caishen91.jupiter.model.SysUser;

public interface AdministratorDetailsMapper {

	@Select("select * from sys_user where loginName = #{loginName}")
	SysUser loadAdminDetailsById(@Param(value = "loginName")String loginName);

}
