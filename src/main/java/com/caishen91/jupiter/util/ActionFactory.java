package com.caishen91.jupiter.util;


public class ActionFactory {
	
	public static final String OPTYPE_SCRIPT = "script";
	public static final String OPTYPE_LINK = "link";
	public static final String OPTYPE_SCRIPT_EX = "scriptEx";//外部绑定方法，不使用通用方法
	public static final String TARGET_SELF = "_self";
	public static final String TARGET_BLANK = "_blank";
	public static final String REQ_TYPE_LINK = "link";
	public static final String REQ_TYPE_DIV = "div";
	public static final String REQ_TYPE_CONFIRM = "confirm";
	public static final String REQ_TYPE_PAGE = "page";
	
	public static final String COMMON_DETAIL = "详情";
	
	public static final String PAGE_DETAIL = "页面详情";
	
	public static final String FIELD_DETAIL = "字段详情";
	
	public static final String OPTION_DETAIL = "选项详情";
	
	public static final String DAI_COMMUTE = "代偿还款";
	//分类查看删除
	public static final String CATEGORY_LOOK="查看";
	public static final String CATEGORY_REUSE="恢复";
	public static final String CATEGORY_DEL="删除";
	//账户信息
	public static final String SYSUSER_LOOK="查看";
	public static final String SYSUSER_ONLINE="启用";
	public static final String SYSUSER_OFFLINE="禁用";
	public static final String SYSUSER_CANCEL="作废";
	public static final String SYSUSER_REUSE="恢复";
	public static final String SYSUSER_PWD="修改密码";
	public static final String SUGGEST_DZ_UPDATE="更改";
	public static final String ALLOT_AUTH="权限";
	public static final String AUTHENTICATION="认证";
	
	public static final String JZLOAN_OFFLINE="拒绝";
	public static final String JZLOAN_PASS="通过"; 
	
	public static final String HREF_EMPTY = "javascript:void(0)";
	
	//充值管理
	public static final String TRANSFER_RECORD_RECHARGE = "充值";
	
	public static final String MANAGER_ACCOUNT_APPLY_USER_LOAN_DETAIL = "settlement_detail";
	
	public static final String MANAGER_ACCOUNT_APPLY_USER_REPAYING_LOAN_DETAIL = "settlement_repaying_loan_detail";
	
	public static final String MANAGER_ACCOUNT_APPLY_USER_REPAYED_LOAN_DETAIL = "settlement_repayed_loan_detail";
	
	public static final String TRANSFER_TASK_RESCHEDULE = "重新发起";
	
	public static final String TRANSFER_TASK_REHANDLE = "重新入库";
	
	public static final String TRANSFER_TASK_QUERY = "联动查询";

	public static final String MANAGER_ACCOUNT_APPLY_USER_REPAY = "立即还款";
	
	public static final String MANAGER_USE_LOAN_AMOUNT = "调用";
	
	public static final String MANAGER_REPAY_LOAN_AMOUNT = "归还";
	
	//全部标的查看
	public static final String ALLLOAN_LOOK="查看";
	
	//标管理操作信息
	public static final String LOANDANBAOINSTANCE = "初审";
	public static final String LOANDANBAOPAY = "支付息佣";

	public static final String LOANFIRSTINSTANCE = "查看";
	public static final String LOANONLINE="排期";//"审核通过";
	public static final String LOANONLINEMODIF="修改";
	public static final String LOANONLINEOFFINE="撤回";
	public static final String LOANOFFLINE="退回";
	public static final String LOOKLOANINVERSOT="投资记录";
	public static final String LOOKLOANINVERSOTDetail="详情";
	public static final String LOOKLOAN="查看";
	public static final String BAODIPAY="保证金充值";
	public static final String BAODIREPAY="保证金回充";
	public static final String JMJLOOKLOAN="查看标的";
	public static final String LOANStart="恢复";
	public static final String TRANLOANONWAIT="审核";//二手标审核;
	public static final String LOOKTRANSLOANINVERSOTDetail="详情";
	public static final String TRANSFEECANCEL="手续费取消";
	public static final String LOANTRANSLINEOFFINE="撤回";
	public static final String DIV_LOAN_OFFLINE="offline_div";//退回标
	public static final String DIV_LOAN_ONLINE = "online";
	public static final String DIV_LOAN_DANBAOINSTANCE = "danbao_instance"; //担保公司审核
	public static final String DIV_LOAN_DANBAOPAY = "danbao_pay"; //担保公司审核
	public static final String DIV_LOAN_ONLINE_OFFLINE="online_off";//撤回
	public static final String DIV_TRANLOANON_WAIT="wait_div";//二手标审核div;
	public static final String SELECT_CATEGORY="请选择知识库分类";
	public static final String DIV_SELECT_CATEGORY="category_div";
	
