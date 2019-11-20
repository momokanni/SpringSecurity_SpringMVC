package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class FaeUnderwriterProvider {

    public String queryFaeUnderwriterCountByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from fae_underwriter where 1 = 1");
        genQueryParam(builder, paramMap);
        return builder.toString();
    }

    public String queryFaeUnderwriterListByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from fae_underwriter where 1 = 1");
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

    public String getFaeUnderwriterByIds(Map<String,Object> map) {
        StringBuilder builder = new StringBuilder();
        List<Integer> underwriterIds = (List<Integer>) map.get("underwriterIds");
        if (null != underwriterIds && underwriterIds.size() > 0) {
            builder.append("select * from fae_underwriter where id in");
            builder.append(StringUtil.buildIntInSql(underwriterIds));
        }
        return builder.toString();
    }

}
