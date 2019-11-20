package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.Map;

public class FaeDanbaoProvider {

    public String queryFaeanbaoCountByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from fae_danbao where 1 = 1");
        genQueryParam(builder, paramMap);
        return builder.toString();
    }

    public String queryFaeDanbaoListByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from fae_danbao where 1 = 1");
        genQueryParam(builder, paramMap);
        builder.append(" order by createTime desc limit #{offset},#{pageCount}");
        return builder.toString();
    }

    public StringBuilder genQueryParam(StringBuilder builder, Map<String,Object> paramMap) {
        String shortName = String.valueOf(paramMap.get("shortName"));
        if (StringUtil.isNotEmpty(shortName) && !"null".equals(shortName)) {
            builder.append(" and shortName like concat('%',#{shortName},'%')");
        }

        return builder;
    }
}
