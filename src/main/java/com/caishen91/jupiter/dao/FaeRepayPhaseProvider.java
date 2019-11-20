package com.caishen91.jupiter.dao;


import java.util.Map;

public class FaeRepayPhaseProvider {

    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        /*String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }*/

        Integer repayInfoId = (Integer)params.get("repayInfoId");
        if (repayInfoId != null ) {
            sb.append(" and repayInfoId = #{repayInfoId} ");
        }

        /*Integer repayStatus = (Integer)params.get("repayStatus");
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
        }*/

/*
        List<Integer> statuses = (List<Integer>)params.get("productStatus");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and productStatus in " + StringUtil.buildIntInSql(statuses));
        }
*/


        return sb.toString();
    }



    public String queryFaeRepayPhaseCountMapByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) count,sum(repayPrincipal) repayPrincipal,sum(repayInterest) repayInterest from fae_investor_repay_phase where 1=1 ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }

    public String queryFaeRepayPhaseCountByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from fae_repay_info fr where 1=1  ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }



    public String queryFaeRepayPhaseByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT @rowno:=@rowno + 1 AS num,k.* FROM  (");
        sb.append("SELECT @rowNum:=@rowNum + 1 num, b.*,fbc.bankCode,fbc.bankName,fbc.slaveName FROM " +
                " (SELECT a.*,fir.bankCardId from ( " +
                " select firp.investRecordId,firp.investorId,firp.repayPrincipal,firp.repayInterest,fi.companyName,fi.realName,fi.creditCode,fi.idCardNo,fi.type userType " +
                " from fae_investor_repay_phase firp  " +
                " LEFT JOIN fae_investor fi on firp.investorId = fi.id  " +
                " where 1=1 ");

        sb.append(appendWhereByParam(params));

        sb.append(" )a " +
                " LEFT JOIN fae_invest_record fir ON a.investRecordId = fir.id)b " +
                " LEFT JOIN fae_bank_card fbc ON b.bankCardId = fbc.id ");
        sb.append(" )k ,(SELECT @rowno:=0) f");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }


}