	public static final String LOANAPPLYUSER_LOOKDETAIL="查看";
	public static final String LOANAPPLYUSER_PASS="通过";
	public static final String  LOANAPPLYUSER_JMJCP="初评";
	public static final String  LOANAPPLYUSER_CSTJ="提交初评";
	public static final String LOANAPPLYUSER_REFUSE="驳回";
	public static final String LOANAPPLYUSER_REFUSEBACK="恢复";
	public static final String LOANAPPLYUSER_XCPG="预约现场评估";
	public static final String LOANAPPLYUSER_QY="签约";
	public static final String LOANAPPLYUSER_JMJQY="查看";
	public static final String LOANAPPLYUSER_ADDLOAN="创建标的";
	public static final String DIV_LOANAPPLYUSER_REFUSE="refuse_div";//驳回
	public static final String DIV_LOANAPPLYUSER_BORROWREFUSE="borrow_refuse_div";//用户拒绝初评
	public static final String DIV_LOANAPPLYUSER_SIGNREFUSE="sign_refuse_div";//用户拒绝初评
	public static final String DIV_LOANCAR_PRICE="loanCar_price";//车参考网站
	public static final String DIV_UPDATELOANCAR_PRICE="update_price";//修改车参考网站
	public static final String LOanCarUPDATPRICE="修改";//修改车参考网站
	public static final String CONFIG_AUTH="配置权限";
	
	public static final String YG_ADDLOANAPPLYUSER = "yg_addlau";
	
	//车抵押信息
	public static final String LOANCAR_LOOK="查看";
	public static final String LOANCAR_LOOKCar="查看车辆";
	public static final String LOANCAR_DELETE="删除";
	public static final String LOANCAR_MODIFY="评估";
	public static final String LOANCAR_KHQR="待车主确认";
	public static final String LOAN_JMJREPAY="保底还款";
	public static final String DIV_LOANCAR_ENDPRICE="endPrice_div";//初评保底家
	public static final String DIV_LOANCAR_LASTENDPRICE="lastEndPrice_div";//现场保底价评估
	
	public static final String DIV_JMJ_DANBAO_BZJ_CHARGE="jmj_danbao_bzj_charge";//金马甲保证金充值
	
	
	public static final String DIV_BAODI_REPAY = "jmj_baodi_repay"; //金马甲保底还款
	//借款申请提交临时表
	public static final String APPLYUSETEMPPASS="通过";
	public static final String APPLYUSETEMPLOOK="查看";
	public static final String APPLYUSETEMPREFUSE="禁用";
	public static final String APPLYUSETEMPSTART="恢复";
	public static final String LOANCARYUSR_LOOK="查看";
	
	//企业用户添加
	public static final String APPLYUSERDELETE="禁用";
	public static final String APPLYUSERDSTART="启用";
	public static final String APPLYUSERDSTOP="停用";
	public static final String APPLYUSERDLOOK="查看";
	public static final String APPLYYUSERREMOVE="移除";
	
	
	//企业投资用户添加
	public static final String SYSUSERDELETE="禁用";
	public static final String SYSUSERDSTART="启用";
	public static final String SYSUSERDLOOK="查看";
	public static final String SYSYUSERREMOVE="移除";
	
	//机构管理
	public static final String COMPANYDELETE="禁用";
	public static final String COMPANYSTART="启用";
	public static final String COMPANYLOOK="查看";
	public static final String COMPANYCONTACTDELETE="删除";
	public static final String COMPANYCONTACTMODIFY="修改";
	public static final String DIV_COMPANYCONTACT_MODIFY="modify_contact";//修改紧急联系人
	
	
	//担保公司
	public static final String DANBAODELETE="停用";
	public static final String DANBAOSTART="启用";
	public static final String DANBAOLOOK="查看";
	public static final String SHOWDANBAO="线上展示";
	public static final String NOSHOWDANBAO="取消展示";
	
	//合作伙伴
	public static final String SYSPARTNER_LOOK="查看";
	public static final String SYSPARTNER_OFFLINE="禁用";
	public static final String SYSPARTNER_ONLINE="启用";
	public static final String SYSPARTNER_UPDATE="修改";
	
	//分享设置
	public static final String SHARECONFIG_UPDATE="修改";
	public static final String SHARECONFIG_ENABLED="启用";
	public static final String SHARECONFIG_DISABLED="停用";
	
	//标的借款人
	public static final String LOANBORROWER_EDIT = "查看";
	public static final String LOANBORROWER_ONLIE = "启用";
	public static final String LOANBORROWER_OFFLINE = "禁用";
	
