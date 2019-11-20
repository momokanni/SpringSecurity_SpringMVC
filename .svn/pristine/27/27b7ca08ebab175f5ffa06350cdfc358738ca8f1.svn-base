package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class ArticleTypeProvider {


    public String getTotalAticleTypeCountByParams(Map params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select count(1) from article_type where 1 = 1 ");

        sb.append(getAticleTypeByParamsWhere(params));

        return sb.toString();
    }


    public String getAticleTypeByParams(Map params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select * from article_type where 1 = 1");
        sb.append(getAticleTypeByParamsWhere(params));

        sb.append(" order by id desc limit #{offset}, #{pageSize}");
        return sb.toString();
    }

    public String getAticleTypeByParamsWhere(Map params) {

        StringBuilder sb = new StringBuilder();

        String name = (String)params.get("name");
        if (StringUtil.isNotEmpty(name)) {
            sb.append(" and name like concat('%',#{name}, '%')");
        }

        List<Integer> statuses = (List)params.get("statuses");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and status in ");
            sb.append(StringUtil.buildIntInSql(statuses));
        }


        return sb.toString();
    }
}
