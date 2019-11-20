package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.SysOperateLog;
import com.caishen91.jupiter.vo.SysOperateLogVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface SysOperateLogMapper {

    @Select("select count(1) from sys_operate_log")
    int querySysLogCountByParam(Map<String,Object> paramMap);


    @Insert("insert into sys_operate_log (sysUserId,logMessage,createTime) values (#{sysUserId},#{logMessage},#{createTime})")
    void addSysOperateLog(SysOperateLog log);


    @Select("SELECT sol.*,su.`name`, sr.department, sr.roleName from sys_operate_log sol LEFT JOIN sys_user su ON sol.sysUserId = su.id  " +
            "   LEFT JOIN sys_role sr ON su.roleId = sr.id order by id desc limit #{offset}, #{pageCount}")
    List<SysOperateLogVo> querySysLogByParam(Map<String,Object> paramMap);
}
