package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.model.SysPermit;

public interface ISysPermitService {

    List<SysPermit> getParentSysPermit();

    List<SysPermit> getSysPermitByParentId(int parentId);

    List<SysPermit> getSysPermitByIds(List<Integer> sysPermitIds);

    SysPermit getSysPermitById(int sysPermitId);

	SysPermit getSysPermitByUrl(String url);

	String getAuthByRoleId(int roleId);

	List<Map<String, Object>> getSysPermits();
}
