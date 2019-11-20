package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {

    @SelectProvider(type = SysRoleProvider.class, method = "queryDepartmentCount")
    int queryDepartmentCount(Map<String, Object> paramMap);

    @SelectProvider(type = SysRoleProvider.class, method = "queryDepartmentList")
    List<SysRole> queryDepartmentList(Map<String, Object> paramMap);

    @Select("select * from sys_role where roleName = #{roleName} and department = #{department} limit 1")
    SysRole getSysRoleByRoleNameAndDepartment(@Param("roleName") String roleName, @Param("department") String department);

    @Insert("insert into sys_role(roleName, createTime, updateTime, `status`) values(#{roleName}, #{createTime}, #{updateTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addSysRole(SysRole sysRole);

    @Update("update sys_role set roleName = #{roleName}, modifyTime = #{modifyTime} where id = #{id}")
    void updateSysRole(SysRole sysRole);

    @Select("select * from sys_role where id = #{sysRoleId}")
    SysRole getSysRoleById(@Param("sysRoleId") int sysRoleId);

    @Select("select * from sys_role where department = #{department}")
    List<SysRole> getSysRoleByDepartment(@Param("department") String department);

    @Select("select * from sys_role where roleName = #{roleName}")
	SysRole getSysRoleByRoleName(SysRole sysRole);

    @Select("select id,roleName as 'name' from sys_role")
	List<Map<String, Object>> getAllRoles();
}
