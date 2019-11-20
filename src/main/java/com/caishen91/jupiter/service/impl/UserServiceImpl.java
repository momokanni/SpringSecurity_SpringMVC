package com.caishen91.jupiter.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.caishen91.jupiter.dao.SysMapper;
import com.caishen91.jupiter.dao.UserMapper;
import com.caishen91.jupiter.enums.SysRole;
import com.caishen91.jupiter.model.ClerkRole;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.User;
import com.caishen91.jupiter.model.UserStatistic;
import com.caishen91.jupiter.service.IUserService;

@Service
public class UserServiceImpl extends BaseService implements IUserService {


    @Override
    public List<User> getUsersByParam(Map<String, Object> queryMap) {
        UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
        return userMapper.getUsersByParam(queryMap);
    }

    @Override
    public int getTotalUsersByParam(Map<String, Object> queryMap) {
        UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
        return userMapper.getTotalUsersByParam(queryMap);
    }

    @Override
    public User getUserById(int id) {
        UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
        return userMapper.getUserById(id);
    }

    @Override
    public boolean setUserStatus(User user) {
        UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);

        try {
            userMapper.setUserStatus(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public User getUserByMobile(String mobile) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getUserByMobile(mobile);
	}

	@Override
	public User getUserByInviteCode(String inviteCode) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getUserByInviteCode(inviteCode);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addUser(User user) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		userMapper.addUser(user);
		UserStatistic us = new UserStatistic();
		us.setUserId(user.getId());
		
		userMapper.addUserStaticAfterReg(us);
	}

	@Override
	public void resetPassword(User user) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		userMapper.resetPassword(user);
		
	}

	@Override
	public void addRefCode(User user) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		userMapper.addRefCode(user);
	}

	@Override
	public List<User> getClerkByName(String name) {
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getClerkByName(name);
	}

	@Override
	public List<User> getUsersByIds(List<Integer> ids) {
		if (ids == null || ids.size() == 0) {
			return new ArrayList();
		}
		UserMapper  userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getUsersByIds(ids);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean setClerk(User user, int roleId) {
		SysMapper sysMapper = writableSQLSession.getMapper(SysMapper.class);
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		
		boolean isClerk = user.isClerk();
		user.setClerk(true);
		
		user.setClerkRoleId(roleId);
		
		userMapper.setClerkFlag(user);
		
		if (!isClerk) {
			SysUser su = new SysUser();
			
			su.setName(user.getRealName());
			su.setLoginName(user.getMobile());
			su.setMobile(user.getMobile());
			su.setRegisterTime(user.getRegisterTime());
			if (su.getRegisterTime() == null) {
				su.setRegisterTime(new Date());
			}
			su.setPasswd(user.getPassword());
			su.setRoleId(SysRole.admin.getRole());
			su.setUserId(user.getId());
			
			sysMapper.addUser(su);
		} 
		
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map getTeamTotalByInviteCode(Map queryMap) {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getTeamTotalByInviteCode(queryMap);
	}

	@Override
	public List<UserStatistic> getTeamRoyaltisByInviteCode(Map queryMap) {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getTeamRoyaltisByInviteCode(queryMap);
	}

	@Override
	public List<ClerkRole> getClerkRoles() {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getClerkRoles();
	}

	@Override
	public ClerkRole getClerkRoleById(int id) {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		return userMapper.getClerkRoleById(id);
	}

	@Override
	public boolean updateClerkRole(ClerkRole cr) {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		userMapper.updateClerkRole(cr);
		return true;
	}

	@Override
	public boolean addClerkRole(ClerkRole cr) {
		UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
		userMapper.addClerkRole(cr);
		return true;
	}
	
	
}
