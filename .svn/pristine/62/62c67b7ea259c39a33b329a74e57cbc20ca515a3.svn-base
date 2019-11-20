package com.caishen91.jupiter.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.util.StringUtil;

/**
 * @Auther: jgn
 * @Date: 2/25/19 12 59
 * Description:
 */
public class UserMapperProvider {

	
	public String getTeamTotalByInviteCode(Map params) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select count(1) as total, ifnull(sum(totalInvestAmount), 0) as totalInvestAmount, ifnull(sum(totalRoyaltied),0) as totalRoyaltied from user_statistic a, user_main b ");
		sb.append(" where a.userId = b.id and b.refCode = #{inviteCode} ");
		return sb.toString();
	}
	
	public String getTeamRoyaltisByInviteCode(Map params) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select * from user_statistic a, user_main b ");
		sb.append(" where a.userId = b.id and b.refCode = #{inviteCode} ");
		
		sb.append(" order by a.userId desc limit #{offset}, #{pageSize}");
		return sb.toString();
		
	}
	
    private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        String userName = (String)params.get("userName");
        if (StringUtil.isNotEmpty(userName)) {
            sb.append(" and userName like concat('%', #{userName}, '%') ");
        }

        String realName = (String)params.get("realName");
        if (StringUtil.isNotEmpty(realName)) {
            sb.append(" and realName like concat('%', #{realName}, '%') ");
        }

        String mobile = (String)params.get("mobile");
        if (StringUtil.isNotEmpty(mobile)) {
            sb.append(" and mobile like concat('%', #{mobile}, '%') ");
        }

        String inviteCode = (String)params.get("inviteCode");
        if (StringUtil.isNotEmpty(inviteCode)) {
            sb.append(" and inviteCode = #{inviteCode} ");
        }

        String refCode = (String)params.get("refCode");
        if (StringUtil.isNotEmpty(refCode)) {
            sb.append(" and refCode = #{refCode} ");
        }

        String[] statuses = (String[])params.get("statuses");
        if (statuses != null && statuses.length > 0) {
            sb.append(" and status in (" +StringUtil.buildStringSplits(statuses)+ ") ");
        }

        Date startTime = (Date) params.get("startTime");
        if(startTime != null){
            sb.append(" and registerTime >= #{startTime}");
        }

        Date endTime = (Date) params.get("endTime");
        if(endTime != null){
            sb.append(" and registerTime <= #{endTime}");
        }

        return sb.toString();
    }


    public String getUsersByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from user_main where 1=1 ");
        sb.append(appendWhereByParam(params));

        Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
    }

    public String getTotalUsersByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from user_main where 1=1 ");
        sb.append(appendWhereByParam(params));
        return sb.toString();
    }
    
    public String getUsersByIds(Map params) {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("select * from user_main where id in ");
    	
    	List<Integer> ids = (List)params.get("ids");
    	sb.append(StringUtil.buildIntInSql(ids));
    	
    	return sb.toString();
    }


}
