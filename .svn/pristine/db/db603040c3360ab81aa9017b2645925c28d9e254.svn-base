package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FaeProductProvider {

    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and fp.productName like concat('%', #{productName}, '%') ");
        }

        Integer productType = (Integer)params.get("productType");
        if (productType != null ) {
            sb.append(" and fp.productType = #{productType} ");
        }

        Date startTime = (Date) params.get("startTime");
        if(startTime != null){
            sb.append(" and fp.createTime >= #{startTime}");
        }

        Date endTime = (Date) params.get("endTime");
        if(endTime != null){
            sb.append(" and fp.createTime <= #{endTime}");
        }


        List<Integer> statuses = (List<Integer>)params.get("productStatus");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and fp.productStatus in " + StringUtil.buildIntInSql(statuses));
        }



        return sb.toString();
    }

    public String queryCountFaeProductByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from fae_product fp where 1=1 ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }

    public String queryFaeProductByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from fae_product fp where 1=1 ");
        sb.append(appendWhereByParam(params));

        sb.append("order by id desc");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }

    public String queryFaeProductMapByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select fp.*,fi.name issueName from fae_product fp left join fae_issue fi on fp.issueId = fi.id where 1=1 ");
        sb.append(appendWhereByParam(params));

        sb.append("order by createTime desc");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }
}
