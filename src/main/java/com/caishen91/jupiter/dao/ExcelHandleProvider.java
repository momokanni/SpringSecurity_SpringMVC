package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class ExcelHandleProvider {

    public String getExcelHandleByIds(Map<String,List<Integer>> paramMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from excel_handle");
        List<Integer> excelHandleIds = paramMap.get("excelHandleIds");
        if (null != excelHandleIds && excelHandleIds.size() > 0) {
            builder.append(" where id in " + StringUtil.buildIntInSql(excelHandleIds));
        }
        return builder.toString();
    }
}
