package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SysMapper {
 
	 
	/**
	 * 获取系统管理用户角色
	 */
	@Deprecated
	@Select("select id as id ,roleName as name from sys_role where status=1 and webRole=1 ")
	public List<HashMap<String, Object>> getsysUserRole();
	

	@Deprecated
	@Select("select * from sys_permit")
	public List<SysPermit> getSysPermitByRoleId(@Param("roleId") int roleId);



	/**
	 * 按权限id获取菜单信息
	 * @param roleId
	 * @return
	 */
	@Select("select * from sys_permit where roleId=#{roleId} order by displayseq  ")
	public List<SysPermit> getSysPermitByRole(@Param("roleId") int roleId);

	/**
	 * 删除用户权限
	 * @param userId
	 */
	@Select("delete from sysUserPermit where userId=#{userId}")
	public void deleteSysUserPermitByUserId(@Param("userId") int userId);

	/**
	 * 批量添加用户菜单权限
	 */
	@SelectProvider(type = SysMapperProvider.class, method = "addSysUserPermitList")
	public void addSysUserPermitList(@Param("sysUserPermits") List<SysUserPermit> sysUserPermits);


	/**
	 * 按用户id及角色id获取菜单信息
	 * @param uId
	 * @param rId
	 * @return
	 */
	@Select("select * from sysUserPermit where userId=#{userId} and roleId=#{roleId}")
	  public List<SysUserPermit> getSysUserPermitByUserIdRoleId(@Param("userId") int uId, @Param("roleId") int rId);




	@SelectProvider(type = SysMapperProvider.class, method = "getSuggestCommentList")
	public List<HashMap<String, Object>> getSuggestCommentList(
            @Param("offset") int offset,
            @Param("pagesize") int pagesize,
            @Param("status") int status);

	@SelectProvider(type = SysMapperProvider.class, method = "getSuggestCommentListCount")
	public int getSuggestCommentListCount(@Param("status") int status);


	@SelectProvider(type = SysMapperProvider.class, method = "getSuggestContentList")
	public List<HashMap<String, Object>> getSuggestContentList(
            @Param("offset") int offset,
            @Param("pagesize") int pagesize);

	@SelectProvider(type = SysMapperProvider.class, method = "getSuggestContentListCount")
	public int getSuggestContentListCount();

	@Update(" update suggest_like_content set countTotal = #{countTotal} where id= #{id}")
	public int updateSuggestDzCount(@Param("id") int id, @Param("countTotal") int countTotal);

	@Select(" SELECT countTotal from suggest_like_content WHERE id = #{id} ")
	public int getLcById(int id);

	@SelectProvider(type = SysMapperProvider.class, method = "getHolidayManageList")
	public List<HashMap<String, Object>> getHolidayManageList(
            @Param("offset") int offset,
            @Param("pagesize") int pagesize,
            @Param("yearId") String yearId);

	@SelectProvider(type = SysMapperProvider.class, method = "getHolidayManageListCount")
	public int getHolidayManageListCount(@Param("yearId") String yearId);

	@Update(" update holiday_record set status = #{status} where id = #{id}")
	public int updateHolidayRecord(@Param("id") int id, @Param("status") int status);
	
	@Select(" select DISTINCT yearId FROM holiday_record where status = 0 ORDER BY yearId desc ")
	public List<Integer> getAllHolidayYear();
	
	@Select(" select count(1) from cancel_transfee_op_sys_users where sysUserId = #{sysUsrId}")
	public int getCancelTransfeeOpBySysUsrId(int sysUsrId);
	
	@Select("select * from sys_permit where tag = #{tag}")
	public SysPermit getSysPermitByTag(@Param("tag") String tag);
	
	@SelectProvider(type = SysMapperProvider.class, method = "getSysPermitByTags")
	public List<SysPermit> getSysPermitByTags(@Param("tags") List<String> tags);
	
	@Select("select * from sys_user a, sysUserPermit b where a.id = b.userId and b.refId = #{permitId} and b.permit = 1")
	public List<SysUser> getUserWithPermit(@Param("permitId") int permitId);
	
	@SelectProvider(type = SysMapperProvider.class, method = "getUserWithPermits")
	public List<SysUser> getUserWithPermits(@Param("permitIds") List<Integer> permitIds);
	
	@Select("select b.* from sysUserPermit a, sys_permit b where a.userId = #{userId} and a.refId = b.id and a.permit = 1")
	public List<SysPermit> getUserPermitsByUserId(@Param("userId") int userId);



    @Insert("insert  into sys_user (name, deptId, levelId, loginName, mobile, registerTime, passwd, status, companyId, roleId, gender, positionId,leaderId,userId)" +
            " 						values"
            + "						(#{name}, #{deptId}, #{levelId}, #{loginName}, #{mobile}, #{registerTime}, #{passwd}, #{status}, #{companyId}, #{roleId}, #{gender}, #{positionId}, #{leaderId}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addUser(SysUser sysUser);

    @Update("update sys_user set name = #{name}, "
            + "					  deptId = #{deptId},"
            + "					  levelId = #{levelId},"
            + "					  gender = #{gender},"
            + "					  positionId = #{positionId},"
            + "					  mobile = #{mobile},"
            + "					  loginName = #{loginName},"
            + "					  leaderId = #{leaderId}"
            + "				where id = #{id}")
    public void updateUser(SysUser sysUser);

    @Select("select * from sys_user where id = #{id}")
    public SysUser getUserById(@Param("id") int id);

    @Select("select * from sys_user where loginName = #{loginName} and passwd = #{passwd}")
    public SysUser getUserByLoginNamePasswd(@Param("loginName") String loginName, @Param("passwd") String passwd);


    @Select("select * from sys_user where mobile = #{mobile} and passwd = #{passwd}")
    public SysUser getUserByMobilePasswd(@Param("mobile") String mobile, @Param("passwd") String passwd);

    @Select("update sys_user set passwd = #{passwd}, passwdChanged = true where id = #{id}")
    public void chgPasswd(SysUser sysUser);

    @SelectProvider(type = SysMapperProvider.class, method = "getTotalDeptUsersByParam")
    public int getTotalDeptUsersByParam(Map queryMap);

    @SelectProvider(type = SysMapperProvider.class, method = "getDeptUsersByParam")
    public List<SysUser> getDeptUsersByParam(Map queryMap);

    @Select("select * from sys_user where mobile = #{mobile} limit 1")
    public SysUser getUserByMobile(@Param("mobile") String mobile);

    @Update("update sys_user set status = #{status} where id = #{id}")
    public void setUserStatus(SysUser sysUser);

    @SelectProvider(type = SysMapperProvider.class, method = "getUsersByDeptIds")
    public List<SysUser> getUsersByDeptIds(@Param("deptIds") List<Integer> deptIds);

    @Select("select * from sys_user where deptId = #{deptId}")
    public List<SysUser> getUsersByDeptId(@Param("deptId") int deptId);

    @Select("select * from sys_user")
    public List<SysUser> getUsers();

    @Select("select * from sys_user order by deptId")
    public List<SysUser> getUsersOrderByDept();

    @SelectProvider(type = SysMapperProvider.class, method = "getUsersByIds")
    public List<SysUser> getUsersByIds(@Param("userIds") List<Integer> userIds);

    @SelectProvider(type = SysMapperProvider.class, method = "getRevelUserIdByBaseInfoId")
    public List<Integer> getRevelUserIdByBaseInfoId(@Param("baseInfoId") int baseInfoId);

    @Select("select count(1) from sys_user where roleId = #{sysRoleId}")
    int getSysUserCountBySysRoleId(@Param("sysRoleId") int sysRoleId);

    @Select("select * from sys_user where id = #{sysUserId} and passwd = #{oldPassword}")
    SysUser getUserByIdAndPwd(@Param("sysUserId") int sysUserId, @Param("oldPassword") String oldPassword);

    @Select("select * from sys_user where loginName = #{loginName}")
    SysUser getuserByLoginName(@Param("loginName") String loginName);

    @Insert("insert into sys_user" +
			"					(" +
			"					  name, loginName, mobile, registerTime, passwd, passwdChanged, `status`, roleId, email, sex, reportRoleId" +
			"					) " +
			"				values" +
			"					(" +
			"					  #{name}, #{loginName}, #{mobile}, #{registerTime}, #{passwd}, #{passwdChanged}, #{status}, #{roleId}, #{email}, #{sex}, #{reportRoleId}" +
			"					)")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void addNewSysUser(SysUser sysUser);

    @Update("update sys_user set `status` = #{status} where id = #{sysUserId}")
	void updateSysUserStatus(@Param("sysUserId") int sysUserId, @Param("status") String status);

    @Update("update sys_user set passwd = #{password} where id = #{sysUserId}")
	void resetSysUserPwd(@Param("sysUserId") int sysUserId, @Param("password") String password);

    @Select(" select * from sys_user where roleId = #{roleId} limit 0,1")
	public SysUser getSysUserByRoleId(@Param("roleId") int role);
}
