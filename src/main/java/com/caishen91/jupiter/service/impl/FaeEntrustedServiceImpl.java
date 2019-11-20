package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeEntrustedMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeEntrusted;
import com.caishen91.jupiter.service.IFaeEntrustedService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 29
 * Description:
 */
@Service
public class FaeEntrustedServiceImpl extends BaseService implements IFaeEntrustedService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public List<FaeEntrusted> getFaeEntrustedBySgt(String keys) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        return faeEntrustedMapper.getFaeEntrustedBySgt(keys);
    }

    @Override
    public void addFaeEntrusted(FaeEntrusted faeEntrusted) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        faeEntrustedMapper.addFaeEntrusted(faeEntrusted);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeEntrusted));
    }

    @Override
    public int queryFaeEntrustedCountByParam(Map<String, Object> paramMap) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        return faeEntrustedMapper.queryFaeEntrustedCountByParam(paramMap);
    }

    @Override
    public List<FaeEntrusted> queryFaeEntrustedListByParam(Map<String, Object> paramMap) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        return faeEntrustedMapper.queryFaeEntrustedListByParam(paramMap);
    }

    @Override
    public FaeEntrusted getFaeEntrustedById(int entrustedId) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        return faeEntrustedMapper.getFaeEntrustedById(entrustedId);
    }

    @Override
    public FaeEntrusted getFaeEntrustedByCreditCode(String creditCode) {
        FaeEntrustedMapper faeEntrustedMapper = writableSQLSession.getMapper(FaeEntrustedMapper.class);
        return faeEntrustedMapper.getFaeEntrustedByCreditCode(creditCode);
    }
}
