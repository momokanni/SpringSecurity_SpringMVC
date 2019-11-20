package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.SysUserPermit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysUserPermitMapper {

    @Select("select * from sysUserPermit where userId = #{sysUserId}")
    List<SysUserPermit> getSysUserPermitBySysUserId(@Param("sysUserId") int sysUserId);

    @Select("update sysUserPermit set permit = 0 where userId = #{sysUserId}")
    void revocationSysUserAuthAll(@Param("sysUserId") int sysUserId);

    @Insert("insert into sysUserPermit(userId, refId, permit) values(#{userId}, #{refId}, #{permit})")
    void allotSysUserAuth(SysUserPermit sysUserPermit);

    @Select("SELECT su.`id` as 'uId',su.`name`,su.`loginName`,sup.refId,sup.`permit`,sup.`id` AS 'upId' FROM sys_user su "
    		+ " LEFT JOIN sysUserPermit sup ON sup.`roleId` = su.`roleId` "
    		+ " WHERE su.`id` = #{userId} AND su.`roleId` = #{roleId}")
	List<Map<String, Object>> getSysUserPermitAllByUserIdAndRoleId(@Param("userId") int id,@Param("roleId") Integer roleId);

    @InsertProvider(type = SysUserPermitProvider.class,method = "insertBatch")
	void insertBatch(@Param("list") List<SysUserPermit> refs);
}
