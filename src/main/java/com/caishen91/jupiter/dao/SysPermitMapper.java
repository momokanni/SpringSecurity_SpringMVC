package com.caishen91.jupiter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.caishen91.jupiter.model.SysPermit;

public interface SysPermitMapper {

    @Select("select * from sys_permit where parentId = 0 and defaultPermit = 1")
    List<SysPermit> getParentSysPermit();

    @Select("select * from sys_permit where parentId = #{parentId} and defaultPermit = 1 order by displayseq")
    List<SysPermit> getSysPermitByParentId(@Param("parentId") int parentId);

    @SelectProvider(type = SysPermitProvider.class, method = "getSysPermitByIds")
    List<SysPermit> getSysPermitByIds(HashMap<String, Object> paramMap);

    @Select("select * from sys_permit where id = #{sysPermitId}")
    SysPermit getSysPermitById(@Param("sysPermitId") int sysPermitId);

    @Select("select * from sys_permit where action = #{url}")
	SysPermit getSysPermitByUrl(@Param("url") String url);

    @Select("SELECT CONCAT('ROLE_',sr.`auth`) FROM sys_role sr WHERE sr.`id` = #{roleId} ")
    String getAuthByRoleId(@Param("roleId") int roleId);

    @Select("SELECT CONCAT('ROLE_',sp.`authCode`) FROM sysRolePermit srp LEFT JOIN sys_permit sp ON sp.`id` = srp.`refId` WHERE srp.`roleId` = #{roleId} ")
	Set<String> getPermissionByRoleId(@Param("roleId") int roleId);

	@Select("SELECT p.id,p.modleName,srp.roleId,p.parentId,p.defaultPermit FROM sys_permit p LEFT JOIN sysRolePermit srp ON srp.`refId` = p.`id`")
    List<Map<String,Object>> getSysPermits();
}
