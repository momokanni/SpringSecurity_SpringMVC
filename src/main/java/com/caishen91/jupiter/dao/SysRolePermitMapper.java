package com.caishen91.jupiter.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caishen91.jupiter.model.SysRolePermit;
import com.caishen91.jupiter.model.SysUserPermit;

public interface SysRolePermitMapper {

    @Select("select * from sysRolePermit where roleId = #{sysRoleId}")
	List<SysRolePermit> getSysRolePermitBySysRoleId(@Param("sysRoleId")int roleId);

    @Select("delete from sysRolePermit where roleId = #{sysRoleId}")
	void revocationSysRoleAuthAll(@Param("sysRoleId")int sysRoleIdStr);

    @InsertProvider(type = SysRolePermitProvider.class , method = "updateRoleAuth")
	void updateRoleAuth(@Param("list")List<SysRolePermit> rpList);

    @Select("select refId from sysRolePermit where roleId = #{roleId} and permit = 1")
	List<Integer> getSysRolePermitByUserIdAndRoleId(@Param("roleId") int roleId);

    @Select("SELECT DISTINCT sr.`auth` FROM sys_role sr LEFT JOIN sysRolePermit srp ON srp.`roleId` = sr.`id` WHERE srp.`refId` = #{refId} AND srp.`permit` = 1")
	List<String> getMetadataSourceByRefId(@Param("refId") int refId);

    @Select("select refId from sysRolePermit where roleId = #{roleId} and permit = 1")
	List<SysUserPermit> getRefIdByRoleId(@Param("roleId") int roleId);

    @Select("SELECT DISTINCT sr.`auth` FROM sys_role sr LEFT JOIN sysUserPermit sup ON sup.`roleId` = sr.`id` WHERE sup.`refId` = #{refId} AND sup.userId = #{userId} AND sup.`permit` = 1")
	List<String> getMetadataSourceByRefIdAndSysUserId(@Param("userId") int userId, @Param("refId") int refId);
}
