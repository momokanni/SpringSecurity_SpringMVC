package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.SysMapper;
import com.caishen91.jupiter.dao.SysPermitMapper;
import com.caishen91.jupiter.dao.SysRolePermitMapper;
import com.caishen91.jupiter.dao.SysUserPermitMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserPermitServiceImpl extends BaseService implements ISysUserPermitService{

    private int sysUserId;

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    @Override
    public List<SysUserPermit> getSysUserPermitBySysUserId(int sysUserId) {
        SysUserPermitMapper sysUserPermitMapper = writableSQLSession.getMapper(SysUserPermitMapper.class);
        return sysUserPermitMapper.getSysUserPermitBySysUserId(sysUserId);
    }

    @Override
    public void updateSysUserAuth(int sysUserId, String[] sysPermitIds) {
        SysUserPermitMapper sysUserPermitMapper = writableSQLSession.getMapper(SysUserPermitMapper.class);
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysUserPermitMapper.revocationSysUserAuthAll(sysUserId);

        if (null != sysPermitIds && sysPermitIds.length > 0) {
            for (String spId : sysPermitIds) {
                SysUserPermit sysUserPermit = new SysUserPermit();
                sysUserPermit.setUserId(sysUserId);
                sysUserPermit.setRefId(Integer.parseInt(spId));
                sysUserPermit.setPermit(true);
                sysUserPermitMapper.allotSysUserAuth(sysUserPermit);
            }
        }

        SysUser sysUser = sysMapper.getUserById(sysUserId);
        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.allotAuthLog(sysUserId, sysUser));
    }

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

	@Override
	public void update(SysUser sysUser) {
		SysUserPermitMapper sysUserPermitMapper = writableSQLSession.getMapper(SysUserPermitMapper.class);
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
        sysUserPermitMapper.revocationSysUserAuthAll(sysUser.getId());
        
        // 组装sysUserPermit数据
        List<SysUserPermit> refs = sysRolePermitMapper.getRefIdByRoleId(sysUser.getRoleId());
        
        if (null != refs && refs.size() > 0) {
            for (SysUserPermit permit : refs) {
            	permit.setUserId(sysUser.getId());
            	permit.setRoleId(sysUser.getRoleId());
            	permit.setPermit(true);
            }
        }
        
        // 批量插入
        sysUserPermitMapper.insertBatch(refs);
	}
}
