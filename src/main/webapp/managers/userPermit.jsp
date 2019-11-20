<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.util.LoginUtil" %>
<%@ page import="com.caishen91.jupiter.model.SysPermit" %>
<%@ page import="com.caishen91.jupiter.model.SysUserPermit" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.SysUser" %>
<%@ page isELIgnored="true" %>
<%
	SysUser sysUser = LoginUtil.getSysLoginUser(request, response);
	if (sysUser == null|| sysUser.getRoleId()!=5) {
		return;
	}
	List<SysPermit>  topMenus=(List<SysPermit>)request.getAttribute("parentPermit");
	SysUser sysUsr=(SysUser)request.getAttribute("sysUser");
	
	//二级菜单Map
	Map<Integer,List<SysPermit>> menuMap=(Map<Integer,List<SysPermit>>)request.getAttribute("menuMap");
	
	//菜单权限
	List<SysUserPermit> sysUserPermitList=(List<SysUserPermit>)request.getAttribute("sysUserPermitList");
	Map<Integer,SysUserPermit> sysUserPermitMap=new HashMap<Integer,SysUserPermit>();
	for(SysUserPermit p:sysUserPermitList){
		sysUserPermitMap.put(p.getRefId(), p);
	}
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>原始债权人</title>
<link href="/css/manager/layout.css" rel="stylesheet"></link>
<link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/manager/m_main.css?<%@include file='/include/.ver'%>" />
<link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/manager/m_basic.css?<%@include file='/include/.ver'%>" />
<link href="/front/styles/<%=Config.FRONT_PREFIX %>/qdatepicker.css?<%@include file='/include/.ver'%>" rel="stylesheet" />
<style>
	.dke-dp {
		width:170px;
	}
	.dke-dp .dp-info {
		width:30%
	}
</style> 
<script type="text/javascript">  
</script>
</head>
<body>
	<div class="mandiv">
		<h2 class="title">添加用户</h2>
		<div class="maninput pdt5 pb50 pt20 adduse">
			 <form action="/manager/updatePermit" class='form' method="post" id="frm"> 
			 
    	   <input type="hidden" value="<%=sysUsr.getId() %>" name="uid" id="uid" />
    	  <table width="95%" align="center" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    	  <tr>
    	  	<td style="line-height:10px">
    	  		<h2>帐号：<%=sysUsr.getName() %></h2>
    	  	</td>
    	  </tr>
    	  <tr>
    	  	<td style="line-height:10px">
    	  <%
    	 		SysUserPermit userPermit=null;
    	  		String key = "";
    	  		for (SysPermit topMenu : topMenus) {
    	  			Integer rId = topMenu.getId();
    	  			key += rId + ",";
    	  			String checked = "checked";
    	  		 	userPermit=sysUserPermitMap.get(rId);
    	  			if (topMenu.isDefaultPermit()) {
    	  				if (userPermit != null && !userPermit.isPermit()) {
        	  				checked = "";
        	  			}
    	  			} else {
    	  				if (userPermit == null || !userPermit.isPermit()) {
    	  					checked = "";
    	  				}
    	  			}
    	  			
    	  			%>
    	  				<input type="checkbox" id="<%=rId%>" name="<%=rId%>" rtype="true" <%=checked %>/>
    	  				<label for="<%=rId %>"><%= topMenu.getRealModleName() %>(<%=topMenu.getAction() %>)</label>
    	  				<br/><br/>
    	  			<% 
    	  			List<SysPermit> subMenus = menuMap.get(rId);
    	  			for(SysPermit subMenu : subMenus) {
    	  				boolean isUrl = subMenu.hasAction() ;
    	  				key += rId + "_"+ subMenu.getId() + ",";
    	  				checked = "checked";
    	  			 	userPermit = sysUserPermitMap.get(subMenu.getId());
        	  			if (subMenu.isDefaultPermit()) {
        	  				if (userPermit != null && !userPermit.isPermit()) { 
            	  				checked = "";
            	  			}
        	  			} else {
        	  				if (userPermit == null || !userPermit.isPermit()) {
        	  					checked = "";
        	  				}
        	  			}
    	  				%>
    	  					&nbsp;&nbsp;&nbsp;&nbsp;
    	  					<input type="checkbox" id="<%=rId%>_<%=subMenu.getId()%>" name="<%=rId%>_<%=subMenu.getId()%>" rtype="true" <%=checked %>/>
    	  					<label for="<%=rId%>_<%=subMenu.getId()%>"><%=subMenu.getRealModleName() %>(<%=subMenu.getAction() %>)</label>
    	  					<br/><br/>    	  					
    	  				<% 
    	  				if ( !isUrl ){
    	  					List<SysPermit> childPermit = menuMap.get( subMenu.getId() ) ;
    	  					if ( childPermit != null && childPermit.size() > 0 ) {
    	  						for ( SysPermit p : childPermit ) {	 
    	  							key += rId + "_"+ subMenu.getId() + "_"+p.getId()+",";
    	  							checked = "checked";
			    	  			 	userPermit = sysUserPermitMap.get(p.getId());
			        	  			if ( p.isDefaultPermit() ) {
			        	  				if ( userPermit != null && !userPermit.isPermit()) { 
			            	  				checked = "";
			            	  			}
			        	  			} else {
			        	  				if ( userPermit == null || !userPermit.isPermit() ) {
			        	  					checked = "";
			        	  				}
			        	  			}%>
			        	  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	  					<input type="checkbox" id="<%=rId%>_<%=subMenu.getId()%>_<%=p.getId() %>" name="<%=rId%>_<%=subMenu.getId()%>_<%=p.getId() %>" rtype="true" <%=checked %>/>
		    	  					<label for="<%=rId%>_<%=subMenu.getId()%>_<%=p.getId()%>"><%=p.getRealModleName() %>(<%=p.getAction() %>)</label>
		    	  					<br/><br/> 
    	  						<%}    	  						
    	  					}
    	  				}
    	  			}
    	  		}
    	  %>
    	  <input type="hidden" value="<%=key%>" name="ids"/>
    	  </td>
    	  </tr>
    	  <tr>
           			<td  align="center">
           				<a href="javascript:void(0);" id="save" class="step_btn step_org_btn"><span>保　存</span></a>
           				<a href="javascript:void(0);" id="prev" class="step_btn step_org_btn"><span>上一步</span></a>
           				<a href="javascript:void(0)"  class="step_btn step_org_btn" id="sysUserList"><span>返回列表</span></a>
           			</td>
           </tr>
          </table>
   </form>

		</div>
		
</div>
</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/userpermit.js?<%@include file='/include/.ver'%>"></script>
 <script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/dlg.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/TableList.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/qdatepicker-0.1.source.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/calendarCore.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
var initDate = function (endTimeEl) {
	 endTimeEl.qdatepicker({ ui: 'dke'});
};
initDate($("#rechargeTime"));
</script>
</html>
