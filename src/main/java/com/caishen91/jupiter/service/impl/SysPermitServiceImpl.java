package com.caishen91.jupiter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.SysPermitMapper;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.service.ISysPermitService;

@Service
public class SysPermitServiceImpl extends BaseService implements ISysPermitService {

    @Override
    public List<SysPermit> getParentSysPermit() {
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        return sysPermitMapper.getParentSysPermit();
    }

    @Override
    public List<SysPermit> getSysPermitByParentId(int parentId) {
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        return sysPermitMapper.getSysPermitByParentId(parentId);
    }

    @Override
    public List<SysPermit> getSysPermitByIds(List<Integer> sysPermitIds) {
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("sysPermitIds", sysPermitIds);
        return sysPermitMapper.getSysPermitByIds(paramMap);
    }

    @Override
    public SysPermit getSysPermitById(int sysPermitId) {
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        return sysPermitMapper.getSysPermitById(sysPermitId);
    }

	@Override
	public SysPermit getSysPermitByUrl(String url) {
		SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        return sysPermitMapper.getSysPermitByUrl(url);
	}

	@Override
	public String getAuthByRoleId(int roleId) {
		SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        return sysPermitMapper.getAuthByRoleId(roleId);
	}

	@Override
	public List<Map<String, Object>> getSysPermits() {
		SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
		return sysPermitMapper.getSysPermits();
	}
}
