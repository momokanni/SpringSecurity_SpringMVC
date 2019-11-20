package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class FaeInvestRecordProvider {

    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        /*String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }*/

        Integer productId = (Integer)params.get("productId");
        if (productId != null ) {
            sb.append(" and fir.productId = #{productId} ");
        }

        Integer investorId = (Integer)params.get("investorId");
        if (investorId != null ) {
            sb.append(" and fir.investorId = #{investorId} ");
        }

        List<Integer> statuses = (List<Integer>)params.get("statuses");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and fir.status in " + StringUtil.buildIntInSql(statuses));
        }
        /*Date startTime = (Date) params.get("startTime");
        if(startTime != null){
            sb.append(" and createTime >= #{startTime}");
        }

        Date endTime = (Date) params.get("endTime");
        if(endTime != null){
            sb.append(" and createTime <= #{endTime}");
        }


        List<Integer> statuses = (List<Integer>)params.get("productStatus");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and productStatus in " + StringUtil.buildIntInSql(statuses));
        }
*/


        return sb.toString();
    }

    public String queryFaeInvestRecordCountByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from fae_invest_record fir left join fae_investor fi on fir.investorId = fi.id where 1=1 ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }

    public String queryFaeInvestRecordCountMapByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) count,SUM(fir.investAmount) totalInvest from fae_invest_record fir left join fae_investor fi on fir.investorId = fi.id where 1=1 ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }



    public String queryFaeInvestRecordByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        sb.append(" SELECT k.*,fp.productName,fp.expectRate from ");
        sb.append(" (SELECT t.*,fei.establishDate,fei.incomeTerm,fei.phase,fei.dueDate  from ");
        sb.append(" (SELECT fir.id,fir.status, fir.establishId, fir.productId ,fi.type investorType,fi.realName,fi.companyName,fi.idCardNo,fi.creditCode,fir.investAmount,fir.investTime from ");
        sb.append(" fae_invest_record fir LEFT JOIN fae_investor fi ON fir.investorId = fi.id where 1=1 ");

        sb.append(appendWhereByParam(params));

        sb.append(" )t LEFT JOIN fae_establish_info fei ON t.establishId =  fei.id)k ");
        sb.append(" LEFT JOIN fae_product fp ON k.productId = fp.id ");




        if(params.get("sortField") != null && params.get("orderBy") != null  ){
            sb.append("order by  ");
            sb.append(params.get("sortField") + " ");
            sb.append(params.get("orderBy") + "");
        }else{
            sb.append("order by id desc");

        }

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }


}
