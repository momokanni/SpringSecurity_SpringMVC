package com.caishen91.jupiter.service;


import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.model.SysUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ISysUserService {

	public SysUser getUserByLoginNamePasswd(String loginName, String passwd);

	public SysUser getUserByMobilePasswd(String mobile, String passwd);

	public boolean chgPasswd(SysUser sysUser);

	public int getTotalDeptUsersByParam(Map queryMap);

	public List<SysUser> getDeptUsersByParam(Map queryMap);

	public SysUser getUserByMobile(String mobile);

	public SysUser getUserById(int id);

	public boolean addUser(SysUser sysUser);

	public boolean updateUser(SysUser sysUser);

	public boolean setUserStatus(SysUser sysUser);

	public List<SysUser> getUsersByDeptIds(List<Integer> deptIds);

	public List<SysUser> getUsersByIds(List<Integer> userIds);

	public List<Integer> getDeptUserIdsLeaderByUser(SysUser sysUser);

	public List<Integer> getUserIdsLeaderByUser(SysUser sysUser);

	public List<SysUser> getAllUsers();

	public List<SysUser> getUserWithPermit(int permitId);

	public List<SysUser> getUserWithPermitTag(String tag);

	public SysUser getNearestLeadersWithPermit(int userId, String permitTag);

	/**
	 * 
	* @描述：按角色id获取用户信息
	* @开发时间： 2014-10-8 下午3:06:01
	 */
	public List<HashMap<String, Object>> getRoleIdValueInfo(int roleId);
	

	/**
	 * 验证sys_user和user_main用户名中是否存在
	 */
	public boolean isExsitSysAndUser(String userName);



    /**
     * 按角色id获取菜单信息
     * @param roleId
     * @return
     */

    public List<SysPermit> getSysPermitByRole(int roleId);

    /**
     * 用户菜单操作
     * @param sysUser
     * @param sups
     */
    public boolean updateUserPermit(SysUser sysUser, List<SysUserPermit> sups);

    /**
     * 按用户id及角色id获取菜单信息
     * @param uId
     * @param rId
     * @return
     */
    public List<SysUserPermit> getSysUserPermitByUserIdRoleId(int uId, int rId);

	public List<SysPermit> getUserPermitsByUserId(int userId);

	public void updateSuggestCommonStatus(int id, int status);

	public boolean updateSuggestDzCount(int id, int countTotal);

	public int getLcById(int id);

	public boolean updateHolidayRecord(int id, int status);

	public List<Integer> getAllHolidayYear();

	public int getCancelTransfeeOpBySysUsrId(int sysUserId);

	// public PageVo<HashMap<String, Object>> sysUserList(PageVo<HashMap<String, Object>> pageVo, Map<String, Object> argsMap) ;

	public List<SysPermit> getBusinessRoles(int userId, int roleId);
	
	public SysPermit getSysPermitByTag(String tag);

    int getSysUserCountBySysRoleId(int sysRoleId);

    SysUser getUserByIdAndPwd(int sysUserId, String oldPassword);

    SysUser getuserByLoginName(String loginName);

	void addNewSysUser(SysUser sysUser);

	void updateSysUserStatus(int sysUserId, String status);

	void resetSysUserPwd(int sysUserId, String password);

	void setSysUserId(int sysUserId);

	public SysUser getSysUserByRoleId(int role);
}
