package com.caishen91.jupiter.dao;

import java.util.Map;

public class SysRoleProvider {

    public String queryDepartmentCount(Map<String, Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from sys_role where 1 = 1");
        return builder.toString();
    }

    public String queryDepartmentList(Map<String, Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from sys_role ");
        builder.append(" order by id desc limit #{offset}, #{pageCount}");
        return builder.toString();
    }

    public StringBuilder genQueryParam(StringBuilder builder, Map<String, Object> paramMap) {
        builder.append(" order by modifyTime desc limit #{offset},#{pageCount}");
        return builder;
    }

}
