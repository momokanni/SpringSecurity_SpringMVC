package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.util.StringUtil;

import java.util.Map;

public class FaeInvestorProvider {

    public String queryFaeInvestorCountByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from fae_investor where 1 = 1");
        genQueryParam(builder, paramMap);
        return builder.toString();
    }

    public String queryFaeInvestorListByParam(Map<String,Object> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from fae_investor where 1 = 1");
        genQueryParam(builder, paramMap);
        builder.append(" order by createTime desc limit #{offset},#{pageCount}");
        return builder.toString();
    }

    public StringBuilder genQueryParam(StringBuilder builder, Map<String,Object> paramMap) {
        String name = String.valueOf(paramMap.get("name"));
        if (StringUtil.isNotEmpty(name) && !"null".equals(name)) {
            builder.append(" and (realName like concat('%',#{name},'%') or companyName like concat('%',#{name},'%'))");
        }

        String card = String.valueOf(paramMap.get("card"));
        if (StringUtil.isNotEmpty(card) && !"null".equals(card)) {
            builder.append(" and (idCardNo like concat('%',#{card},'%') or creditCode like concat('%',#{card},'%'))");
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
