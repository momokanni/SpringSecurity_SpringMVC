package com.caishen91.jupiter.dao;


import java.util.Date;
import java.util.Map;

public class FaeEstablishProvider {

    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        /*String productName = (String)params.get("productName");
        if (StringUtil.isNotEmpty(productName)) {
            sb.append(" and productName like concat('%', #{productName}, '%') ");
        }*/

        /*

        Integer repayStatus = (Integer)params.get("repayStatus");
        if (repayStatus != null ) {
            sb.append(" and fr.repayStatus = #{repayStatus} ");
        }
*/
        Integer productId = (Integer)params.get("productId");
        if (productId != null ) {
            sb.append(" and productId = #{productId} ");
        }

        Date startTime = (Date) params.get("startTime");
        if(startTime != null){
            sb.append(" and establishDate >= #{startTime}");
        }

        Date endTime = (Date) params.get("endTime");
        if(endTime != null){
            sb.append(" and establishDate <= #{endTime}");
        }

/*
        List<Integer> statuses = (List<Integer>)params.get("productStatus");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and productStatus in " + StringUtil.buildIntInSql(statuses));
        }
*/


        return sb.toString();
    }

    public String queryFaeEstablishInfoCountByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from fae_establish_info fr where 1=1  ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }

    public String queryFaeEstablishInfoByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        sb.append(" select * from fae_establish_info where 1=1 ");

        sb.append(appendWhereByParam(params));

        sb.append("order by id desc");

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }


}
