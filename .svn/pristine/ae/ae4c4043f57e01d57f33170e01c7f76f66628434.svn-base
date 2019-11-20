package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.Map;

public class FaeCliqueProvider {

    public String queryFaeCliqueCountByParam(Map<String,Object> paramMap){
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from fae_clique where 1 = 1");
        genQueryParam(builder, paramMap);

        return builder.toString();
    }

    public String queryFaeCliqueListByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from fae_clique where 1 = 1");
        genQueryParam(builder, paramMap);
        builder.append(" order by createTime desc limit #{offset},#{pageCount}");
        return builder.toString();
    }

    public StringBuilder genQueryParam(StringBuilder builder, Map<String,Object> paramMap) {
        String shortName = String.valueOf(paramMap.get("shortName"));
        if (StringUtil.isNotEmpty(shortName) && !"null".equals(shortName)) {
            builder.append(" and shortName like concat('%',#{shortName},'%')");
        }

        String startTime =  String.valueOf(paramMap.get("startTime"));
        if (StringUtil.isNotEmpty(startTime) && !"null".equals(startTime)) {
            builder.append(" and createTime >= #{startTime}");
        }

        String endTime =  String.valueOf(paramMap.get("endTime"));
        if (StringUtil.isNotEmpty(endTime) && !"null".equals(endTime)) {
            builder.append(" and createTime <= #{endTime}");
        }

        return builder;
    }
}
