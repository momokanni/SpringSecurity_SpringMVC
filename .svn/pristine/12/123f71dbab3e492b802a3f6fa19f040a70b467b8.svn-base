<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.model.BlogManager" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.enums.BlogType" %>
<%@ page import="com.caishen91.jupiter.enums.BlogManagerType" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
    BlogManager blogManager=(BlogManager)request.getAttribute("blogManager");
    Blog blog=(Blog)request.getAttribute("blog");

    String  passwd = "******";
    String str="";
    if(blogManager.getCardNo()!=null) {
        //对身份证进行处理
        String cardId = blogManager.getCardNo();
        String cardStr = cardId.substring(6, 14);
         str = cardId.replace(cardStr, "********");
    }

    StringBuffer sb = new StringBuffer();
    if(blogManager.getNickName()!=null){
        //对姓名进行处理
        String name=blogManager.getNickName();
        String reg = ".{1}";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(name);
        int i = 0;
        while(m.find()){
            i++;
            if(i==1)
                continue;
            m.appendReplacement(sb, "*");
        }
        m.appendTail(sb);
    }
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/setup.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">

<script>
    var time_stamp = '<%@include file='/include/.ver'%>';
    var fileServer = "<%=Config.IMAGE_DISPLAY_PATH %>";
</script>
</head>

<body class="bg">
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>


