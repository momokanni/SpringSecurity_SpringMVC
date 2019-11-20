package com.caishen91.jupiter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import com.caishen91.jupiter.dao.SysRolePermitMapper;
import com.caishen91.jupiter.model.SysRolePermit;
import com.caishen91.jupiter.service.ISysRolePermitService;
import com.caishen91.jupiter.util.IDEncryptor;

@Service
public class SysRolePermitServiceImpl extends BaseService implements ISysRolePermitService{

	@Override
	public List<SysRolePermit> getSysRolePermitByRoleId(int roleId) {
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
        return sysRolePermitMapper.getSysRolePermitBySysRoleId(roleId);
	}

	@Override
	public void updateSysRoleAuth(int roleId, String[] sysPermitIds) {
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
        sysRolePermitMapper.revocationSysRoleAuthAll(roleId);
        List<SysRolePermit> rpList = null;
        if (null != sysPermitIds && sysPermitIds.length > 0) {
        	rpList = new ArrayList<SysRolePermit>();
            for (String spId : sysPermitIds) {
                SysRolePermit sysRolePermit = new SysRolePermit();
                sysRolePermit.setRoleId(roleId);
                sysRolePermit.setRefId(Integer.parseInt(spId));
                sysRolePermit.setPermit(true);
                sysRolePermit.setCreateTime(new Date());
                sysRolePermit.setUpdateTime(new Date());
                rpList.add(sysRolePermit);
            }
        }
        sysRolePermitMapper.updateRoleAuth(rpList);
	}

	@Override
	public List<Integer> getSysRolePermitByUserIdAndRoleId(int roleId) {
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
        return sysRolePermitMapper.getSysRolePermitByUserIdAndRoleId(roleId);
	}

	@Override
	public Collection<ConfigAttribute> getMetadataSourceByRefId(int refId) {
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		List<String> roleList = sysRolePermitMapper.getMetadataSourceByRefId(refId);
		if(roleList != null && roleList.size() > 0) {
			for (String auth : roleList) {
				ConfigAttribute configAttribute = new SecurityConfig(auth);
				configAttributes.add(configAttribute);
			}
		}
		return configAttributes;
	}

	@Override
	public Collection<ConfigAttribute> getMetadataSourceByRefIdAndSysUserId(String sysUserId,int refId) {
		SysRolePermitMapper sysRolePermitMapper = writableSQLSession.getMapper(SysRolePermitMapper.class);
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		int userId = IDEncryptor.getInstance().decryptWithoutException(sysUserId);
		List<String> roleList = sysRolePermitMapper.getMetadataSourceByRefIdAndSysUserId(userId, refId);
		if(roleList != null && roleList.size() > 0) {
			for (String auth : roleList) {
				ConfigAttribute configAttribute = new SecurityConfig(auth);
				configAttributes.add(configAttribute);
			}
		}
		return configAttributes;
	}
}
