package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.SysRole;

import java.util.List;
import java.util.Map;

public interface ISysRoleService {

    int queryDepartmentCount(Map<String, Object> paramMap);

    List<SysRole> queryDepartmentList(Map<String, Object> paramMap);

    SysRole getSysRoleByRoleNameAndDepartment(String roleName, String department);

    void updateSysRole(SysRole sysRole, String oldRoleName);

    void addSysRole(SysRole sysRole);

    SysRole getSysRoleById(int sysRoleId);

    List<SysRole> getSysRoleByDepartment(String department);

    void setSysUserId(int sysUserId);

	SysRole getSysRoleByRoleName(SysRole role);

	List<Map<String, Object>> getAllRoles();
}
