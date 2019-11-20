package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysUser;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    int getTotalSysUserCountByParams(Map queryMap);

    List<SysUser> getSysUserByParams(Map queryMap);

    String getSysUserRoleNameByRoleId(int roleId);

    SysUser getAccountById(int id);

    boolean setAccountStatus(SysUser sysUser);

    List<SysRole> getSysRole();

    boolean addAccount(SysUser sysUser);

    boolean updateAccount(SysUser sysUser);

    int getArticleCountYesterday();

    int getArticleCount();

    int getAccountCountYesterday();

    int getAccountCount();

    SysUser getAccountByloginName(String loginName);

    SysUser getAccountBymobile(String mobile);
}

