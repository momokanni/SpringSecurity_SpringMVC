package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysUser;

public interface AccountMapper {

	@SelectProvider(type = AccountProvider.class,method = "getTotalSysUserCountByParams")
	int getTotalSysUserCountByParams(Map queryMap);

	@SelectProvider(type = AccountProvider.class,method = "getSysUserByParams")
	List<SysUser> getSysUserByParams(Map queryMap);

	@Select("select roleName from sys_role where id = #{roleId}")
	String getSysUserRoleNameByRoleId(int roleId);

	@Select("select * from sys_user where id = #{id}")
	SysUser getAccountById(int id);

	@Update("update sys_user set status = #{status} where id = #{id}")
	boolean setAccountStatus(SysUser sysUser);

	@Select("select * from sys_role where status = 1")
	List<SysRole> getSysRole();

	@Insert("insert into sys_user "
			+ "					("
			+ "					name,mobile,loginName,createTime,status,roleId,passwd,lockStatus,enabled,authorities"
			+ "					)" +
			" 			values"
			+ "					("
			+ "					#{name},#{mobile},#{loginName},#{createTime},#{status},#{roleId},#{passwd},#{lockStatus},#{enabled},#{authorities}"
			+ "					)")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void addAccount(SysUser sysUser);

	@Update("update sys_user set name = #{name}, "
			+ "						 mobile = #{mobile}, "
			+ "						 loginName = #{loginName}, "
			+ "						 roleId = #{roleId},"
			+"						 authorities = #{authorities},"
			+ "						 updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void updateAccount(SysUser sysUser);

	@Select("select count(1) from article_img where  DATEDIFF(releaseTime,now())=-1")
	int getArticleCountYesterday();

	@Select("select count(1) from article_img")
	int getArticleCount();

	@Select("select count(1) from sys_user where  DATEDIFF(createTime,now())=-1")
	int getAccountCountYesterday();

	@Select("select count(1) from sys_user")
	int getAccountCount();

	@Select("select * from sys_user where loginName = #{loginName}")
    SysUser getAccountByloginName(String loginName);

	@Select("select * from sys_user where mobile = #{mobile}")
	SysUser getAccountBymobile(String mobile);
}
