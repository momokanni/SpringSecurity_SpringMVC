package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.Date;
import java.util.Map;

public class FaeRepayInfoProvider {

    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        /*String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }*/

        Integer productId = (Integer)params.get("productId");
        if (productId != null ) {
            sb.append(" and fr.productId = #{productId} ");
        }

        Integer repayStatus = (Integer)params.get("repayStatus");
        if (repayStatus != null ) {
            sb.append(" and fr.repayStatus = #{repayStatus} ");
        }


        Date startTime = (Date) params.get("startTime");
        if(startTime != null){
            sb.append(" and repayDate >= #{startTime}");
        }

        Date endTime = (Date) params.get("endTime");
        if(endTime != null){
            sb.append(" and repayDate <= #{endTime}");
        }

/*
        List<Integer> statuses = (List<Integer>)params.get("productStatus");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and productStatus in " + StringUtil.buildIntInSql(statuses));
        }
*/


        return sb.toString();
    }

    public String queryFaeRepayInfoCountByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from fae_repay_info fr where 1=1  ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }

    public String queryFaeRepayInfoCountMapByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT count(1) count,SUM(repayPrincipal) repayPrincipal,SUM(repayInterest) repayInterest from ( SELECT a.*,fp.productName from ( ");
        sb.append(" select fr.*,fe.phase establishPhase from fae_repay_info fr LEFT JOIN fae_establish_info fe ON fr.establishId = fe.id where 1=1 ");

        sb.append(appendWhereByParam(params));

        sb.append(" )a  LEFT JOIN fae_product fp ON a.productId = fp.id)b LEFT JOIN fae_issue c ON b.issueId = c.id where 1=1");

        String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }

        String issueName = (String)params.get("issueName");
        if (StringUtil.isNotEmpty(issueName)) {
            sb.append(" and c.name like concat('%', #{issueName}, '%') ");
        }

        sb.append(" order by repayDate ");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }

    public String queryFaeRepayInfoByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT b.*,c.`name` issueName from ( SELECT a.*,fp.productName from ( ");
        sb.append(" select fr.*,fe.phase establishPhase from fae_repay_info fr LEFT JOIN fae_establish_info fe ON fr.establishId = fe.id where 1=1 ");

        sb.append(appendWhereByParam(params));

        sb.append(" )a  LEFT JOIN fae_product fp ON a.productId = fp.id)b LEFT JOIN fae_issue c ON b.issueId = c.id where 1=1");

        String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }

        String issueName = (String)params.get("issueName");
        if (StringUtil.isNotEmpty(issueName)) {
            sb.append(" and c.name like concat('%', #{issueName}, '%') ");
        }

        sb.append(" order by repayDate ");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }


}