	//广告位
	public static final String SHAREAD_LOOK = "查看";
	public static final String SHAREAD_ONLINE = "上线";
	public static final String SHAREAD_OFFLINE = "下线";
	
	public static final String RAISEINTEREST_CANCEL="取消助力加息";
	public static final String RAISEINTEREST_START="启动助力加息";
	
	public static final String AGENTORDER_LOOK = "查看";
	
	// 公众号-- 子账号
	public static final String BM_ACCOUNT_USE = "启用";
	public static final String BM_ACCOUNT_UN_USE = "停用";
	public static final String BM_ACCOUNT_PWD_RESET = "重置密码";
	public static final String BM_ACCOUNT_DEL = "删除账号";
	
	// 公众号-- 标签
	public static final String BLOG_LABEL_UN_USE = "禁用";
	public static final String BLOG_LABEL_EDIT = "编辑";
	
	// 公众号-- 文章管理
	public static final String ARTICLE_UN_USE = "下线";
	public static final String ARTICLE_LOOK = "查看";
	
	
	public static Action build(){
		return new Action();
	}
	
	public static Action build(String op,String url){
		return build(op,"",TARGET_SELF,OPTYPE_SCRIPT,url,"","");
	}

	/**
	 *
	 * @param op
	 * @param url
	 * @param target:新窗口打开，还是在原来窗口打开
	 * @param opType link: 表示这是个链接，script:js
	 * @param data_url:弹框提交数据的url
	 * @param req_type:div/link
	 * @param div_type:弹框的js的id,来决定弹出哪个js定义的弹框
	 * @return
	 */
	public static Action build(String op, String url, String target,
								String opType, String data_url, 
								String req_type, String div_type){
		Action action = new Action();
		if(StringUtil.isNotEmpty(op)){
			action.setOp(op.trim());
		}
		if (OPTYPE_SCRIPT.equals(opType)) {
			action.setUrl("javascript:void(0)");
		} else {
			if(StringUtil.isNotEmpty(url)){
				action.setUrl(url.trim());
			}
		}
		if(StringUtil.isNotEmpty(target)){
			action.setTarget(target.trim());
		}
		if(StringUtil.isNotEmpty(opType)){
			action.setOpType(opType.trim());
		}
		action.setData_url(data_url);
		action.setReq_type(req_type);
		action.setDiv_type(div_type);
		return action;
	}
	
	public static Action build(String op, String url, String target,
			String opType, String data_url, 
			String req_type, String div_type,String confirm_desc){
		Action action = new Action();
		if(StringUtil.isNotEmpty(op)){
		action.setOp(op.trim());
		}
		if (OPTYPE_SCRIPT.equals(opType)) {
		action.setUrl("javascript:void(0)");
		} else {
		if(StringUtil.isNotEmpty(url)){
		action.setUrl(url.trim());
		}
		}
		if(StringUtil.isNotEmpty(target)){
		action.setTarget(target.trim());
		}
		if(StringUtil.isNotEmpty(opType)){
		action.setOpType(opType.trim());
		}
		action.setData_url(data_url);
		action.setReq_type(req_type);
		action.setDiv_type(div_type);
		
		action.setConfirm_desc(confirm_desc);
		return action;
}
	

	/**
	 * 菜单项链接跳转
	 * @param op
	 * @param url
	 * @param target
	 * @param opType
	 * @param data_url
	 * @param req_type
	 * @param div_type
	 * @param confirm_desc
	 * @param hf
	 * @return
	 */
	public static Action build(String op, String url, String target,
			String opType, String data_url, 
			String req_type, String div_type,String confirm_desc,String tag,String hf){
		Action action = new Action();
		if(StringUtil.isNotEmpty(op)){
		action.setOp(op.trim());
		}
		if (OPTYPE_SCRIPT.equals(opType)) {
		action.setUrl("javascript:void(0)");
		} else {
		if(StringUtil.isNotEmpty(url)){
		action.setUrl(url.trim());
		}
		}
		if(StringUtil.isNotEmpty(target)){
		action.setTarget(target.trim());
		}
		if(StringUtil.isNotEmpty(opType)){
		action.setOpType(opType.trim());
		}
		action.setData_url(data_url);
		action.setReq_type(req_type);
		action.setDiv_type(div_type);
		
		action.setConfirm_desc(confirm_desc);
		if(StringUtil.isNotEmpty(tag)){
			action.setTag(tag);
		}
		
		if(StringUtil.isNotEmpty(hf)){
			action.setHf(hf);
		}
		return action;
}
	
	
	
}
