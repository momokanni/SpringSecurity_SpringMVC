package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.util.StringUtil;

public class SysPermitProvider {

    public String getSysPermitByIds(Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        List<Integer> sysPermitIds = (List<Integer>) map.get("sysPermitIds");
        if (null != sysPermitIds && sysPermitIds.size() > 0) {
           builder.append("select * from sys_permit where id in");
           builder.append(StringUtil.buildIntInSql(sysPermitIds));
           builder.append(" and type = 'menu'");
        }
        return builder.toString();
    }
}
