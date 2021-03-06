package com.caishen91.jupiter.model;

import java.util.Date;
import com.caishen91.jupiter.authorize.enums.EnabledStatus;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.enums.SysRole;

public class SysUser {

	private int id;
	
	private String name;

	private int deptId;

	private int positionId;

	private String loginName;

	private String mobile;

	private Date registerTime;

	private String passwd;

	private boolean passwdChanged;

	private int status;

	private int companyId;

	private int levelId;

	private int roleId;

	private int gender;

	private int leaderId;

	private int leaderDeptId;//库里没有该字段

	private int userId;

	private String email;

	private int sex;

	private int reportRoleId;
	
	/**
	 * 锁定状态
	 */
	private int lockStatus;
	/**
	 * 权限列表
	 */
	private String authorities;
	/**
	 * 是否启用
	 */
	private int enabled;

	private Date createTime;

	private Date updateTime;
	
	public SysUser(){
		
	}
	
	public SysUser(String name, String loginName, String mobile, int roleId,String pwd) {
		this.name = name;
		this.loginName = loginName;
		this.mobile = mobile;
		this.roleId = roleId;
		this.registerTime = new Date();
		this.userId = 0;
		this.status = EnabledStatus.ENABLED.getCode();
		this.passwd = pwd;
		this.enabled = EnabledStatus.ENABLED.getCode();
		this.lockStatus = 0;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLeaderDeptId() {
		return leaderDeptId;
	}

	public void setLeaderDeptId(int leaderDeptId) {
		this.leaderDeptId = leaderDeptId;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isPasswdChanged() {
		return passwdChanged;
	}

	public void setPasswdChanged(boolean passwdChanged) {
		this.passwdChanged = passwdChanged;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}



	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isAdmin() {
		return roleId == SysRole.admin.getRole();
	}

	public boolean isAvailable() {
		return status == EnabledStatus.ENABLED.getCode();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getReportRoleId() {
		return reportRoleId;
	}

	public void setReportRoleId(int reportRoleId) {
		this.reportRoleId = reportRoleId;
	}

	public int getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	public static enum SysUserSex{
		man(1, "男"),
		woman(2, "女"),
		unknown(3, "未知"),
		;

		private int sex;

		private String desc;

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		SysUserSex(int sex, String desc) {
			this.sex = sex;
			this.desc = desc;
		}

		public static SysUserSex getSysUserSex(int sex) {
			for (SysUserSex sysUserSex : values()) {
				if (sysUserSex.getSex() == sex) {
					return sysUserSex;
				}
			}
			return null;
		}
	}

	public static enum SysuserStatus{
		normal(0, "正常"),
		forbidden(1, "禁用"),
		;

		private int status;

		private String desc;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		SysuserStatus(int status, String desc) {
			this.status = status;
			this.desc = desc;
		}

		public static SysuserStatus getSysuserStatus(int status) {
			for (SysuserStatus sysuserStatus : values()) {
				if (sysuserStatus.getStatus() == status) {
					return sysuserStatus;
				}
			}
			return null;
		}
	}
}
