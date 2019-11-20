package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FaeIssueMapper;
import com.caishen91.jupiter.factory.SysOperateLogFactory;
import com.caishen91.jupiter.model.FaeIssue;
import com.caishen91.jupiter.service.IFaeIssueService;
import com.caishen91.jupiter.service.ISysOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 37
 * Description:
 */
@Service
public class FaeIssueServiceImpl extends BaseService implements IFaeIssueService {

    @Autowired
    private ISysOperateLogService sysOperateLogService;

    private int sysUserId;

    @Override
    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public List<FaeIssue> getFaeIssueByName(String keys) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getFaeIssueByName(keys);
    }

    @Override
    public void addFaeIssue(FaeIssue faeIssue) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        faeIssueMapper.addFaeIssue(faeIssue);

        sysOperateLogService.addSysOperateLog(SysOperateLogFactory.addMemberLog(sysUserId, faeIssue));
    }

    @Override
    public List<FaeIssue> getFaeIssueByCliqueId(int cliqueId) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getFaeIssueByCliqueId(cliqueId);
    }

    @Override
    public int getFaeIssueCountByCliqueId(int cliqueId) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getFaeIssueCountByCliqueId(cliqueId);
    }

    @Override
    public int queryFaeIssueCountByParam(Map<String, Object> paramMap) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.queryFaeIssueCountByParam(paramMap);
    }

    @Override
    public List<FaeIssue> queryFaeIssueListByParam(Map<String, Object> paramMap) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.queryFaeIssueListByParam(paramMap);
    }

    @Override
    public FaeIssue getFaeIssueById(int issueId) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getFaeIssueById(issueId);
    }

    @Override
    public FaeIssue getFaeIssueByCreditCode(String creditCode) {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getFaeIssueByCreditCode(creditCode);
    }

    @Override
    public int getCountIssue() {
        FaeIssueMapper faeIssueMapper = writableSQLSession.getMapper(FaeIssueMapper.class);
        return faeIssueMapper.getCountIssue();
    }
}
