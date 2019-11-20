package com.caishen91.jupiter.service.impl;


import com.caishen91.jupiter.dao.SmsMapper;
import com.caishen91.jupiter.enums.SmsChannel;
import com.caishen91.jupiter.model.SmsTrace;
import com.caishen91.jupiter.model.SmsTraceDetail;
import com.caishen91.jupiter.service.ISendSmsService;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.SmsUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SendSmsServiceImpl extends BaseService implements ISendSmsService {
	
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean sendSms(SmsTrace st) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		Date d = new Date();
		st.setSeq(SmsUtil.genSeq());
		OperationResult or = SmsChannel.sendSms(st);
		st.setRet(or.getOther() + "");
		st.setLastTryTime(d);
		if (or.isSuccess()) {
			st.setStatus(SmsTrace.STATUS_SUCC);
			st.setSendTime(d);
		} else {
			st.setStatus(SmsTrace.STATUS_FAILED);
		}
		//st.setChannel(Config.SMS_CHANNEL);
		
		smsMapper.sendSms(st);
		
		SmsTraceDetail std = new SmsTraceDetail();
		std.setTraceId(st.getId());
		std.setTryTime(d);
		std.setMobile(st.getMobile());
		std.setContent(st.getContent());
		std.setRet(st.getRet());
		
		if (or.isSuccess()) {
			std.setSucc((short)1);
		} else {
			std.setSucc((short)0);
		}
		std.setChannel(st.getChannel());//短信渠道
		std.setTemplate(st.getTemplate());//短信模板
		std.setSeq(st.getSeq());
	 
//		std.setMobiles(st.getMobiles());//群发电话
		
		
		smsMapper.addSmsTraceDetail(std);
		return true;
	}
	

}
