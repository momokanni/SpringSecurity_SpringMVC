package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeInvestorMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeInvestor;
import com.caishen91.jupiter.service.IFaeInvestorService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FaeInvestorServiceImpl extends BaseService implements IFaeInvestorService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public void addFaeInvestor(FaeInvestor faeInvestor) {
        FaeInvestorMapper faeInvestorMapper = writableSQLSession.getMapper(FaeInvestorMapper.class);
        faeInvestorMapper.addFaeInvestor(faeInvestor);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeInvestor));
    }

    @Override
    public int queryFaeInvestorCountByParam(Map<String, Object> paramMap) {
        FaeInvestorMapper faeInvestorMapper = writableSQLSession.getMapper(FaeInvestorMapper.class);
        return faeInvestorMapper.queryFaeInvestorCountByParam(paramMap);
    }

    @Override
    public List<FaeInvestor> queryFaeInvestorListByParam(Map<String, Object> paramMap) {
        FaeInvestorMapper faeInvestorMapper = writableSQLSession.getMapper(FaeInvestorMapper.class);
        return faeInvestorMapper.queryFaeInvestorListByParam(paramMap);
    }

    @Override
    public FaeInvestor getFaeInvestorById(int investorId) {
        FaeInvestorMapper faeInvestorMapper = writableSQLSession.getMapper(FaeInvestorMapper.class);
        return faeInvestorMapper.getFaeInvestorById(investorId);
    }
}
