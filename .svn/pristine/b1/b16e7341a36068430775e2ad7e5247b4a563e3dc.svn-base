package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeUnderwriterMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeUnderwriter;
import com.caishen91.jupiter.service.IFaeUnderwriterService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 30
 * Description:
 */
@Service
public class FaeUnderwriterServiceImpl extends BaseService implements IFaeUnderwriterService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public List<FaeUnderwriter> getFaeUnderwriterBySgt(String keys) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        return faeUnderwriterMapper.getFaeUnderwriterBySgt(keys);
    }

    @Override
    public void addFaeUnderwriter(FaeUnderwriter faeUnderwriter) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        faeUnderwriterMapper.addFaeUnderwriter(faeUnderwriter);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeUnderwriter));
    }

    @Override
    public int queryFaeUnderwriterCountByParam(Map<String, Object> paramMap) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        return faeUnderwriterMapper.queryFaeUnderwriterCountByParam(paramMap);
    }

    @Override
    public List<FaeUnderwriter> queryFaeUnderwriterListByParam(Map<String, Object> paramMap) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        return faeUnderwriterMapper.queryFaeUnderwriterListByParam(paramMap);
    }

    @Override
    public FaeUnderwriter getFaeUnderwriterById(int underwriterId) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        return faeUnderwriterMapper.getFaeUnderwriterById(underwriterId);
    }

    @Override
    public List<FaeUnderwriter> getFaeUnderwriterByIds(List<Integer> underwriterIds) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("underwriterIds", underwriterIds);

        return faeUnderwriterMapper.getFaeUnderwriterByIds(paramMap);
    }

    @Override
    public FaeUnderwriter getFaeUnderwriterByCreditCode(String creditCode) {
        FaeUnderwriterMapper faeUnderwriterMapper = writableSQLSession.getMapper(FaeUnderwriterMapper.class);
        return faeUnderwriterMapper.getFaeUnderwriterByCreditCode(creditCode);
    }
}
