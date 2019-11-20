<%@page import="com.xiaoyoucai.jinfu.util.Config"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String port = request.getServerPort()==80?"":":"+request.getServerPort();
String scheme = "http";
Boolean ssl = (Boolean)request.getAttribute("ssl");
if (ssl != null && ssl) {
	scheme = "https";
}
String basePath = scheme+"://"+request.getServerName()+port+path+"/";
%>
<c:set value="<%=basePath %>" var="ctx"/>
<script type="text/javascript" src="/resource/js/<%=Config.FRONT_PREFIX %>/common/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="/resource/js/<%=Config.FRONT_PREFIX %>/common/banner.js"></script> 
<script type="text/javascript" src="/resource/js/<%=Config.FRONT_PREFIX %>/common/banner_1.js"></script>
<script type="text/javascript" src="/resource/js/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/resource/include/.ver'%>"></script>
<script type="text/javascript">var address="${ctx}";
(function() {
	var _skin="blue", _jQuery;
	document.write('<scr'+'ipt src="/resource/js/<%=Config.FRONT_PREFIX %>/common/jquery.artDialog.js?skin=' + (_skin || 'default') +'"></sc'+'ript>');
	window._isDemoSkin = !!_skin;
})();
</script>
<link href="/resource/css/common/base.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/layout.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/forms.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/font.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/xdk.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/common.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />


<link href="/resource/css/common/web/module.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/web/base.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/web/font.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />
<link href="/resource/css/common/web/mend.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" />

<c:set var="moneyexp" value="#,##0.00#"></c:set>
<c:set var="moneyexpInt" value="#"></c:set>
