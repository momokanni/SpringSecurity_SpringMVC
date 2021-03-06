package com.caishen91.jupiter.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;

import com.caishen91.jupiter.model.SysRolePermit;

public interface ISysRolePermitService {

	List<SysRolePermit> getSysRolePermitByRoleId(int roleId);

	void updateSysRoleAuth(int roleId, String[] sysPermitIds);

	List<Integer> getSysRolePermitByUserIdAndRoleId(int roleId);

	Collection<ConfigAttribute> getMetadataSourceByRefId(int id);

	Collection<ConfigAttribute> getMetadataSourceByRefIdAndSysUserId(String sysUserId,int refId);
}
