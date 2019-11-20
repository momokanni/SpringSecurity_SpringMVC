package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.SysMapper;
import com.caishen91.jupiter.enums.PermitRoleTag;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.ISysOperateLogService;
import com.caishen91.jupiter.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SysUserServiceImpl extends BaseService implements ISysUserService {

	private static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public SysUser getUserByLoginNamePasswd(String loginName, String passwd) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUserByLoginNamePasswd(loginName, passwd);
    }

    @Override
    public SysUser getUserByMobilePasswd(String mobile, String passwd) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUserByMobilePasswd(mobile, passwd);
    }

    @Override
    public boolean chgPasswd(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.chgPasswd(sysUser);
        return true;
    }

    @Override
    public int getTotalDeptUsersByParam(Map queryMap) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getTotalDeptUsersByParam(queryMap);
    }

    @Override
    public List<SysUser> getDeptUsersByParam(Map queryMap) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getDeptUsersByParam(queryMap);
    }

    @Override
    public SysUser getUserById(int id) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUserById(id);
    }

    @Override
    public SysUser getUserByMobile(String mobile) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUserByMobile(mobile);
    }

    @Override
    public boolean addUser(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.addUser(sysUser);
        return true;
    }

    @Override
    public boolean updateUser(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.updateUser(sysUser);
        return true;
    }

    @Override
    public boolean setUserStatus(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.setUserStatus(sysUser);
        return true;
    }

    @Override
    public List<SysUser> getUsersByDeptIds(List<Integer> deptIds) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        if (deptIds == null || deptIds.size() == 0) {
            return new ArrayList();
        }
        return sysMapper.getUsersByDeptIds(deptIds);
    }

    @Override
    public List<SysUser> getUsersByIds(List<Integer> userIds) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        if (userIds == null || userIds.size() == 0) {
            return new ArrayList();
        }
        return sysMapper.getUsersByIds(userIds);
    }

    @Override
    public List<Integer> getDeptUserIdsLeaderByUser(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        Set<Integer> deptUserIds = new HashSet();
        deptUserIds.add(sysUser.getId());

        List<SysUser> sysUsers = sysMapper.getUsersByDeptId(sysUser.getDeptId());

        List<SysUser> us = new ArrayList();//每次循环的总用户
        for(SysUser u : sysUsers) {
            if (u.getId() == sysUser.getId()) {
                continue;
            }
            us.add(u);
        }
        int f = deptUserIds.size(); //进入循环前parentIds的数量
        boolean b = false;
        while (!b) {
            List<SysUser> lefts = new ArrayList(); //本次循环的剩余用户
            for(int i = 0; i < us.size(); i++) {
                SysUser u = us.get(i);
                if (deptUserIds.contains(u.getLeaderId())) {
                    deptUserIds.add(u.getId());
                } else {
                    lefts.add(u);
                }
            }

            int e = deptUserIds.size();
            us = lefts;
            if (e == f) {
                b = true;
                break;
            }
            f = e;
        }

        List<Integer> retList = new ArrayList(deptUserIds);
        return retList;
    }

    @Override
    public List<Integer> getUserIdsLeaderByUser(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);

        Set<Integer> deptUserIds = new HashSet();
        deptUserIds.add(sysUser.getId());

        List<SysUser> sysUsers = sysMapper.getUsers();

        List<SysUser> us = new ArrayList();//每次循环的总用户
        for(SysUser u : sysUsers) {
            if (u.getId() == sysUser.getId()) {
                continue;
            }
            us.add(u);
        }
        int f = deptUserIds.size(); //进入循环前parentIds的数量
        boolean b = false;
        while (!b) {
            List<SysUser> lefts = new ArrayList(); //本次循环的剩余用户
            for(int i = 0; i < us.size(); i++) {
                SysUser u = us.get(i);
                if (deptUserIds.contains(u.getLeaderId())) {
                    deptUserIds.add(u.getId());
                } else {
                    lefts.add(u);
                }
            }

            int e = deptUserIds.size();
            us = lefts;
            if (e == f) {
                b = true;
                break;
            }
            f = e;
        }

        List<Integer> retList = new ArrayList(deptUserIds);
        return retList;

    }

    @Override
    public List<SysUser> getAllUsers() {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUsersOrderByDept();
    }

    @Override
    public List<SysUser> getUserWithPermit(int permitId) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        List<SysUser> auditSysUsers = sysMapper.getUserWithPermit(permitId);
        return auditSysUsers;
    }

    @Override
    public List<SysUser> getUserWithPermitTag(String tag) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        SysPermit permit = sysMapper.getSysPermitByTag(tag);
        if (permit == null) {
            return new ArrayList();
        }

        return sysMapper.getUserWithPermit(permit.getId());
    }

    @Override
    public SysUser getNearestLeadersWithPermit(int userId, String permitTag) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        SysUser sysUser = sysMapper.getUserById(userId);

        if (sysUser.getLeaderId() == 0) {
            return null;
        }

        SysPermit permit = sysMapper.getSysPermitByTag(PermitRoleTag.businessAudit.getTag());
        List<SysUser> permitSysUsers = sysMapper.getUserWithPermit(permit.getId());

        Set<Integer> permitUserIds = new HashSet();
        if (permitSysUsers == null || permitSysUsers.size() > 0) {
            return null;
        }

        for(SysUser permitSysUser : permitSysUsers) {
            permitUserIds.add(permitSysUser.getId());
        }

        Set<Integer> selectedUserIds = new HashSet();
        selectedUserIds.add(userId);

        SysUser thisSysUser = sysUser;

        boolean find = false;

        while(thisSysUser.getLeaderId() > 0 && !find) {

            if (selectedUserIds.contains(thisSysUser.getLeaderId())) {
                break;
            }

            SysUser leader = sysMapper.getUserById(thisSysUser.getId());
            if (leader == null) {
                break;
            }

            if (permitUserIds.contains(leader.getId())) {
                find = true;
                return leader;
            }

            selectedUserIds.add(thisSysUser.getLeaderId());
            thisSysUser = leader;
        }

        return null;
    }






    /**
     * 按角色id获取菜单信息
     * @param roleId
     * @return
     */
    public List<SysPermit> getSysPermitByRole(int roleId){
    	SysMapper sysMapper=writableSQLSession.getMapper(SysMapper.class);
    	return sysMapper.getSysPermitByRole(roleId);
    }
    
    
    

    /**
     * 用户菜单操作
     * @param sysUser
     * @param sups
     */
    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateUserPermit(SysUser sysUser, List<SysUserPermit> sups){
		
		SysMapper sysMapper=writableSQLSession.getMapper(SysMapper.class);
		//删除菜单项信息
		sysMapper.deleteSysUserPermitByUserId(sysUser.getId());

		if(sups!=null&&sups.size()>0){
			sysMapper.addSysUserPermitList(sups);
		}
		return true;
    }
     
	

    /**
     * 按用户id及角色id获取菜单信息
     * @param uId
     * @param rId
     * @return
     */
    public List<SysUserPermit> getSysUserPermitByUserIdRoleId(int uId,int rId){
    	SysMapper sysMapper=writableSQLSession.getMapper(SysMapper.class);
    	return sysMapper.getSysUserPermitByUserIdRoleId(uId,rId);
    }

	@Override
	public boolean updateSuggestDzCount(int id, int countTotal) {
		SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		int a = sysMapper.updateSuggestDzCount(id, countTotal);
		if(a > 0){
			return true;
		}
		return false;
	}

	@Override
	public int getLcById(int id) {
		SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		return sysMapper.getLcById(id);
	}
	
	@Override
	public boolean updateHolidayRecord(int id, int status) {
		SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		int a = sysMapper.updateHolidayRecord(id, status);
		return a > 0;
	}

	@Override
	public List<Integer> getAllHolidayYear() {
		SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		return sysMapper.getAllHolidayYear();
	}

	@Override
	public int getCancelTransfeeOpBySysUsrId(int sysUserId) {
		SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
		return sysMapper.getCancelTransfeeOpBySysUsrId(sysUserId);
	}

	@Override
	public List<HashMap<String, Object>> getRoleIdValueInfo(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExsitSysAndUser(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateSuggestCommonStatus(int id, int status) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public PageVo<HashMap<String, Object>> sysUserList(
			PageVo<HashMap<String, Object>> pageVo, Map<String, Object> argsMap) {
		 
    	SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		int offset = pageVo.getCurrentPage() - 1;
		List<HashMap<String,Object>> danbaos=sysMapper.sysUserListByParam(
				offset*pageVo.getPageSize(),
				pageVo.getPageSize(),
				(String)argsMap.get("statuses"),
				(String)argsMap.get("loginName"),
				(String) argsMap.get("username"));
		
		pageVo.setVoList(danbaos);
		if (pageVo.getRecordCount() <= 0) {
			logger.debug("没有传来总记录数，去数据库查询");
			int recordCount = 0;
			recordCount = sysMapper.sysUserListCount(
					(String)argsMap.get("statuses"),
					(String)argsMap.get("loginName"),
					(String) argsMap.get("username"));
			pageVo.setRecordCount(recordCount);
			logger.debug("recordCount===" + recordCount);
		}		
		return pageVo; 
	}*/



	@Override
	public List<SysPermit> getBusinessRoles(int userId, int roleId) {
		SysMapper	sysMapper=writableSQLSession.getMapper(SysMapper.class);
		List<SysPermit> allPermits = sysMapper.getSysPermitByRole(roleId);
		List<SysUserPermit> userPermits = sysMapper.getSysUserPermitByUserIdRoleId(userId,roleId);
		
		Set<Integer> hasPermits = new HashSet();
		for(SysUserPermit sup : userPermits) {
			if (sup.isPermit()) {
				hasPermits.add(sup.getRefId());
			}
		}
		
		List<SysPermit> businessRoles = new ArrayList();
		for(SysPermit permit : allPermits) {
			if (!permit.isRoleKey()) {
				continue;
			}
			if (!hasPermits.contains(permit.getId())) {
				continue;
			}
			businessRoles.add(permit);
		}
		return businessRoles;
	}

	@Override
	public List<SysPermit> getUserPermitsByUserId(int userId) {
		SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
		return sysMapper.getUserPermitsByUserId(userId);
	}

	@Override
	public SysPermit getSysPermitByTag(String tag) {
		SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
		return sysMapper.getSysPermitByTag(tag);
	}

    @Override
    public int getSysUserCountBySysRoleId(int sysRoleId) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getSysUserCountBySysRoleId(sysRoleId);
    }

    @Override
    public SysUser getUserByIdAndPwd(int sysUserId, String oldPassword) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getUserByIdAndPwd(sysUserId, oldPassword);
    }

    @Override
    public SysUser getuserByLoginName(String loginName) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getuserByLoginName(loginName);
    }

    @Override
    public void addNewSysUser(SysUser sysUser) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.addNewSysUser(sysUser);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addSysUserLog(sysUserId, sysUser));
    }

    @Override
    public void updateSysUserStatus(int sysUserId, String status) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.updateSysUserStatus(sysUserId, status);;

        SysUser sysUser = sysMapper.getUserById(sysUserId);
        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.updateSysUserStatusLog(sysUserId, sysUser, status));
    }

    @Override
    public void resetSysUserPwd(int sysUserId, String password) {
        SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        sysMapper.resetSysUserPwd(sysUserId, password);

        SysUser sysUser = sysMapper.getUserById(sysUserId);
        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.resetSysUserPwd(sysUserId, sysUser));
    }

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

	@Override
	public SysUser getSysUserByRoleId(int role) {
		SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
        return sysMapper.getSysUserByRoleId(role);
	}
}