<!--右侧内容 文章详情-->
<div id="mainbody" class="mainbody">

    <div class="bigtitle mt20"><b class="ft22 fapf">账号基本信息设置</b></div>


    <form action="/blog/updateBlog" method="post" id="frm" accept-charset="UTF-8">
    <input name="blogId" id="blogId" type="hidden" value="<%=IDEncryptor.getInstance().encryptWithoutException(blog.getId())%>">
    <!--账号基本信息设置-->
	    <div class="clearfix mt15 bgf radius3 shadow pd30 plr75 ">
	        <div class="set_tx shadow pr dn">
	            <a href="javascript:void(0)" class="a_box">
	                <span class="ft14 colf">点击更换</span>
	            </a>
	        </div>
	
	        <div class="clearfix pd30">
	            <dl class="set_li set_tx02">
	                <dt class="fl ft14 colgray">头像</dt>
	                <dd class="fr">
	                	<security:authorize access="hasRole('SCZFXTX')">
		                    <div class="usertx tx01">
		                        <input id="headPath" type="hidden" value="" name="headImg" />
		                        <a href="javascript:void(0)" class="a_box pr"   id="drop_head">
		                            <div class="shadingblue shadow_blue button colf ft14 usertx_btn" >上传头像</div>
		                            <div class="usertxbg " >
		                                <!--img头像-->
		                                <%if(blog.getHeadImg()!=null){%>
		                                <img src="<%=blog.getHeadImg()%>">
		                                <%}%>
		
		                            </div>
		                        </a>
		                        <p class="colgray04 ft12">正方形尺寸：<span class="colred">200*200</span>像素</p>
		                    </div>
		                </security:authorize>
		                <security:authorize access="!hasRole('SCZFXTX')">
		                	 <div class="usertx tx01">
		                	 		<div class="usertxbg " >
		                                <!--img头像-->
		                                <%if(blog.getHeadImg()!=null){%> <img src="<%=blog.getHeadImg()%>"> <%}%>
		                            </div>
		                	 </div>
		                </security:authorize>
	
						<security:authorize access="hasRole('SCCFXTX')">
		                    <div class="usertx tx02">
		                        <input id="headPathMb" type="hidden" value="" name="headImgMb" />
		                        <a href="javascript:void(0)" class="a_box pr" id="drop_headMb">
		                            <div class="shadingblue shadow_blue button colf ft14 usertx_btn"  >上传头像</div>
		                            <div class="usertxbg">
		                                <!--img头像-->
		                                <%if(blog.getHeadImgMb()!=null){%>
		                                <img src="<%= blog.getHeadImgMb()%>">
		                                <%}%>
		                            </div>
		                        </a>
		                        <p class="colgray04 ft12">长方形尺寸：<span class="colred">200*78</span>像素</p>
		                    </div>
		                 </security:authorize>
		                 <security:authorize access="!hasRole('SCCFXTX')">
		                 		<div class="usertx tx02">
		                 			<div class="usertxbg">
		                                <!--img头像-->
		                                <%if(blog.getHeadImgMb()!=null){%> <img src="<%= blog.getHeadImgMb()%>"> <%}%>
		                            </div>
		                 		</div>
		                 </security:authorize>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">公众号名称</dt>
	                <dd class="fr">
	                    <input type="text" name="blogName" value="<%= blog.getName()!=null ? blog.getName() : "未设置"%>" class="ft16 fl" id="blogName" disabled="disabled"><!--不可点击添加 disabled="disabled" ,可点击去掉-->
	                    <security:authorize access="hasRole('XGSHMC')">
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="xggzhmc" id="xggzhmc">修改</a><!--点击修改后，文字变成" 确定 "-->
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="qdgzhmc" id="qdgzhmc" style="display: none">确定</a>
	                    </security:authorize>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">公众号描述</dt>
	                <dd class="fr">
	                    <input type="text" name="description" id="description" value="<%=blog.getDescription()!=null ? blog.getDescription() : "未设置"%>" class="ft16 fl"  disabled="disabled"><!--不可点击添加 disabled="disabled" ,可点击去掉-->
	                    <security:authorize access="hasRole('XGSHMC')">
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="xggzhms" id="xggzhms">修改</a><!--点击修改后，文字变成" 确定 "-->
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="qdgzhms" id="qdgzhms" style="display: none">确定</a>
	                    </security:authorize>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">类型</dt>
	                <dd class="fr">
	                    <span class="ft16 fl"><%=blog!=null ? BlogType.getBlogType(blog.getType()).getMsg() : ""%></span>
	                </dd>
	            </dl>
	            <%if(blog.getType()==BlogType.COMPANY.getType()){%>
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">社会信用代码</dt>
	                <dd class="fr">
	                    <span class="ft16 fl"><%=blog.getScc()!=null ? blog.getScc() : "暂无"%></span>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">企业名称</dt>
	                <dd class="fr">
	                    <span class="ft16 fl"><%=blog!=null ? blog.getEnterpriseName() : ""%></span>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">公司邮箱</dt>
	                <dd class="fr">
	                    <input type="text" name="email" id="email" value="<%= blog.getEmail()!=null ? blog.getEmail() : "暂无"%>" class="ft16 fl" disabled="disabled" ><!--不可点击添加 disabled="disabled" ,可点击去掉-->
	                    <security:authorize access="hasRole('XGSHMC')">
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="xgyx" id="xgyx">修改</a><!--点击修改后，文字变成" 确定 "-->
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="qdyx" id="qdyx" style="display: none">确定</a>
	                    </security:authorize>
	                </dd>
	            </dl>
	            <%}%>
	
	            <%if(blog.getType()==BlogType.PERSONAL.getType()){%>
		            <dl class="set_li">
		                <dt class="fl ft14 colgray">姓名</dt>
		                <dd class="fr">
		                    <span class="ft16 fl"><%=blogManager!=null ? sb.toString() : ""%></span>
		                </dd>
		            </dl>
		
		            <dl class="set_li">
		                <dt class="fl ft14 colgray">身份证号</dt>
		                <dd class="fr">
		                    <span class="ft16 fl"><%=blogManager.getCardNo()!=null ? str : "暂无"%></span>
		                </dd>
		            </dl>
	            <%}%>
	        </div>
	    </div>
	    
	    <div class="bigtitle mt50"><b class="ft22 fapf">接口设置</b></div>
	    <!--登录信息-->
	    <div class="clearfix mt15 bgf radius3 shadow plr35" style="padding-bottom:20px">
	        <div class="clearfix pd30">
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">文章推送接口</dt>
	                <dd class="fr">
	                    <input type="text" name="pushUrl" id="pushUrl" value="<%= blog.getPushUrl()!=null ? blog.getPushUrl() : "暂无"%>" class="ft16 fl" disabled="disabled" ><!--不可点击添加 disabled="disabled" ,可点击去掉-->
	                    <security:authorize access="hasRole('XGSHMC')">
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="xgtsjk" id="xgtsjk">修改</a><!--点击修改后，文字变成" 确定 "-->
	                    	<a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="qdtsjk" id="qdtsjk" style="display: none">确定</a>
	                    </security:authorize>
	                </dd>
	            </dl>
	        </div>
	    </div>
     </form>
    <!--账号基本信息设置 end-->
     <%if(blog.getType()==BlogType.COMPANY.getType()){%>
	    <div class="bigtitle mt50"><b class="ft22 fapf">管理员信息</b></div>
	    <!--管理员信息-->
	    <div class="clearfix mt15 bgf radius3 shadow plr35" style="padding-bottom:20px">
	        <div class="clearfix pd30">
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">管理员</dt>
	                <dd class="fr">
	                    <span class="ft16 fl"><%=blogManager!=null ? sb.toString() : ""%></span>
	                </dd>
	            </dl>
	
	            <dl class="set_li">
	                <dt class="fl ft14 colgray">身份证号</dt>
	                <dd class="fr">
	                    <span class="ft16 fl"><%=blogManager.getCardNo()!=null ? str : "暂无"%></span>
	                </dd>
	            </dl>
	        </div>
	    </div>
    <%}%>
    <!--管理员信息 end-->

    <div class="bigtitle mt50"><b class="ft22 fapf">登录信息</b></div>
    <!--登录信息-->
    <div class="clearfix mt15 bgf radius3 shadow plr35" style="padding-bottom:20px">
        <div class="clearfix pd30">
            <dl class="set_li">
                <dt class="fl ft14 colgray">账号</dt>
                <dd class="fr">
                    <span class="ft16 fl"><%=blogManager.getMobile()!=null ? blogManager.getMobile() : "暂无" %></span>
                </dd>
            </dl>

            <dl class="set_li">
                <dt class="fl ft14 colgray">密码</dt>
                <security:authorize access="hasRole('XGYSMM')">
	                <dd class="fr">
	                    <span class="ft16 fl"><%=passwd%></span>
	                    <a href="javascript:void(0)" class="colblue02 colbule_hov fr" op="xgmm" id="xgmm">修改</a>
	                </dd>
	            </security:authorize>
            </dl>
        </div>
    </div>
    <!--登录信息 end-->
    
    <!--公用底部-->
    <div id="footer" class="footer textcent ft12 clearfix">
        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
    </div>
    <!--公用底部 end-->

