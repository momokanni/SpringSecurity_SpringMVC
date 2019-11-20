package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.SysOperateLogMapper;
import com.caishen91.jupiter.model.SysOperateLog;
import com.caishen91.jupiter.service.ISysOperateLogService;
import com.caishen91.jupiter.vo.SysOperateLogVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/27/19 18 01
 * Description:
 */
@Service
public class SysOperateLogServiceImpl extends BaseService implements ISysOperateLogService {
    @Override
    public int querySysLogCountByParam(Map<String, Object> paramMap) {
        SysOperateLogMapper logMapper = writableSQLSession.getMapper(SysOperateLogMapper.class);
        return logMapper.querySysLogCountByParam(paramMap);
    }

    @Override
    public List<SysOperateLogVo> querySysLogByParam(Map<String, Object> paramMap) {
        SysOperateLogMapper logMapper = writableSQLSession.getMapper(SysOperateLogMapper.class);
        return logMapper.querySysLogByParam(paramMap);
    }

    @Override
    public boolean addSysOperateLog(SysOperateLog log) {
        SysOperateLogMapper logMapper = writableSQLSession.getMapper(SysOperateLogMapper.class);

        try {
            logMapper.addSysOperateLog(log);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
