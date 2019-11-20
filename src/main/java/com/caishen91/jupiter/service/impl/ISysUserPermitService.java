package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.SysUserPermit;

import java.util.List;

public interface ISysUserPermitService {

    List<SysUserPermit> getSysUserPermitBySysUserId(int sysUserId);

    void updateSysUserAuth(int sysUserId, String[] sysPermitIds);

    void setSysUserId(int sysUserId);

	void update(SysUser sysUser);
}