</div>
<!--右侧内容 文章详情 end-->


<!--修改密码 弹框-->
<form action="/blog/updatePwd" method="post" id="frmPwd" accept-charset="UTF-8">
    <input name="blogMangerId" id="blogMangerId" type="hidden" value="<%=IDEncryptor.getInstance().encryptWithoutException(blogManager.getId())%>">
	<div class="dn" id="dialogPasswd">
	    <div class="zhezhao"></div>
	    <div class="tk_box radius3 bgf" style="margin-top:-135px">
	        <div class="tk_top ft14 colgray02 plr20"><a href="#" op="qx" class="icon tk_close fr"></a>修改密码</div>
	        <div class="screen_inp mt30" style=" padding-left:46px">
	            <span class="fl ft14 colgblock">&nbsp;&nbsp;&nbsp;原密码：</span>
	            <input type="password" placeholder="" name="oldPwd" id="oldPwd" class="inputbox" style="width:210px" onblur="findOldPwd(<%=blogManager.getId()%>)">
	        </div>
	        <span class="ft14 colred block ymmcw dn" style="padding-left:122px; padding-top:2px">密码错误</span>
	
	        <div class="screen_inp mt15" style=" padding-left:46px">
	            <span class="fl ft14 colgblock">&nbsp;&nbsp;&nbsp;新密码：</span>
	            <input type="password" placeholder="" name="newPwd" id="newPwd" class="inputbox" style="width:210px" onblur="yzNewPwd()">
	        </div>
	        <span class="ft14 colred block dn" style="padding-left:122px; padding-top:2px">密码错误</span>
	
	        <div class="screen_inp mt15" style=" padding-left:46px">
	            <span class="fl ft14 colgblock">确认密码：</span>
	            <input type="password" placeholder=""  name="pwdCas" id="pwdCas" class="inputbox" style="width:210px" onblur="newPwdCas()">
	        </div>
	        <span class="ft14 colred block mmyz dn" style="padding-left:122px; padding-top:2px">两次密码不一致</span>
	
	        <div class="tk_btn mt20">
	            <a href="javascript:void(0)"  op="qx" id="qx" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
	            <a href="javascript:void(0)" op="qrxg" id="qrxg" class="button bgrblue bgrblue_hov colf transition border_blue ft14">确认修改</a></div>
	    </div>
	</div>
</form>
<!--修改密码 弹框 end-->
<form id="frm_uhead" method="post" enctype="multipart/form-data">
    <input type="file" style="width:0px;height:0px" id="uhead" name="uhead" tar="uhead" accept="image/*" >
    <input type="hidden" style="display:none" name="w" value="221"/>
    <input type="hidden" style="display:none" name="h" value="150"/>
</form>
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/blogPlatform/accountSetting.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/uploadHeadImg.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>

<script>
    // -------------- uploadHead-------------------
    var dragImgUpload = new DragImgUploadTx("#drop_head",{
        callback:function (files) {
            //回调函数，可以传递给后台等等
            var file = files[0];
            var form = new FormData();
            form.append("headImg",file);
            $.ajax({
                url:"/blog/upload/headImg",
                data:form,
                type:"post",
                processData:false,
                contentType:false,
                success:function(data){
                    if (0 == data.ret) {

                        successTips("上传成功");
                        $("#headPath").attr("value",data.data);

                            setTimeout(function() {
                                location.href = "/blog/accountSetting";
                            }, 1000);

                    } else {
                        errorTips("上传失败");
                    }
                },
                error:function(data){
                }
            });
        }
    });

    // -------------- uploadHead-------------------
    var dragImgUploadMb = new DragImgUploadTx("#drop_headMb",{
        callback:function (files) {
            //回调函数，可以传递给后台等等
            var file = files[0];
            var form = new FormData();
            form.append("headImgMb",file);
            $.ajax({
                url:"/blog/upload/headImgMb",
                data:form,
                type:"post",
                processData:false,
                contentType:false,
                success:function(data){
                    if (0 == data.ret) {
                        successTips("上传成功");
                        $("#headPathMb").attr("value",data.data);
                            setTimeout(function() {
                                location.href = "/blog/accountSetting";
                            }, 1000);

                    } else {
                        errorTips("上传失败");
                    }
                },
                error:function(data){
                }
            });
        }
    });
</script>
</html>


