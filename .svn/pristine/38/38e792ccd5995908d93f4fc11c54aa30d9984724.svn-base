package com.caishen91.jupiter.factory;

import com.caishen91.jupiter.enums.SysDepartment;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.util.StringUtil;

import java.util.Date;

/**
 * @Auther: jgn
 * @Date: 3/27/19 17 40
 * Description:系统操作日志工厂类
 */
public class SysOperateLogFactory {

    public static SysOperateLog addSysRoleLog(int currentSysUserId, SysRole sysRole) {
        String logMsg = " 新增角色: " + sysRole.getRoleName();
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog updateSysRoleLog(int currentSysUserId, SysRole sysRole, String roleName) {
        String logMsg = SysDepartment.getSysDepartment(sysRole.getDepartment()).getDesc() + " 原岗位: "
                + roleName + ",修改为: " + sysRole.getRoleName();
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog addSysUserLog(int currentSysUserId, SysUser sysUser) {
        String logMsg = "新增用户: " + sysUser.getLoginName();
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog updateSysUserStatusLog(int currentSysUserId, SysUser sysUser, String status) {
        String logMsg = "用户: " + sysUser.getLoginName() + SysUser.SysuserStatus.getSysuserStatus(Integer.parseInt(status)).getDesc();
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog resetSysUserPwd(int currentSysUserId, SysUser sysUser) {
        String logMsg = "用户: " + sysUser.getLoginName() + ",密码重置";
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog allotAuthLog(int currentSysUserId, SysUser sysUser) {
        String logMsg = "为用户: " + sysUser.getLoginName() + ",分配权限";
        return genCommonSysOperateLog(currentSysUserId, logMsg);
    }

    public static SysOperateLog addMemberLog(int currentSysUserId, Object o) {
        String logMsg = "";
        if (o instanceof FaeClique) {
            FaeClique faeClique = (FaeClique) o;
            logMsg = "添加集团会员: " + faeClique.getShortName();
        } else if (o instanceof FaeIssue) {
            FaeIssue faeIssue = (FaeIssue) o;
            logMsg = "添加发行方会员: " + faeIssue.getShortName();
        } else if (o instanceof FaeDanbao) {
            FaeDanbao faeDanbao = (FaeDanbao) o;
            logMsg = "添加担保方会员: " + faeDanbao.getShortName();
        } else if (o instanceof FaeUnderwriter) {
            FaeUnderwriter faeUnderwriter = (FaeUnderwriter) o;
            logMsg = "添加承销商会员: " + faeUnderwriter.getShortName();
        } else if (o instanceof FaeEntrusted) {
            FaeEntrusted faeEntrusted = (FaeEntrusted) o;
            logMsg = "添加受托管理人: " + faeEntrusted.getShortName();
        } else if (o instanceof FaeInvestor) {
            FaeInvestor faeInvestor = (FaeInvestor) o;
            if (FaeInvestor.FaeInvestorType.personInvestor.getType() == faeInvestor.getType()) {
                logMsg = "添加个人投资人会员: " + faeInvestor.getRealName();
            } else {
                logMsg = "添加企业投资人会员: " + faeInvestor.getCompanyName();
            }
        }

        if (StringUtil.isNotEmpty(logMsg)) {
            return genCommonSysOperateLog(currentSysUserId, logMsg);
        }

        return null;
    }

    private static SysOperateLog genCommonSysOperateLog(int sysUserId,String logMessage){
        SysOperateLog sol = new SysOperateLog();
        sol.setSysUserId(sysUserId);
        sol.setLogMessage(logMessage);
        sol.setCreateTime(new Date());
        return sol;
    }
}