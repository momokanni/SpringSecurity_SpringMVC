package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.SysRoleMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.service.ISysOperateLogService;
import com.caishen91.jupiter.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl extends BaseService implements ISysRoleService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public int queryDepartmentCount(Map<String, Object> paramMap) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.queryDepartmentCount(paramMap);
    }

    @Override
    public List<SysRole> queryDepartmentList(Map<String, Object> paramMap) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.queryDepartmentList(paramMap);
    }

    @Override
    public SysRole getSysRoleByRoleNameAndDepartment(String roleName, String department) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.getSysRoleByRoleNameAndDepartment(roleName, department);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addSysRole(SysRole sysRole) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        sysRoleMapper.addSysRole(sysRole);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addSysRoleLog(sysUserId, sysRole));
    }

    @Override
    public void updateSysRole(SysRole sysRole, String oldRoleName) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        sysRoleMapper.updateSysRole(sysRole);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.updateSysRoleLog(sysUserId, sysRole, oldRoleName));
    }

    @Override
    public SysRole getSysRoleById(int sysRoleId) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.getSysRoleById(sysRoleId);
    }

    @Override
    public List<SysRole> getSysRoleByDepartment(String department) {
        SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.getSysRoleByDepartment(department);
    }

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

	@Override
	public SysRole getSysRoleByRoleName(SysRole role) {
		SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.getSysRoleByRoleName(role);
	}

	@Override
	public List<Map<String, Object>> getAllRoles() {
		SysRoleMapper sysRoleMapper = writableSQLSession.getMapper(SysRoleMapper.class);
        return sysRoleMapper.getAllRoles();
	}
}
