package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeCliqueMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeClique;
import com.caishen91.jupiter.service.IFaeICliqueService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 16 27
 * Description:
 */
@Service
public class FaeCliqueServiceImpl extends BaseService implements IFaeICliqueService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public List<FaeClique> getFaeCliqueByName(String cliqueName) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        return faeCliqueMapper.getFaeCliqueByName(cliqueName);
    }

    @Override
    public void addFaeClique(FaeClique faeClique) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        faeCliqueMapper.addFaeClique(faeClique);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeClique));
    }

    @Override
    public int queryFaeCliqueCountByParam(Map<String, Object> paramMap) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        return faeCliqueMapper.queryFaeCliqueCountByParam(paramMap);
    }

    @Override
    public List<FaeClique> queryFaeCliqueListByParam(Map<String, Object> paramMap) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        return faeCliqueMapper.queryFaeCliqueListByParam(paramMap);
    }

    @Override
    public FaeClique getFaeCliqueById(int cliqueId) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        return faeCliqueMapper.getFaeCliqueById(cliqueId);
    }

    @Override
    public FaeClique getFaeCliqueByCreditCode(String creditCode) {
        FaeCliqueMapper faeCliqueMapper = writableSQLSession.getMapper(FaeCliqueMapper.class);
        return faeCliqueMapper.getFaeCliqueByCreditCode(creditCode);
    }
}
