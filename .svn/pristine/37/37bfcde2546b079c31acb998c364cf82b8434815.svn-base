package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.AccountMapper;
import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IAccountService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl extends BaseService implements IAccountService {
    @Override
    public SysUser getAccountById(int id) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountById(id);
    }

    @Override
    public boolean setAccountStatus(SysUser sysUser) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.setAccountStatus(sysUser);
    }

    @Override
    public List<SysRole> getSysRole() {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getSysRole();
    }

    @Override
    public boolean addAccount(SysUser sysUser) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        accountMapper.addAccount(sysUser);
        return true;
    }

    @Override
    public boolean updateAccount(SysUser sysUser) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        accountMapper.updateAccount(sysUser);
        return true;
    }



    @Override
    public int getTotalSysUserCountByParams(Map queryMap) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getTotalSysUserCountByParams(queryMap);

    }

    @Override
    public List<SysUser> getSysUserByParams(Map queryMap) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getSysUserByParams(queryMap);

    }

    @Override
    public String getSysUserRoleNameByRoleId(int roleId) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getSysUserRoleNameByRoleId(roleId);

    }

    @Override
    public int getArticleCountYesterday() {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getArticleCountYesterday();
    }

    @Override
    public int getArticleCount() {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getArticleCount();
    }

    @Override
    public int getAccountCountYesterday() {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountCountYesterday();
    }

    @Override
    public int getAccountCount() {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountCount();
    }

    @Override
    public SysUser getAccountByloginName(String loginName) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountByloginName(loginName);
    }

    @Override
    public SysUser getAccountBymobile(String mobile) {
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountBymobile(mobile);
    }

}
