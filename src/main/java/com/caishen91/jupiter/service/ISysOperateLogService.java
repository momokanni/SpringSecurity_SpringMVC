package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.SysOperateLog;
import com.caishen91.jupiter.vo.SysOperateLogVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface ISysOperateLogService {

    boolean addSysOperateLog(SysOperateLog log);

    int querySysLogCountByParam(Map<String,Object> paramMap);

    List<SysOperateLogVo> querySysLogByParam(Map<String,Object> paramMap);
}
