package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.model.ClerkRole;
import com.caishen91.jupiter.model.User;
import com.caishen91.jupiter.model.UserStatistic;

public interface IUserService {

    List<User> getUsersByParam(Map<String,Object> queryMap);

    int getTotalUsersByParam(Map<String,Object> queryMap);

    User getUserById(int id);

    boolean setUserStatus(User user);
    
    
    User getUserByMobile(String mobile);
    
    User getUserByInviteCode(String inviteCode);
    
    
    void addUser(User user);
    
    
    void resetPassword(User user);
    
    void addRefCode(User user);
    
    List<User> getClerkByName(String name);
    
    
    List<User> getUsersByIds(List<Integer> ids);
    
    
    boolean setClerk(User user, int roleId);
    
    
    Map getTeamTotalByInviteCode(Map queryMap);
    
    List<UserStatistic> getTeamRoyaltisByInviteCode(Map queryMap);
    
    List<ClerkRole> getClerkRoles();
    
    ClerkRole getClerkRoleById(int id);
    
    boolean updateClerkRole(ClerkRole cr);
    
    boolean addClerkRole(ClerkRole cr);
}
