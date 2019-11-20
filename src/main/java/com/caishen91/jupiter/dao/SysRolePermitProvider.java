package com.caishen91.jupiter.dao;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import com.caishen91.jupiter.model.SysRolePermit;


public class SysRolePermitProvider {
	
	@SuppressWarnings("unchecked")
	public String updateRoleAuth(Map<String, Object> map) {
    	List<SysRolePermit> iRelaList = (List<SysRolePermit>) map.get("list");  
        StringBuilder sb = new StringBuilder();  
        sb.append("INSERT INTO sysRolePermit ");  
        sb.append("(roleId,refId,permit,createTime,updateTime) ");  
        sb.append("VALUES ");  
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].roleId},#'{'list[{0}].refId},#'{'list[{0}].permit},#'{'list[{0}].createTime},#'{'list[{0}].updateTime})");  
        for (int i = 0; i < iRelaList.size(); i++) {  
            sb.append(mf.format(new Object[]{i}));  
            if (i < iRelaList.size() - 1) {  
                sb.append(",");  
            }  
        }
        return sb.toString();
    }
}
