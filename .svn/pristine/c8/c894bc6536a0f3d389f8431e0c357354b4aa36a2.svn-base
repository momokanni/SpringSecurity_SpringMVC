package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class NoticeProvider {

    public String getTotalNoticeCountByParams(Map params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select count(1) from notice where 1 = 1 ");

        sb.append(getNoticeByParamsWhere(params));

        return sb.toString();
    }


    public String getNoticeByParams(Map params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select * from notice where 1 = 1");
        sb.append(getNoticeByParamsWhere(params));

        sb.append(" order by id desc limit #{offset}, #{pageSize}");
        return sb.toString();
    }

    public String getNoticeByParamsWhere(Map params) {

        StringBuilder sb = new StringBuilder();

        String title = (String)params.get("title");
        if (StringUtil.isNotEmpty(title)) {
            sb.append(" and title like concat('%',#{title}, '%')");
        }

        List<Integer> statuses = (List)params.get("statuses");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and status in ");
            sb.append(StringUtil.buildIntInSql(statuses));
        }


        return sb.toString();
    }
}
