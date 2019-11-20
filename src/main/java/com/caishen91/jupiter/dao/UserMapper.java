package com.caishen91.jupiter.dao;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.caishen91.jupiter.model.ClerkRole;
import com.caishen91.jupiter.model.User;
import com.caishen91.jupiter.model.UserStatistic;

public interface UserMapper {

    @SelectProvider(type = UserMapperProvider.class,method = "getUsersByParam")
    List<User> getUsersByParam(Map<String,Object> queryMap);

    @SelectProvider(type = UserMapperProvider.class,method = "getTotalUsersByParam")
    int getTotalUsersByParam(Map<String,Object> queryMap);
    
    @SelectProvider(type = UserMapperProvider.class,method = "getUsersByIds")
    List<User> getUsersByIds(@Param("ids") List<Integer> ids);
    
    @SelectProvider(type = UserMapperProvider.class,method = "getTeamTotalByInviteCode")
    Map getTeamTotalByInviteCode(Map queryMap);
    
    @SelectProvider(type = UserMapperProvider.class,method = "getTeamRoyaltisByInviteCode")
    List<UserStatistic> getTeamRoyaltisByInviteCode(Map queryMap);

    @Select("select * from user_main where id = #{id}")
    User getUserById(@Param("id") int id);

    @Update("update user_main set status = #{status} where id = #{id}")
    void setUserStatus(User user);
    
    @Select("select * from user_main where mobile = #{mobile}")
    User getUserByMobile(@Param("mobile") String mobile);
    
    
    @Select("select * from user_main where inviteCode = #{inviteCode}")
    User getUserByInviteCode(@Param("inviteCode") String inviteCode);
    
    @Insert("insert into user_main (userName, password, mobile, inviteCode, refCode, registerTime) "
    		+ "					values "
    		+ "					   (#{userName}, #{password}, #{mobile}, #{inviteCode}, #{refCode}, #{registerTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);
    
    @Insert("insert into user_statistic (userId) "
    		+ "					values "
    		+ "					   (#{userId})")
    int addUserStaticAfterReg(UserStatistic userStatistic);
    
    
    @Insert("insert into user_main (userName, password, mobile, inviteCode, refCode, realName,clerk) "
    		+ "					values "
    		+ "					   (#{userName}, '', #{mobile}, #{inviteCode}, #{refCode}, #{realName}, #{clerk})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser4ImportOldData(User user);
    
    @Update("update user_main set userName = #{userName}, "
    		+ "					  mobile = #{mobile},"
    		+ "					  inviteCode = #{inviteCode},"
    		+ "					  realName = #{realName},"
    		+ "					  refCode = #{refCode},"
    		+ "                   clerk = #{clerk}"
    		+ "				 where id = #{id}")
    int updateUser4ImportOldData(User user);
    
    
    @Update("update user_main set password = #{password} where id = #{id}")
    void resetPassword(User user);
    
    @Update("update user_main set refCode = #{refCode} where id = #{id}")
    void addRefCode(User user);
    
    @Update("update user_main set roytalTop = #{roytalTop} where id = #{id}")
    void setRoyalTop(User user);
    
    @Update("update user_statistic set totalStockRoyalty = totalStockRoyalty + #{stockRoyaltyDelta}, "
    		+ "						   totalIncrementalRoyalty = totalIncrementalRoyalty + #{incrementalRoyaltyDelta}, "
    		+ "						   totalRoyalty = totalRoyalty + #{stockRoyaltyDelta} + #{incrementalRoyaltyDelta} "
    		+ "				   where   userId = #{userId}")
    void setRoyaltyStatustic(@Param("userId") int userId, 
    						 @Param("stockRoyaltyDelta") BigDecimal stockRoyaltyDelta, 
    						 @Param("incrementalRoyaltyDelta") BigDecimal incrementalRoyaltyDelta);
    
    @Select("select * from user_main where realName = #{name} and clerk = 1")
    List<User> getClerkByName(@Param("name") String name);
    
    @Update("update user_main set clerk = #{clerk}, clerkRoleId = #{clerkRoleId} where id = #{id}")
    void setClerkFlag(User user);
    
    @Update("update user_statistic set totalInvestAmount = totalInvestAmount + #{investAmountDelta} where userId = #{userId}")
    void addInvestAmount(@Param("userId") int userId, @Param("investAmountDelta") BigDecimal investAmountDelta);
    
    @Update("update user_statistic set totalRoyaltied = totalRoyaltied + #{royaltiedDelta}, "
    		+ "						   totalRoyaltyInvestAmount = totalRoyaltyInvestAmount + #{royaltyInvestAmountDelte} "
    		+ "					 where userId = #{userId}")
    void addRoyaltyAmount(@Param("userId") int userId, 
    					  @Param("royaltyInvestAmountDelte") BigDecimal royaltyInvestAmountDelte,
    					  @Param("royaltiedDelta") BigDecimal royaltiedDelta);
    
    @Select("select * from clerk_role")
    List<ClerkRole> getClerkRoles();
    
    @Select("select * from clerk_role where id = #{id}")
    ClerkRole getClerkRoleById(@Param("id") int id);
    
    @Update("update clerk_role set name = #{name} where id = #{id}")
    void updateClerkRole(ClerkRole cr);
    
    @Insert("insert into clerk_role (name, createTime) "
    		+ "					values "
    		+ "					   (#{name}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addClerkRole(ClerkRole cr); 
}
